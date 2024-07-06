package org.example.backend.requests

class StudentRequests {

    companion object {
        const val GET_STUDENT = "SELECT * FROM students WHERE id = ?"
        const val GET_STUDENTS = "SELECT * FROM students"

        const val INSERT_STUDENT =
            "INSERT INTO students (name, lastname, surname, birthday, group_name) VALUES (?,?,?,?,?)"

        const val DELETE_STUDENT = "DELETE FROM students WHERE id = ?"
    }
}
