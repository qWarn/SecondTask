package org.example.backend.controllers

import org.example.backend.dtos.StudentDto
import org.example.backend.models.Student
import org.example.backend.services.StudentService
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = ["*"])
class StudentController(
    private val studentService: StudentService
) {

    @GetMapping
    fun getStudents(): List<Student> =
        studentService.getAllStudents()

    @PostMapping
    fun addStudent(@Validated @RequestBody studentDto: StudentDto) =
        studentService.addStudent(studentDto)

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Int) =
        studentService.deleteStudent(id)
}
