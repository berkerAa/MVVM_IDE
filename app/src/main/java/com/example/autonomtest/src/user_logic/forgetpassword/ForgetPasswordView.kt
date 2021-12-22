package com.example.autonomtest.src.user_logic.forgetpassword

import android.view.View
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.ForgetPasswordModel
import javax.inject.Inject

//@EndImportLibraries
class ForgetPasswordView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<ForgetPasswordModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): ForgetPasswordModel {
        return ForgetPasswordModel(
            e_mail = getEditText(R.id.editTextTextEmailAddress_forgetpassword)
        ) //fill with Model Configuration
    }
}