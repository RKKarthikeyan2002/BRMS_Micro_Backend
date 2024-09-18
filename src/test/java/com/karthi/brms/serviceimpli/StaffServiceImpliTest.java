package com.karthi.brms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Staff;
import com.karthi.brms.repo.StaffRepo;

class StaffServiceImpliTest {

    @Mock
    private StaffRepo sRepo;

    @InjectMocks
    private StaffServiceImpli staffService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testStaffServiceImpli() {
        assertNotNull(staffService);
    }

    @Test
    void testLogin() {
        String email = "staff@example.com";
        String password = "password123";
        Staff staff = new Staff();
        staff.setEmail(email);
        staff.setPassword(password);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(email);
        loginDto.setPassword(password);

        when(sRepo.findByEmail(email)).thenReturn(staff);

        Staff result = staffService.login(loginDto);
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
    }

    @Test
    void testLoginWithIncorrectPassword() {
        String email = "staff@example.com";
        String password = "password123";
        Staff staff = new Staff();
        staff.setEmail(email);
        staff.setPassword("wrongpassword");

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(email);
        loginDto.setPassword(password);

        when(sRepo.findByEmail(email)).thenReturn(staff);

        Staff result = staffService.login(loginDto);
        assertNull(result);
    }

    @Test
    void testAddStaff() {
        Staff staff = new Staff();
        staff.setRole("Staff");

        when(sRepo.save(staff)).thenReturn(staff);

        Staff result = staffService.addStaff(staff);
        assertNotNull(result);
        assertEquals("Staff", result.getRole());
    }

    @Test
    void testGetAllStaff() {
        List<Staff> staffList = new ArrayList<>();
        Staff staff = new Staff();
        staffList.add(staff);

        when(sRepo.findAll()).thenReturn(staffList);

        List<Staff> result = staffService.getAllStaff();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(staff, result.get(0));
    }

    @Test
    void testEditPasswordWithIncorrectOldPassword() {
        Long staffId = 1L;
        String oldPassword = "oldpassword";
        String newPassword = "newpassword";
        Staff staff = new Staff();
        staff.setId(staffId);
        staff.setPassword("differentpassword");

        when(sRepo.findById(staffId)).thenReturn(staff);

        Staff result = staffService.editPassword(staffId, newPassword, oldPassword);
        assertNull(result);
    }

    @Test
    void testGetStaffById() {
        Long staffId = 1L;
        Staff staff = new Staff();
        when(sRepo.findById(staffId)).thenReturn(staff);

        Staff result = staffService.getStaffById(staffId);
        assertNotNull(result);
        assertEquals(staff, result);
    }
}
