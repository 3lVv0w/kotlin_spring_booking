package com.paloit.booking.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.paloit.booking.model.Booking
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.util.*

@SpringBootTest
@AutoConfigureMockMvc
internal class BookingControllerTest @Autowired constructor(
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper,
) {
    var baseURL: String = "/api/bookings"

    @Nested
    @DisplayName("GET /api/bookings")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class GetBookings {
        @Test
        fun `should return list of all bookings`(){

            mockMvc.get(baseURL)
                .andDo { print() }
                .andExpect {
                    status { isOk() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath( "$[0].title") { value("hello")}
                }

        }

//        @Test
//        fun `should return NOT FOUND if the booking title does not exist`() {
//            // given
//            val bookingTitle = "world"
//
//            // when/then
//            mockMvc.get("$baseURL/$bookingTitle")
//                .andDo { print() }
//                .andExpect { status { isNotFound() } }
//
//        }
    }


    @Nested
    @DisplayName("POST /api/bookings")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    inner class PostNewBooking {
        @Test
        fun `should add new booking`(){

            val newBooking = Booking("test", Date(), Date())

            // when/then
            val performPost = mockMvc.post("$baseURL/new") {
                contentType = MediaType.APPLICATION_JSON
                content = objectMapper.writeValueAsString(newBooking)
            }

            // then
            performPost
                .andDo { print() }
                .andExpect {
                    status { isCreated() }
                    content { contentType(MediaType.APPLICATION_JSON) }
                    jsonPath("$.title") { value("test")}
                }
        }

//        @Test
//        fun `should return NOT FOUND if the booking title does not exist`() {
//            // given
//            val bookingTitle = "world"
//
//            // when/then
//            mockMvc.get("$baseURL/$bookingTitle")
//                .andDo { print() }
//                .andExpect { status { isNotFound() } }
//
//        }
    }

}