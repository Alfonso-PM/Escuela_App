package com.poapm.maestro_app.core.di

import android.content.Context
import androidx.room.Room
import com.poapm.maestro_app.framework.db.MaestroDb
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
    fun provideTeacherDb(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, MaestroDb::class.java, "teacher").addMigrations().build()
}