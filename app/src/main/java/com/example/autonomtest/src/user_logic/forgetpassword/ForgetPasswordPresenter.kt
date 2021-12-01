package com.example.autonomtest.src.user_logic.forgetpassword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import android.util.Log
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.model.*

class ForgetPasswordPresenter: Presenter<ForgetPasswordViewModel, ForgetPasswordModel>() {
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
            layoutId = R.layout.activity_user_forgetpassword_layout,
            container = container,
            inflater = inflater
        )
        viewBinding.postExecute() 
        return viewBinding.view
    }

    fun onForgetPassword() = compositeDisposable.add(viewModel.onForgetPassword(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
			is ForgetPasswordEmailError -> {}//Perform action on Not a valid e-mail
			is ForgetPasswordEmailmatcherror -> {}//Perform action on Entered e_mail does not match
			is ForgetPasswordCodeSendSuccess -> {}//Perform action on Please check your email for reset password code to verify
			is ForgetPasswordControllerError -> {}//Perform action on Problem on backend forgotPassword controller
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}