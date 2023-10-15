package com.paloit.booking.datasource.mock

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MockBookingDataSourceTest {

    private  val mockBookingDataSource = MockBookingDataSource()

    @Test
    fun `should provide collection of bookings`() {
        // given
        
        // when
        val bookings = mockBookingDataSource.retrieveBookings()
        // then
        assertThat(bookings).isNotEmpty
    }

    @Test
    fun `should provide each booking title not null`() {
        // given

        // when
        val bookings = mockBookingDataSource.retrieveBookings()
        // then
        assertThat(bookings).allMatch { booking -> booking.title.isNotBlank()}
        // or
        // assertThat(bookings).allMatch { it.title.isNotBlank()}
    }
}