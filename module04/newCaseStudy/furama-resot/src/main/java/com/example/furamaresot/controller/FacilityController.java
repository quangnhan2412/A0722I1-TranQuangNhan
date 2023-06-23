package com.example.furamaresot.controller;

import com.example.furamaresot.entity.facility.Facility;
import com.example.furamaresot.entity.facility.FacilityType;
import com.example.furamaresot.entity.facility.RentType;
import com.example.furamaresot.service.facility.FacilityRentTypeService;
import com.example.furamaresot.service.facility.FacilityService;
import com.example.furamaresot.service.facility.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/facility")
public class FacilityController {
    @Autowired
    private FacilityTypeService facilityTypeService;
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private FacilityRentTypeService facilityRentTypeService;

    @ModelAttribute
    public List<FacilityType> getFacilityTypeList() {
        return facilityTypeService.findAll();
    }

    @ModelAttribute
    public List<RentType> getRentTypeList() {
        return facilityRentTypeService.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model,
                           @RequestParam(value = "page", defaultValue = "0") int page) {
        //sort
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("facilityList", facilityService.findAll(PageRequest.of(page, 6, sort)));
        model.addAttribute("rentType", getRentTypeList());
        model.addAttribute("facilityType", getFacilityTypeList());
        return "/facility/list";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("rentType", getRentTypeList());
        model.addAttribute("facilityType", getFacilityTypeList());
        return "/facility/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("facility") Facility facility, RedirectAttributes redirectAttributes) {
        facilityService.save(facility);
        redirectAttributes.addFlashAttribute("success", "Thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Facility facility, Model model) {
        model.addAttribute("facility", facility);
        model.addAttribute("rentType", getRentTypeList());
        model.addAttribute("facilityType", getFacilityTypeList());
        return "/facility/create";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("ids") Integer id, RedirectAttributes attributes) {
        facilityService.remove(id);
        attributes.addFlashAttribute("success", "Xóa thành công");
        return "redirect:/facility/list";
    }

    @GetMapping("/view/{id}")
    public String viewFacility(@PathVariable("id") Integer id, Model model) {
        Facility facility = facilityService.findById(id).get();
        model.addAttribute("facility", facility);
        return "/facility/view";
    }

    @GetMapping(value = "/deleteAll")
    public String delete(@RequestParam("idx") Integer[] ids, RedirectAttributes attributes) {
        facilityService.deleteAllByIdIn(ids);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/facility/list";
    }

}
