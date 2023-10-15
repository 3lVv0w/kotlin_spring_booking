package com.paloit.booking.datasource.network

import com.paloit.booking.datasource.BookingDataSource
import com.paloit.booking.datasource.network.dto.BookingList
import com.paloit.booking.model.Booking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network")
class NetworkDataSource(
    @Autowired private val restTemplate: RestTemplate
) : BookingDataSource {

    override fun retrieveBookings(): Collection<Booking> {
        val response: ResponseEntity<BookingList> =
            restTemplate.getForEntity("http://54.193.31.159/banks")

        return response.body?.results
            ?: throw IOException("Could not fetch banks from the network")
    }

    override fun retrieveBooking(title: String): Booking {
        TODO("Not yet implemented")

    }

    override fun createBooking(booking: Booking): Booking {
        TODO("Not yet implemented")
    }

    override fun updateBooking(booking: Booking): Booking {
        TODO("Not yet implemented")
    }

    override fun deleteBooking(title: String) {
        TODO("Not yet implemented")
    }
}