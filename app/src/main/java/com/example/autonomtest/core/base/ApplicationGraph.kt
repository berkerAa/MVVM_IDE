package com.example.autonomtest.core.base

import android.app.Application
import com.example.autonomtest.core.di.ApplicationGraphComponent
import com.example.autonomtest.core.di.DaggerApplicationGraphComponent

open class ApplicationGraph: Application() {
    val applicationGraphComponent: ApplicationGraphComponent by lazy {
        DaggerApplicationGraphComponent.factory().create(applicationContext)
    }
}