package com.poapm.maestro_app.core.di

import com.poapm.maestro_app.core.plataform.NetworkHandler
import com.poapm.maestro_app.data.api.ClassApi
import com.poapm.maestro_app.data.source.ClassRepositoryImpl
import com.poapm.maestro_app.domain.repository.ClassRepository
import com.poapm.maestro_app.framework.api.ApiProvider
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

}