package com.example.autonomtest.core.di

import android.content.Context
import com.example.autonomtest.core.dm.NetworkModule
import com.example.autonomtest.core.dm.StorageModule
import com.example.autonomtest.src.user_logic.di.UserComponent
import com.example.autonomtest.src.user_logic.di.UserProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetworkModule::class, StorageModule::class, UserProvider::class])
interface ApplicationGraphComponent {
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): ApplicationGraphComponent
    }

    fun userComponent(): UserComponent.Factory
//@LogicFactoryProvider
}

