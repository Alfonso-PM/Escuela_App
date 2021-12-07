package com.poapm.maestro_app.core.di

import com.poapm.maestro_app.core.plataform.AuthManager
import com.poapm.maestro_app.core.plataform.NetworkHandler
import com.poapm.maestro_app.data.api.ClassApi
import com.poapm.maestro_app.data.api.TeacherApi
import com.poapm.maestro_app.data.source.ClassRepositoryImpl
import com.poapm.maestro_app.data.source.TeacherRepositoryImpl
import com.poapm.maestro_app.domain.repository.ClassRepository
import com.poapm.maestro_app.domain.repository.TeacherRepository
import com.poapm.maestro_app.framework.api.ApiProvider
import com.poapm.maestro_app.framework.db.MaestroDb
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
    fun provideClassRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): ClassRepository =
        ClassRepositoryImpl(apiProvider.getEndpoint(ClassApi::class.java), networkHandler = networkHandler)

    @Provides
    @Singleton
    fun provideTeacherRepository(
        authManager: AuthManager,
        apiProvider: ApiProvider,
        maestroDb: MaestroDb,
        networkHandler: NetworkHandler
    ): TeacherRepository =
        TeacherRepositoryImpl(
            authManager,
            apiProvider.getEndpoint(TeacherApi::class.java),
            maestroDb.teacherDao(),
            networkHandler
        )

}