package com.cwproject.departmentservice.controller;

import com.cwproject.departmentservice.entity.Department;
import com.cwproject.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments")
    public List<Department> getAllDepartments()
    {

        return departmentService.getAllDepartments();
    }

//==========----------------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.GET,value = "/departments/{departmentId}")
    public Department getDepartment(@PathVariable Long departmentId , Department department){

        return departmentService.findDepartmentById(departmentId);
    }
//---------------------------------------------------------------------------------------
    @RequestMapping(method = RequestMethod.POST, value="/departments")
    public void addDepartment(@RequestBody Department department)
    {

        departmentService.addDepartment(department);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/departments/{departmentId}")
    public void updateDepartment(@PathVariable Long departmentId, @RequestBody Department department)
    {
        departmentService.updateDepartment(departmentId, department);
    }
    @RequestMapping(method = RequestMethod.DELETE, value="/departments/{departmentId}")
    public void DeleteDepartment(@PathVariable Long departmentId)
    {

        departmentService.deleteDepartment(departmentId);
    }


    //for viewing UI
//    @GetMapping("/departments")
//    public String listDept(Model model){
//        model.addAttribute("departments",departmentService.getAllDepartments());
//        return "departments";
//    }

}
