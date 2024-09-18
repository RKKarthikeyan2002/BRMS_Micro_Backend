package com.karthi.brms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Admin;
import com.karthi.brms.repo.AdminRepo;

class AdminServiceImpliTest {

    @Mock
    private AdminRepo adminRepo;

    @InjectMocks
    private AdminServiceImpli adminService;

    private Admin existingAdmin;
    private LoginDto loginDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initialize test data
        existingAdmin = new Admin();
        existingAdmin.setId(1L);
        existingAdmin.setEmail("test@example.com");
        existingAdmin.setPassword("password123");
        existingAdmin.setAge(30);
        existingAdmin.setAddress("123 Test Street");
        existingAdmin.setPhone("1234567890");

        loginDto = new LoginDto();
        loginDto.setEmail("test@example.com");
        loginDto.setPassword("password123");
    }

    @Test
    void testLogin_Success() {
        when(adminRepo.findByEmail(loginDto.getEmail())).thenReturn(existingAdmin);

        Admin result = adminService.login(loginDto);

        assertNotNull(result);
        assertEquals(existingAdmin, result);
    }

    @Test
    void testLogin_Failure() {
        when(adminRepo.findByEmail(loginDto.getEmail())).thenReturn(null);

        Admin result = adminService.login(loginDto);

        assertNull(result);
    }

    @Test
    void testEditAdmin() {
        Admin updatedAdmin = new Admin();
        updatedAdmin.setId(1L);
        updatedAdmin.setAge(35);
        updatedAdmin.setAddress("456 New Street");
        updatedAdmin.setPhone("0987654321");

        when(adminRepo.findById(existingAdmin.getId())).thenReturn(existingAdmin);
        when(adminRepo.update(existingAdmin)).thenReturn(existingAdmin);

        Admin result = adminService.editAdmin(updatedAdmin);

        assertNotNull(result);
        assertEquals(35, result.getAge());
        assertEquals("456 New Street", result.getAddress());
        assertEquals("0987654321", result.getPhone());
    }

    @Test
    void testEditPassword_Failure() {
        when(adminRepo.findById(existingAdmin.getId())).thenReturn(existingAdmin);

        Admin result = adminService.editPassword(existingAdmin.getId(), "newpassword", "wrongpassword");

        assertNull(result);
    }

    @Test
    void testGetAdminById() {
        when(adminRepo.findById(existingAdmin.getId())).thenReturn(existingAdmin);

        Admin result = adminService.getAdminById(existingAdmin.getId());

        assertNotNull(result);
        assertEquals(existingAdmin, result);
    }
}
