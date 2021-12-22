package com.example.autonomtest.src.user_logic.login

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import android.util.Log
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.core.widget.addTextChangedListener
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.ForgetPassword
import com.example.autonomtest.src.user_logic.Register
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
            inflater = inflater,
            layoutId = R.layout.activity_user_login_layout,
            container = container
        )


        viewBinding.setOnClick(R.id.button_activity_user_login_layout_create_an_Account){

            (activity as UserBridge).navigation(Register())
        }
        viewBinding.setOnClick(R.id.button_forgot_password_activity_user_login_layout){
            (activity as UserBridge).navigation(ForgetPassword())

        }






            viewBinding.setOnClick(R.id.imageButton_Activity_user_login_layout_login)
            {
                compositeDisposable.add(viewModel.onLogin(viewBinding.getObject())
                    .subscribe({ status ->
                        when (status)
                        {
                            is LoginLoginSuccess -> {}//Perform action on User credentials correct, auth passed
                            is LoginEmailAutherror -> {viewBinding.setVisibility(R.id.textView_ac_user_login_popupmessage_error,View.GONE)}//Perform action on Entered e_mail does not match
                            is LoginPasswordAutherror -> {viewBinding.setVisibility(R.id.textView_ac_user_login_popupmessage_error,View.GONE)}//Perform action on Entered password does not match
                            is LoginVerificationerror -> {}//Perform action on Account is not verified! Please check your email to verify your account.
                            is Logincontrollererror -> {}//Perform action on Problem on backend login controller
                        }
                    },
                        {error ->
                            Log.d("Error", error.toString())
                        })
                )
            }

            return viewBinding.view
        }
    }
