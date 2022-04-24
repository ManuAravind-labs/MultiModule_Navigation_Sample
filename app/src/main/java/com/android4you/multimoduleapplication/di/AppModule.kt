package com.android4you.multimoduleapplication.di

import com.android4you.multimoduleapplication.navContracts.AppContracts
import com.android4you.navigation.Contracts
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideContracts(): Contracts {
        return AppContracts()
    }
}
