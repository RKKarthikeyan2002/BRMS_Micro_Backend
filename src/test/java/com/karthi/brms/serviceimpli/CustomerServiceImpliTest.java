package com.karthi.brms.serviceimpli;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.karthi.brms.dto.LoginDto;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.CustomerRepo;

class CustomerServiceImpliTest {

    @Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private CustomerServiceImpli customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCustomerServiceImpli() {
        assertNotNull(customerService);
    }

    @Test
    void testAddCustomer() {
        Customer customer = new Customer();
        customer.setRole("customer");

        when(cRepo.save(customer)).thenReturn(customer);

        Customer result = customerService.addCustomer(customer);
        assertNotNull(result);
        assertEquals("customer", result.getRole());
    }

    @Test
    void testLogin() {
        String email = "test@example.com";
        String password = "password123";
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(email);
        loginDto.setPassword(password);

        when(cRepo.findByEmail(email)).thenReturn(customer);

        Customer result = customerService.login(loginDto);
        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
    }

    @Test
    void testLoginWithIncorrectPassword() {
        String email = "test@example.com";
        String password = "password123";
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword("wrongpassword");

        LoginDto loginDto = new LoginDto();
        loginDto.setEmail(email);
        loginDto.setPassword(password);

        when(cRepo.findByEmail(email)).thenReturn(customer);

        Customer result = customerService.login(loginDto);
        assertNull(result);
    }

    @Test
    void testGetCustomerById() {
        Long customerId = 1L;
        Customer customer = new Customer();
        when(cRepo.findById(customerId)).thenReturn(customer);

        Customer result = customerService.getCustomerById(customerId);
        assertNotNull(result);
        assertEquals(customer, result);
    }

    @Test
    void testUpdateStatus() {
        Long customerId = 1L;
        String status = "active";
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setStatus("inactive");

        when(cRepo.findById(customerId)).thenReturn(customer);
        doNothing().when(cRepo).updateStatus(customer);

        customerService.updateStatus(customerId, status);

        verify(cRepo).updateStatus(customer);
        assertEquals(status, customer.getStatus());
    }

    @Test
    void testEditPasswordWithIncorrectOldPassword() {
        Long customerId = 1L;
        String oldPassword = "oldpassword";
        String newPassword = "newpassword";
        Customer customer = new Customer();
        customer.setId(customerId);
        customer.setPassword("differentpassword");

        when(cRepo.findById(customerId)).thenReturn(customer);

        Customer result = customerService.editPassword(customerId, newPassword, oldPassword);
        assertNull(result);
    }
}
