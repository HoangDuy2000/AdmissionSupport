/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vhd.repository;

import com.vhd.pojo.Facultys;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public interface FacultyRepository {
    List<Facultys> getFacultys();
    boolean addOrUpdateFaculty(Facultys f);
    Facultys getFacultyById(int id);
    boolean deleteFaculty(int id);
}
