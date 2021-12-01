package com.example.autonomtest.src.user_logic.register

import android.view.View
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.RegisterModel
import javax.inject.Inject

//@EndImportLibraries
class RegisterView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<RegisterModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): RegisterModel {
        return RegisterModel() //fill with Model Configuration
    }
}