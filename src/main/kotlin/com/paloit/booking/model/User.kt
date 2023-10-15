package com.paloit.booking.model

import javax.persistence.*

@Entity
data class User(
    val firstName: String?,
    var lastName: String?,
    var password: String?,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
        private set

    @Column(unique = true)
    val email: String = ""
}
