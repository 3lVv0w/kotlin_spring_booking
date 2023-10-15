package com.paloit.booking.service


import com.paloit.booking.datasource.BookingDataSource
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BookingServiceTest {
    private val bookingDataSource: BookingDataSource = mockk(relaxed = true)
    private val bookingService = BookingService(bookingDataSource)

    @Test
    fun `should do something here` () {
        // given
//        every { bookingDataSource.retrievedBookings() } returns emptyList()

        // when
        bookingService.getBookings()

        // then
        verify (exactly = 1) { bookingDataSource.retrieveBookings() }
    }
}