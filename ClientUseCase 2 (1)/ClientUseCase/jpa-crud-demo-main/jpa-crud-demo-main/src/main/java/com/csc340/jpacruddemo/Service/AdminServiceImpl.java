package com.csc340.jpacruddemo.Service;


import com.csc340.jpacruddemo.Entity.Admin;
import com.csc340.jpacruddemo.Repository.AdminRepository;
import com.csc340.jpacruddemo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        // Implement any business logic if needed
        return adminRepository.save(admin);
    }



    @Override
    public Admin getAdminById(Long id) {
        return adminRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Admin not found with id: " + id));
    }

    @Override
    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }

    // Implement additional methods as required
}
