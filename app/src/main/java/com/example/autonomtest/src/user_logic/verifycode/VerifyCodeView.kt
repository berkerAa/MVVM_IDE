package com.example.autonomtest.src.user_logic.verifycode

import android.view.View
import com.example.autonomtest.app_modules.view_binding.ViewBinding
import com.example.autonomtest.src.user_logic.model.VerifyCodeModel
import javax.inject.Inject

//@EndImportLibraries
class VerifyCodeView @Inject constructor(

//@EndDependencyInjection
): ViewBinding<VerifyCodeModel> {
    override lateinit var view: View

    override fun getObject(items: ArrayList<String>): VerifyCodeModel {
        return VerifyCodeModel() //fill with Model Configuration
    }
}