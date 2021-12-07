package com.poapm.maestro_app.framework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poapm.maestro_app.data.dao.TeacherDao
import com.poapm.maestro_app.domain.model.Teacher


@Database(entities = [Teacher::class], version = 1)
 abstract class MaestroDb: RoomDatabase() {

    abstract fun teacherDao(): TeacherDao

}