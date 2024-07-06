package org.example.backend.dtos

import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import java.time.LocalDate

data class StudentDto(
    @field:NotBlank(message = "Name is required.")
    @field:Pattern(regexp = "(^[A-Za-z]+\$)|(^[А-Яа-я]+\$)", message = "Must contain only english/russian letters.")
    val name: String?,

    @field:Pattern(regexp = "(^[A-Za-z]+\$)|(^[А-Яа-я]+\$)", message = "Must contain only english/russian letters.")
    @field:NotBlank(message = "Lastname is required.")
    val lastname: String?,

    @field:Pattern(regexp = "(^[A-Za-z]+\$)|(^[А-Яа-я]+\$)", message = "Must contain only english/russian letters.")
    @field:NotBlank(message = "Surname is required.")
    val surname: String?,

    @field:NotNull(message = "Date is required.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    val birthday: LocalDate?,

    @field:NotBlank(message = "Group is required.")
    val group: String?,
)

