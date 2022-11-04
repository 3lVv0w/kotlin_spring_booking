package com.paloit.booking.controller

import com.paloit.booking.model.Booking
import com.paloit.booking.service.BookingService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.awt.PageAttributes.MediaType

@RestController
@RequestMapping("/api/bookings")
class BookingController(private  val  service: BookingService) {

    @GetMapping
    fun getBookings(): Collection<Booking> {
        return service.getBookings();
    }

    @GetMapping("/{bookingId}")
    fun getBoooking(@PathVariable booking_id:String) : Booking {
        return service.getBooking(booking_id)
    }

    @PostMapping("/new")
    fun createBooking() : RequestBody {

    }
}