package com.paloit.booking.datasource.mock

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.model.Booking
import org.springframework.stereotype.Repository
import java.util.Date




@Repository
class MockBookingDataSource : BookingDataSource {
    val bookings = listOf(Booking("hello", Date(), Date()))

    override fun retrievedBookings(): Collection<Booking> {
        return bookings
    }

    override fun retrievedBooking(bookingId: String): Booking {
        return  bookings.first { it.title == bookingId}
    }
}