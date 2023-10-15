package com.paloit.booking.service

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.model.Booking
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class BookingService (@Qualifier("mock") private  val dataSource: BookingDataSource) {
    fun getBookings(): Collection<Booking> = dataSource.retrieveBookings()

    fun getBooking(bookingId: String): Booking = dataSource.retrieveBooking(bookingId)

    fun addBooking(booking: Booking): Booking = dataSource.createBooking(booking)

    fun updateBooking(booking: Booking): Booking = dataSource.updateBooking(booking)

    fun deleteBooking(title: String): Unit = dataSource.deleteBooking(title)
}