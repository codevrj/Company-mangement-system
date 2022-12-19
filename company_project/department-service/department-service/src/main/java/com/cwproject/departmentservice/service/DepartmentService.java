package com.cwproject.departmentservice.service;

import com.cwproject.departmentservice.entity.Department;
import com.cwproject.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    //get all
    public List<Department> getAllDepartments()
    {
        List<Department> departments = new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }
//-------------------------------------------------------------------------
    //get by id
    public Department findDepartmentById(Long departmentId) {

        return departmentRepository.findByDepartmentId(departmentId);
    }
//--------------------------------------------------------------------------


    public void addDepartment(Department department) {
        departmentRepository.save(department);

    }

    public void updateDepartment(Long departmentId, Department department) {
        departmentRepository.save(department);

    }

    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);

    }
}