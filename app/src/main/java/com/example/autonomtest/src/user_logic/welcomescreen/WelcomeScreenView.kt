package com.example.autonomtest.src.user_logic.welcomescreen

import android.view.View
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.WelcomeScreenModel
import javax.inject.Inject

class WelcomeScreenView @Inject constructor(

): ViewBinding<WelcomeScreenModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): WelcomeScreenModel {
        return WelcomeScreenModel(

        )
    }
}