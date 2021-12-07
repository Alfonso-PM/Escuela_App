package com.poapm.alumno_app.core.di

import com.poapm.alumno_app.core.plataform.AuthenticationM
import com.poapm.alumno_app.core.plataform.NetworkHandler
import com.poapm.alumno_app.data.api.AlumnoApi
import com.poapm.alumno_app.data.source.AlumnoRepositoryImpl
import com.poapm.alumno_app.domain.repository.AlumnoRepository
import com.poapm.alumno_app.framework.api.ApiProvider
import com.poapm.alumno_app.framework.db.AlumnoDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAlumnoRepository(
        authenticationM: AuthenticationM,
        apiProvider: ApiProvider,
        alumnoDb: AlumnoDb,
        networkHandler: NetworkHandler
    ): AlumnoRepository = AlumnoRepositoryImpl(
        authenticationM,
        apiProvider.getEndpoint(AlumnoApi::class.java),
        alumnoDb.alumnoDao(),
        networkHandler
    )
}