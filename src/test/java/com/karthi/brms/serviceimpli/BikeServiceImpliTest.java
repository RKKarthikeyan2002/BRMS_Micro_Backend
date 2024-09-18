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

import com.karthi.brms.model.Bike;
import com.karthi.brms.model.Customer;
import com.karthi.brms.repo.BikeRepo;
import com.karthi.brms.repo.CustomerRepo;

class BikeServiceImpliTest {

    @Mock
    private BikeRepo bRepo;

    @Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private BikeServiceImpli bikeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBikeServiceImpli() {
        // The constructor is tested indirectly through other tests
        assertNotNull(bikeService);
    }

    @Test
    void testGetAllBike() {
        List<Bike> bikeList = new ArrayList<>();
        Bike bike = new Bike();
        bikeList.add(bike);

        when(bRepo.findAll()).thenReturn(bikeList);

        List<Bike> result = bikeService.getAllBike();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(bike, result.get(0));
    }

    @Test
    void testGetBikeByCustomer() {
        Long customerId = 1L;
        Customer customer = new Customer();
        Bike bike = new Bike();
        List<Bike> bikeList = new ArrayList<>();
        bikeList.add(bike);

        when(cRepo.findById(customerId)).thenReturn(customer);
        when(bRepo.findBikesByCustomer(customer)).thenReturn(bikeList);

        List<Bike> result = bikeService.getBikeByCustomer(customerId);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(bike, result.get(0));
    }

    @Test
    void testAddBike() {
        Bike bike = new Bike();
        when(bRepo.save(bike)).thenReturn(bike);

        Bike result = bikeService.addBike(bike);
        assertNotNull(result);
        assertEquals(bike, result);
    }

    @Test
    void testEditStatus() {
        long bikeId = 1L;
        String status = "available";
        Bike bike = new Bike();
        bike.setId(bikeId);

        when(bRepo.findById(bikeId)).thenReturn(bike);
        when(bRepo.update(bike)).thenReturn(bike);

        Bike result = bikeService.editStatus(bikeId, status);
        assertNotNull(result);
        assertEquals(status, result.getStatus());
    }

    @Test
    void testGetBikeById() {
        Long bikeId = 1L;
        Bike bike = new Bike();
        when(bRepo.findById(bikeId)).thenReturn(bike);

        Bike result = bikeService.getBikeById(bikeId);
        assertNotNull(result);
        assertEquals(bike, result);
    }

    @Test
    void testUpdateBike() {
        Bike bike = new Bike();
        when(bRepo.update(bike)).thenReturn(bike);

        Bike result = bikeService.updateBike(bike);
        assertNotNull(result);
        assertEquals(bike, result);
    }
}
