package com.paloit.booking.service

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.model.Booking
import org.springframework.stereotype.Service

@Service
class BookingService (private  val dataSource: BookingDataSource) {
    fun getBookings(): Collection<Booking> {
        return dataSource.retrievedBookings()
    }

    fun getBooking(bookingId: String): Booking {
        return dataSource.retrievedBooking(bookingId)
    }

    fun addBooking(booking: Booking) {
        return dataSource.createBooking(booking)
    }
}