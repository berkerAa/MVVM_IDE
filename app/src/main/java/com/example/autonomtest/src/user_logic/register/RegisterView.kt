package com.example.autonomtest.src.user_logic.registerC

import android.view.View
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.RegisterModel
import javax.inject.Inject

//@EndImportLibraries
class RegisterView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<RegisterModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): RegisterModel {
        return RegisterModel(
            name = getEditText(R.id.editTextTextPersonName_register_screen),
            surname = getEditText(R.id.editTextTextPersonName2_surname_register_screen),
            e_mail = getEditText(R.id.editTextTextEmailAddress_register_screen),
            phone_number = getEditText(R.id.editTextPhone_register_screen),
            password = getEditText(R.id.editTextTextPassword_register_screen),
            ConfirmPassword = getEditText(R.id.editTextTextPassword2_register)



        ) //fill with Model Configuration
    }
}