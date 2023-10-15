package com.paloit.booking.datasource.mock

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.model.Booking
import org.springframework.stereotype.Repository
import java.util.Date

@Repository("mock")
class MockBookingDataSource : BookingDataSource {

    val bookings = mutableListOf(Booking("hello", Date(), Date()))

    override fun retrieveBookings(): Collection<Booking> {
        return bookings
    }

    override fun retrieveBooking(bookingId: String): Booking {
        return  bookings.firstOrNull { it.title == bookingId}
            ?: throw NoSuchElementException("Could not find booking with title $bookingId")
    }

    override  fun  createBooking(booking: Booking) : Booking {
        bookings.add(booking)
        return  booking;
    }

    override fun updateBooking(booking: Booking): Booking {
        val currentBooking = bookings.firstOrNull { it.title == booking.title }
            ?: throw NoSuchElementException("Could not find a booking with account number ${booking.title}")

        bookings.remove(currentBooking)
        bookings.add(booking)

        return booking
    }

    override fun deleteBooking(accountNumber: String) {
        val currentBank = bookings.firstOrNull { it.title == accountNumber }
            ?: throw NoSuchElementException("Could not find a booking with account number $accountNumber")

        bookings.remove(currentBank)
    }

}