package com.paloit.booking.controller

import com.paloit.booking.model.Booking
import com.paloit.booking.service.BookingService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bookings")
class BookingController(private  val  service: BookingService) {

    @GetMapping
    fun getBookings(): Collection<Booking> = service.getBookings()

    @GetMapping("/{bookingId}")
    fun getBooking(@PathVariable booking_id:String) : Booking = service.getBooking(booking_id)

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    fun addBooking(@RequestBody booking: Booking) :  Booking {
        service.addBooking(booking)
        return booking
    }

    @PatchMapping
    fun updateBooking(@RequestBody booking: Booking): Booking = service.updateBooking(booking)

    @DeleteMapping("/{title}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBooking(@PathVariable title: String): Unit = service.deleteBooking(title)
}