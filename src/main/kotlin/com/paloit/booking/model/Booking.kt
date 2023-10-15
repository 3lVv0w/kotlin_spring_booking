package com.paloit.booking.model

import java.util.*
import com.fasterxml.jackson.annotation.JsonProperty

data class Booking (
    @JsonProperty("title")
    var title: String,
    @JsonProperty("start_date_time")
    var startDateTime: Date,
    @JsonProperty("end_date_time")
    var endDateTime: Date,
)
