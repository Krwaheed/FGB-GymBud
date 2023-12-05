package com.csc340.jpacruddemo.Controller;

import com.csc340.jpacruddemo.Entity.Admin;
import com.csc340.jpacruddemo.Repository.AdminRepository;
import com.csc340.jpacruddemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gymAdmin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin createdAdmin = adminService.
                saveAdmin(admin);
        return ResponseEntity.ok(createdAdmin);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) {
        Admin admin = adminService.getAdminById(id);
        return ResponseEntity.ok(admin);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/signOut")
    public String signOut() {
        // Perform any necessary sign-out logic
        return "user/login"; // Redirect to the index page after signing out
    }

    // Additional endpoint methods can be added as required
}