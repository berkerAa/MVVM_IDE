package com.example.autonomtest.src.user_logic.resetpassword

import android.view.View
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.ResetPasswordModel
import javax.inject.Inject

//@EndImportLibraries
class ResetPasswordView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<ResetPasswordModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): ResetPasswordModel {
        return ResetPasswordModel(
            password = getEditText(R.id.edit_text_password_resetpassword_screen)
        ) //fill with Model Configuration
    }
}