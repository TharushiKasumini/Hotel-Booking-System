package com.hotel.BookingManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.BookingManagement.dto.Response;
import com.hotel.BookingManagement.entity.Booking;
import com.hotel.BookingManagement.service.interfac.BookingServiceInterface;

@RestController
@RequestMapping("/bookings")

public class BookingController {

    @Autowired
    private BookingServiceInterface bookingService;

    @PostMapping("/book-room/{roomId}/{userId}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Response> saveBookings(@PathVariable Long roomId,
            @PathVariable Long userId,
            @RequestBody Booking bookingRequest) {

        Response response = bookingService.saveBooking(roomId, userId, bookingRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);

    }
    @DeleteMapping("/bookings/{id}")
     @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Void> deleteBooking(@PathVariable Long roomId) {
        Response response=bookingService.deleteBooking(roomId);
        return  ResponseEntity.status(response.getStatusCode()).body(response);
    }

}
