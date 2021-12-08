package com.poapm.maestro_app.data.dao

import androidx.room.*
import com.poapm.maestro_app.domain.model.Teacher


@Dao
interface TeacherDao {

    @Transaction
    @Query("SELECT * FROM Teacher WHERE Teacher.idTeacher = :id AND Teacher.password = :password")
    fun findTeacher(id: Int, password: String): Teacher?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveTeacher(teacher: List<Teacher>): List<Long>

    @Update
    fun updateTeacher(teacher: Teacher): Int
}