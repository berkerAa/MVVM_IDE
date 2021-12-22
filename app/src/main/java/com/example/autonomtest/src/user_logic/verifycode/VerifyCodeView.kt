package com.example.autonomtest.src.user_logic.verifycode

import android.view.View
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.VerifyCodeModel
import javax.inject.Inject

//@EndImportLibraries
class VerifyCodeView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<VerifyCodeModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): VerifyCodeModel {
        return VerifyCodeModel(
            verifyCode1 = getEditText(R.id.editTextTextCode_input_1).toInt(),
            verifyCode2 = getEditText(R.id.editTextTextCode_input_2).toInt(),
            verifyCode3 = getEditText(R.id.editTextTextCode_input_3).toInt(),
            verifyCode4 = getEditText(R.id.editTextTextCode_input_4).toInt(),
            verifyCode5 = getEditText(R.id.editTextTextCode_input_5).toInt(),
            verifyCode6 = getEditText(R.id.editTextTextCode_input_6).toInt()
        ) //fill with Model Configuration
    }
}