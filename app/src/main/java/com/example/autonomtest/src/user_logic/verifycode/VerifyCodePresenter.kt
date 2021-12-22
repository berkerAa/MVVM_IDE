package com.example.autonomtest.src.user_logic.verifycode

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import android.util.Log
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.ForgetPassword
import com.example.autonomtest.src.user_logic.ResetPassword
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.model.*

class VerifyCodePresenter: Presenter<VerifyCodeViewModel, VerifyCodeModel>() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as UserBridge).component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setView(
            layoutId = R.layout.activity_user_verifycode_layout,
            container = container,
            inflater = inflater
        )
        viewBinding.setOnClick(R.id.imageButton_ac_user_change_password__layout){
            (activity as UserBridge).navigation(ResetPassword())
        }
        viewBinding.setOnClick(R.id.button_activity_user_code_layout_back_button){
            (activity as UserBridge).navigation(ForgetPassword())
        }
        viewBinding.postExecute() 
        return viewBinding.view
    }

    fun onVerifyCode() = compositeDisposable.add(viewModel.onVerifyCode(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}