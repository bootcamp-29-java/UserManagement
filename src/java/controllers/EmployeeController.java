/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.EmployeeDAO;
import daos.GeneralDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import idaos.IGeneralDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import models.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author asus
 */
public class EmployeeController implements IEmployeeController {
    
    private IGeneralDAO<Employee> igdao;
    private IEmployeeDAO empdao;

    SessionFactory factory;
    Session session;
    
    public EmployeeController(SessionFactory factory) {
        igdao = new GeneralDAO<>(factory, Employee.class);
        empdao = new EmployeeDAO(factory);
    }

    @Override
    public List<Employee> getAll() {
        return igdao.getAll();
    }

    @Override
    public Employee getById(String id) {
        return igdao.getById(id);
    }

    @Override
    public String save(String id, String first_name, String last_name, String email, String birth_place, String birth_date, String gender, String nationality, String photo, boolean is_delete) {
        String result = "";
        try {
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(birth_date);
            Employee employee = new Employee(id, first_name, last_name, email, birth_place, date1, gender, nationality, photo, is_delete);
//            Employee employee = new Employee(id, first_name, last_name, email, birth_place, birth_date, gender, nationality, is_delete);
            if (igdao.saveOrDelete(employee, true)) {
                result = "Save data berhasil";
            } else {
                result = "Save data gagal";
            }
        } catch (Exception e) {
            result = "Save data error";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        try {
            Employee employee = igdao.getById(id);
            if (igdao.saveOrDelete(employee, false)) {
                result = "Delete data berhasil";
            } else {
                result = "Delete data gagal";
            }
        } catch (Exception e) {
            result = "Delete data error";
        }
        return result;
    }

    @Override
    public int genId() {
        int result = Integer.parseInt(empdao.genId()) ;
        
        return result;
    }

}
