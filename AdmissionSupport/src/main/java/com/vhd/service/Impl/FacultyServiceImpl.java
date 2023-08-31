/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.service.Impl;

import com.vhd.pojo.Facultys;
import com.vhd.repository.FacultyRepository;
import com.vhd.service.FacultyService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author PC
 */
@Service
public class FacultyServiceImpl implements FacultyService{
    @Autowired
    private FacultyRepository facultyRepo;

    @Override
    public List<Facultys> getFacultys() {
        return this.facultyRepo.getFacultys();
    }

    @Override
    public boolean addOrUpdateFaculty(Facultys f) {
        return this.facultyRepo.addOrUpdateFaculty(f);
    }

    @Override
    public Facultys getFacultyById(int id) {
        return this.facultyRepo.getFacultyById(id);
    }

    @Override
    public boolean deleteFaculty(int id) {
        return this.facultyRepo.deleteFaculty(id);
    }
}
