package com.poapm.alumno_app.core.di

import android.content.Context
import androidx.room.Room
import com.poapm.alumno_app.framework.db.AlumnoDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAlumnoDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AlumnoDb::class.java, "alumno").addMigrations().build()
}