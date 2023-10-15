package com.paloit.booking.datasource

import com.paloit.booking.model.Booking

 interface BookingDataSource {
    fun retrieveBookings() : Collection<Booking>
    fun retrieveBooking(title: String): Booking
    fun createBooking(booking: Booking) : Booking
    fun updateBooking(booking: Booking) : Booking
    fun deleteBooking(title:String)

}