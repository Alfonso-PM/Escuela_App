package com.poapm.alumno_app.core.di

import android.content.Context
import com.poapm.alumno_app.core.plataform.AuthenticationM
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object HelperModule {
    @Provides
    @Singleton
    fun provideAuthenticationM(@ApplicationContext context: Context)=AuthenticationM(context)
}