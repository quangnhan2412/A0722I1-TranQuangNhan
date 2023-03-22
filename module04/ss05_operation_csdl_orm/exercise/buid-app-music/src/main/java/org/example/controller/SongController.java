package org.example.controller;

import org.example.entity.Song;
import org.example.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("music")

public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("")
    public String displaySong(Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Song song) {
//        song.setId((int) (Math.random() * 1000));
        song.setId(null);
        songService.create(song);
        return "redirect:/music";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songService.finById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Song song) {
        songService.update(song);
        return "redirect:/music";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("song",songService.finById(id));
        return "/delete";
    }
    @PostMapping("/delete")
    public  String delete(Song song, RedirectAttributes redirectAttributes){
            songService.remove(song.getId());
            redirectAttributes.addFlashAttribute("success","Remove Song successfully");
            return "redirect:/music";
    }
}
