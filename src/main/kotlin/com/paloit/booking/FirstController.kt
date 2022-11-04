package com.paloit.booking

import com.paloit.booking.model.Booking
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
class FirstController {

    @GetMapping("hello")
    fun HelloWorld(): Booking {
        var newBooking = Booking("hello", Date(122,11,20, 0,1, 0), Date(122,11,20, 0,1, 0))
        return  newBooking
    }
}