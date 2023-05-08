package com.example.furamaresotmanagentapplication.controller;

import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import com.example.furamaresotmanagentapplication.entity.facility.FacilityType;
import com.example.furamaresotmanagentapplication.entity.facility.RentType;
import com.example.furamaresotmanagentapplication.service.facility.FacilityRentTypeService;
import com.example.furamaresotmanagentapplication.service.facility.FacilityService;
import com.example.furamaresotmanagentapplication.service.facility.FacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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
    public String showList(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        //sort
        Sort sort = Sort.by("name").ascending();
        model.addAttribute("facilityList", facilityService.findAll(PageRequest.of(page , 4, sort)));
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
    public String save(@Valid @ModelAttribute("facility") Facility facility, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
//        validate
        if (bindingResult.hasErrors()) {
            model.addAttribute("facilityType", getFacilityTypeList());
            model.addAttribute("rentType", getRentTypeList());
            if (facility.getFacilityTypes() == null && facility.getRentTypes() == null){
                    facility.setFacilityTypes(new FacilityType());
                    facility.setRentTypes(new RentType());
            }
            return "/facility/create";
        }
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
    public String delete(@RequestParam("delete-idx") Integer[] ids, RedirectAttributes attributes) {
        facilityService.deleteAllByIdIn(ids);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/facility/list";
    }
    @GetMapping(value = "/search")
    public String search(@RequestParam("searchAll") String searchAll,
                         Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Facility> facilityList =facilityService.searchAllInt(searchAll, PageRequest.of(page, 2));
        model.addAttribute("searchAll", searchAll);
        model.addAttribute("facilityList", facilityList);
        return "facility/search";
    }


}
