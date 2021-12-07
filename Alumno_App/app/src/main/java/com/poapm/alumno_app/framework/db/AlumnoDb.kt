package com.poapm.alumno_app.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poapm.alumno_app.data.dao.AlumnoDao
import com.poapm.alumno_app.domain.model.Alumno

@Database(entities = [Alumno::class], version = 1)
abstract class AlumnoDb : RoomDatabase() {

        abstract fun alumnoDao(): AlumnoDao
}