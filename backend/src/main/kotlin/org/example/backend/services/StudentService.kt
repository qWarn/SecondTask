package org.example.backend.services

import org.example.backend.dtos.StudentDto
import org.example.backend.exceptions.UserNotFoundException
import org.example.backend.mappers.StudentRowMapper
import org.example.backend.models.Student
import org.example.backend.requests.StudentRequests.Companion.DELETE_STUDENT
import org.example.backend.requests.StudentRequests.Companion.GET_STUDENT
import org.example.backend.requests.StudentRequests.Companion.GET_STUDENTS
import org.example.backend.requests.StudentRequests.Companion.INSERT_STUDENT
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

@Service
class StudentService(
    private val jdbcTemplate: JdbcTemplate,
    private val rowMapper: StudentRowMapper
) {

    fun getStudent(id: Int): Student? =
        try {
            jdbcTemplate.queryForObject(GET_STUDENT, rowMapper, id)
        } catch (ex: EmptyResultDataAccessException) {
            throw UserNotFoundException("User not found by id: '$id'")
        }

    fun getAllStudents(): List<Student> =
        jdbcTemplate.query(GET_STUDENTS, rowMapper)

    fun addStudent(studentDto: StudentDto) {
        jdbcTemplate.update(
            INSERT_STUDENT,
            studentDto.name,
            studentDto.lastname,
            studentDto.surname,
            studentDto.birthday,
            studentDto.group
        )
    }

    fun deleteStudent(id: Int) {
        getStudent(id)
        jdbcTemplate.update(DELETE_STUDENT, id)
    }
}
