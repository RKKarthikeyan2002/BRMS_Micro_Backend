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

import com.karthi.brms.model.Booking;
import com.karthi.brms.repo.BookingRepo;
import com.karthi.brms.repo.CustomerRepo;

class BookingServiceImpliTest {

    @Mock
    private BookingRepo bRepo;

    @Mock
    private CustomerRepo cRepo;

    @InjectMocks
    private BookingServiceImpli bookingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBookingServiceImpli() {
        assertNotNull(bookingService);
    }

    @Test
    void testCreateBooking() {
        Booking booking = new Booking();
        when(bRepo.save(booking)).thenReturn(booking);

        Booking result = bookingService.createBooking(booking);
        assertNotNull(result);
        assertEquals(booking, result);
    }

    @Test
    void testGetAllBooking() {
        List<Booking> bookings = new ArrayList<>();
        Booking booking = new Booking();
        bookings.add(booking);

        when(bRepo.findAll()).thenReturn(bookings);

        List<Booking> result = bookingService.getAllBooking();
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(booking, result.get(0));
    }

    @Test
    void testEditAdvanceStatus() {
        Long bookingId = 1L;
        String advanceStatus = "Paid";
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bRepo.findById(bookingId)).thenReturn(booking);
        when(bRepo.update(booking)).thenReturn(booking);

        Booking result = bookingService.editAdvanceStatus(bookingId, advanceStatus);
        assertNotNull(result);
        assertEquals(advanceStatus, result.getAdvanceStatus());
    }

    @Test
    void testEditTotalStatus() {
        Long bookingId = 1L;
        String totalStatus = "Settled";
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bRepo.findById(bookingId)).thenReturn(booking);
        when(bRepo.update(booking)).thenReturn(booking);

        Booking result = bookingService.editTotalStatus(bookingId, totalStatus);
        assertNotNull(result);
        assertEquals(totalStatus, result.getAmountStatus());
    }

    @Test
    void testGetBookingById() {
        Long bookingId = 1L;
        Booking booking = new Booking();
        when(bRepo.findById(bookingId)).thenReturn(booking);

        Booking result = bookingService.getBookingById(bookingId);
        assertNotNull(result);
        assertEquals(booking, result);
    }

    @Test
    void testGetAvailableBookings() {
        Long bikeId = 1L;
        String status = "Booked";
        List<Booking> bookings = new ArrayList<>();
        Booking booking = new Booking();
        bookings.add(booking);

        when(bRepo.findByBikeIdAndStatusNot(bikeId, status)).thenReturn(bookings);

        List<Booking> result = bookingService.getAvailableBookings(bikeId, status);
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(booking, result.get(0));
    }

    @Test
    void testEditTotalAmount() {
        Long bookingId = 1L;
        double totalAmount = 500.00;
        Booking booking = new Booking();
        booking.setId(bookingId);

        when(bRepo.findById(bookingId)).thenReturn(booking);
        when(bRepo.update(booking)).thenReturn(booking);

        Booking result = bookingService.editTotalAmount(bookingId, totalAmount);
        assertNotNull(result);
        assertEquals(totalAmount, result.getTotalAmount());
    }
}
