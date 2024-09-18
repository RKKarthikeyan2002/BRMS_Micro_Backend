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

import com.karthi.brms.model.BikeType;
import com.karthi.brms.repo.BikeTypeRepo;

class BikeTypeServiceImpliTest {

    @Mock
    private BikeTypeRepo bRepo;

    @InjectMocks
    private BikeTypeServiceImpli bikeTypeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBikeTypeServiceImpli() {
        assertNotNull(bikeTypeService);
    }

    @Test
    void testGetAllBikeTypes() {
        List<String> bikeTypeNames = new ArrayList<>();
        bikeTypeNames.add("Mountain");
        bikeTypeNames.add("Road");

        when(bRepo.findAllName()).thenReturn(bikeTypeNames);

        List<String> result = bikeTypeService.getAllBikeTypes();
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Mountain"));
        assertTrue(result.contains("Road"));
    }

    @Test
    void testGetBikeTypeByName() {
        String bikeTypeName = "Mountain";
        BikeType bikeType = new BikeType();
        bikeType.setName(bikeTypeName);

        when(bRepo.findByName(bikeTypeName)).thenReturn(bikeType);

        BikeType result = bikeTypeService.getBikeTypeByName(bikeTypeName);
        assertNotNull(result);
        assertEquals(bikeTypeName, result.getName());
    }

    @Test
    void testAddBikeType() {
        BikeType bikeType = new BikeType();
        bikeType.setName("Electric");

        when(bRepo.save(bikeType)).thenReturn(bikeType);

        BikeType result = bikeTypeService.addBikeType(bikeType);
        assertNotNull(result);
        assertEquals("Electric", result.getName());
    }

    @Test
    void testDeleteBikeType() {
        Long bikeTypeId = 1L;

        // No need to return anything for delete operation
        doNothing().when(bRepo).deleteById(bikeTypeId);

        // We can check if deleteById method is called
        bikeTypeService.deleteBikeType(bikeTypeId);
        verify(bRepo, times(1)).deleteById(bikeTypeId);
    }
}
