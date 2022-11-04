package com.paloit.booking.controller

import com.paloit.booking.model.Booking
import com.paloit.booking.service.BookingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/bookings")
class BookingController(private  val  service: BookingService) {

    @GetMapping
    fun getBookings(): Collection<Booking> {
        return service.getBookings();
    }

    @GetMapping("/{bookingId}")
    fun getBooking(@PathVariable booking_id:String) : Booking {
        return service.getBooking(booking_id)
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    fun addBooking(@RequestBody booking: Booking) :  Booking {
        service.addBooking(booking)
        return booking
    }
}