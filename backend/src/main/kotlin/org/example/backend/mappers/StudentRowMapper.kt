package org.example.backend.mappers

import java.sql.ResultSet
import org.example.backend.models.Student
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Component

@Component
class StudentRowMapper : RowMapper<Student> {

    companion object {
        private const val FIELD_ID = "id"
        private const val FIELD_NAME = "name"
        private const val FIELD_LASTNAME = "lastname"
        private const val FIELD_SURNAME = "surname"
        private const val FIELD_BIRTHDAY = "birthday"
        private const val FIELD_GROUP = "group_name"
    }

    override fun mapRow(rs: ResultSet, rowNum: Int): Student =
        Student(
            id = rs.getInt(FIELD_ID),

            name = rs.getString(FIELD_NAME),
            lastname = rs.getString(FIELD_LASTNAME),
            surname = rs.getString(FIELD_SURNAME),

            birthday = rs.getDate(FIELD_BIRTHDAY).toLocalDate(),

            group = rs.getString(FIELD_GROUP),
        )
}
