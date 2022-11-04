package com.paloit.booking.datasource

import com.paloit.booking.model.Booking
import java.util.*

interface BookingDataSource {

    fun retrievedBookings() : Collection<Booking>
    fun retrievedBooking(bookingId: String): Booking
    fun createBooking(booking: Booking) : Booking

}