package com.example.autonomtest.src.user_logic.login

import android.view.View
import android.widget.EditText
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.LoginModel
import javax.inject.Inject

//@EndImportLibraries
class LoginView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<LoginModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): LoginModel {
        return LoginModel(
            e_mail = getEditText(R.id.email_loginscreen),
            password = getEditText(R.id.editTextTextPassword_loginscreen)

        ) //fill with Model Configuration
    }
}