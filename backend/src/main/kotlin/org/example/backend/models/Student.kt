package org.example.backend.models

import java.time.LocalDate

data class Student(
    val id: Int?,

    val name: String?,
    val lastname: String?,
    val surname: String?,

    val birthday: LocalDate?,
    val group: String?,
)
