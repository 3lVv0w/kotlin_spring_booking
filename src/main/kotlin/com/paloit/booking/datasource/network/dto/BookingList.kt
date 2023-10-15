package com.paloit.booking.datasource.network.dto

import com.paloit.booking.model.Booking

data class BookingList(
    val results: Collection<Booking>
)
