package com.csc340.jpacruddemo.Service;

import com.csc340.jpacruddemo.Entity.Admin;
public interface AdminService {
    Admin
    saveAdmin(Admin admin);
    Admin getAdminById(Long id);
    void deleteAdmin(Long id);
    // You can add more methods as per your requirements
}
