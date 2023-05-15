package com.example.tryhardmd4.controller;

import com.example.tryhardmd4.entity.DanhMuc;
import com.example.tryhardmd4.entity.TinTuc;
import com.example.tryhardmd4.service.TinTucService;
import com.example.tryhardmd4.service.DanhMucService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/danhmuc")
public class TinTucController {
    @Autowired
    private DanhMucService danhMucService;
    @Autowired
    private TinTucService tinTucService;

    @ModelAttribute
    public List<DanhMuc> getDanhMucList() {
        return danhMucService.findAll();
    }


    @GetMapping("/list")
    public String showList(Model model  , @RequestParam(value = "page",defaultValue = "0") int page){
        model.addAttribute("danhMucList",getDanhMucList());
        model.addAttribute("tinTucList",tinTucService.findAll(PageRequest.of(page,5)));
        return "/danhmuc/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("tinTuc",new TinTuc());
        model.addAttribute("danhMuc",getDanhMucList());
        return "/danhmuc/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("tinTuc") TinTuc tinTuc, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
//        validate
        if (bindingResult.hasErrors()) {
            model.addAttribute("danhMuc",getDanhMucList());
            if (tinTuc.getDanhMuc() == null){
              tinTuc.setDanhMuc(new DanhMuc());
            }
            return "/danhmuc/create";
        }
        tinTuc.setNgayDangTin();
        tinTucService.save(tinTuc);
        redirectAttributes.addFlashAttribute("success", "Thành công");
        return "redirect:/danhmuc/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("ids") Integer id, RedirectAttributes attributes) {
        tinTucService.remove(id);
        attributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/danhmuc/list";
    }
    @GetMapping("/view/{id}")
    public String viewFacility(@PathVariable("id") Integer id, Model model) {
        TinTuc tinTuc = tinTucService.findById(id).get();
        model.addAttribute("tinTuc", tinTuc);
        return "/danhmuc/view";
    }
//
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable("id") TinTuc employee, Model model) {
//        model.addAttribute("employee", employee);
//        model.addAttribute("division",getDivisionList());
//        model.addAttribute("position",getPositionsList());
//        model.addAttribute("educationDegrees",getEducationDegreesList());
//        return "/employee/create";
//    }
//
//
    @GetMapping(value = "/search")
    public String search(@RequestParam("searchAll") String searchAll,
                         Model model) {
        List<TinTuc> tinTucs =tinTucService.searchAll(searchAll);
        model.addAttribute("searchAll", searchAll);
        model.addAttribute("tinTucList", tinTucs);
        return "danhmuc/search";
    }
//    public String search(@RequestParam("tieuDe") String tieuDe, @RequestParam("danhMuc") String danhMuc,
//                         Model model) {
//        List<TinTuc> tinTucs = tinTucService.searchKet(tieuDe, danhMuc);
//        model.addAttribute("tieuDe", tieuDe);
//        model.addAttribute("danhMuc", danhMuc);
//
//        return "danhmuc/se";
//    }

}
