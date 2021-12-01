package com.example.autonomtest.core.dm


import com.example.autonomtest.app_modules.storage.SharedPreferencesStorage
import com.example.autonomtest.app_modules.storage.Storage
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class StorageModule {
    @Binds
    @Singleton
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage
}