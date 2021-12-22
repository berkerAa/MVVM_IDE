package com.example.autonomtest.src.user_logic.forgetpassword

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import android.util.Log
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.Login
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.VerifyCode
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
        viewBinding.setOnClick(R.id.button_activity_user_forgetpass_layout_back_button){
            (activity as UserBridge).navigation(Login())
        }
        viewBinding.setOnClick(R.id.ac_user_forgetpassword_layout_request_email_button){
            (activity as UserBridge).navigation(VerifyCode())
        }
        viewBinding.postExecute() 
        return viewBinding.view
    }

    fun onForgetPassword() = compositeDisposable.add(viewModel.onForgetPassword(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
			is ForgetPasswordEmailError ->  Log.d("Email Error", "Wrong Email")//Perform action on Not a valid e-mail
			is ForgetPasswordEmailMatchError -> Log.d("email_match_error", "e- mail match error")//Perform action on Entered e_mail does not match
			is ForgetPasswordCodeSendSuccess -> Log.d("Email_code_send_success", "email code send success")//Perform action on Please check your email for reset password code to verify
			is ForgetPasswordControllerError -> Log.d("Forget_password_controller_error", "")//Perform action on Problem on backend forgotPassword controller
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}