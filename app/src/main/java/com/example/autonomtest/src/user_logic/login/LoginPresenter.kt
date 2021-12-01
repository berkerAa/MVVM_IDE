package com.example.autonomtest.src.user_logic.login

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

class LoginPresenter: Presenter<LoginViewModel, LoginModel>() {
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
            layoutId = R.layout.activity_user_login_layout,
            container = container,
            inflater = inflater
        )
        viewBinding.postExecute() 
        return viewBinding.view
    }

    fun onLogin() = compositeDisposable.add(viewModel.onLogin(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
			is LoginLoginSuccess -> {}//Perform action on User credentials correct, auth passed
			is LoginEmailAutherror -> {}//Perform action on Entered e_mail does not match
			is LoginPasswordAutherror -> {}//Perform action on Entered password does not match
			is LoginVerificationerror -> {}//Perform action on Account is not verified! Please check your email to verify your account.
			is Logincontrollererror -> {}//Perform action on Problem on backend login controller
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}