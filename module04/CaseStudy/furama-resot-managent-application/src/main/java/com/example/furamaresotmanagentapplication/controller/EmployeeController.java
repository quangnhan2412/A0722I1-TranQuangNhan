package com.example.furamaresotmanagentapplication.controller;

import com.example.furamaresotmanagentapplication.entity.employee.Division;
import com.example.furamaresotmanagentapplication.entity.employee.EducationDegree;
import com.example.furamaresotmanagentapplication.entity.employee.Employee;
import com.example.furamaresotmanagentapplication.entity.employee.Position;
import com.example.furamaresotmanagentapplication.entity.facility.Facility;
import com.example.furamaresotmanagentapplication.service.employee.DivisionService;
import com.example.furamaresotmanagentapplication.service.employee.EducationDegreeService;
import com.example.furamaresotmanagentapplication.service.employee.EmployeeService;
import com.example.furamaresotmanagentapplication.service.employee.PositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private EmployeeService employeeService;

    @ModelAttribute
    public List<Division> getDivisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute
    public List<EducationDegree> getEducationDegreesList(){
        return educationDegreeService.findAll();
    }
    @ModelAttribute
    public List<Position> getPositionsList(){
        return positionService.findAll();
    }

    @GetMapping("/list")
    public String showList(Model model  , @RequestParam(value = "page",defaultValue = "0") int page){
        model.addAttribute("divisionList",getDivisionList());
        model.addAttribute("positionList",getPositionsList());
        model.addAttribute("educationDegreesList",getEducationDegreesList());
        model.addAttribute("employeeList",employeeService.findAll(PageRequest.of(page,5)));
        return "/employee/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("division",getDivisionList());
        model.addAttribute("position",getPositionsList());
        model.addAttribute("educationDegrees",getEducationDegreesList());
        return "/employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes, Model model) {
//        validate
        if (bindingResult.hasErrors()) {
            model.addAttribute("division",getDivisionList());
            model.addAttribute("position",getPositionsList());
            model.addAttribute("educationDegrees",getEducationDegreesList());
            if (employee.getEducationDegree() == null && employee.getPosition() == null && employee.getDivision() == null){
                employee.setEducationDegree(new EducationDegree());
                employee.setPosition(new Position());
                employee.setDivision(new Division());
            }
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("success", "Thành công");
            return "redirect:/employee/list";
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Employee employee, Model model) {
        model.addAttribute("employee", employee);
        model.addAttribute("division",getDivisionList());
        model.addAttribute("position",getPositionsList());
        model.addAttribute("educationDegrees",getEducationDegreesList());
        return "/employee/create";
    }

    @GetMapping(value = "/deleteAll")
    public String delete(@RequestParam("delete-idx") Integer[] ids, RedirectAttributes attributes) {
        employeeService.deleteByAllId(ids);
        attributes.addFlashAttribute("success", "Xoá thành công");
        return "redirect:/employee/list";
    }

    @GetMapping(value = "/search")
    public String search(@RequestParam("searchAll") String searchAll,
                         Model model,
                         @RequestParam(value = "page", defaultValue = "0") int page) {
        Page<Employee> employeeList =employeeService.searchAll(searchAll, PageRequest.of(page, 3));
        model.addAttribute("searchAll", searchAll);
        model.addAttribute("employeeList", employeeList);
        return "employee/search";
    }

}
