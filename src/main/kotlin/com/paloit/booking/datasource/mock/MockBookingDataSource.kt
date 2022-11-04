package com.paloit.booking.datasource.mock

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.model.Booking
import org.springframework.stereotype.Repository
import java.util.Date




@Repository
class MockBookingDataSource : BookingDataSource {

    val bookings = mutableListOf(Booking("hello", Date(), Date()))

    override fun retrievedBookings(): Collection<Booking> {
        return bookings
    }

    override fun retrievedBooking(bookingId: String): Booking {
        return  bookings.firstOrNull { it.title == bookingId}
            ?: throw NoSuchElementException("Could not find booking with title $bookingId")
    }

    override  fun  createBooking(booking: Booking) : Booking {
        bookings.add(booking)
        return  booking;
    }

}