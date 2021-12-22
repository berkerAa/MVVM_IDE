package com.example.autonomtest.src.user_logic.register

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
import com.example.autonomtest.src.user_logic.model.*

class RegisterPresenter: Presenter<RegisterViewModel, RegisterModel>() {
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
            layoutId = R.layout.activity_user_welcome_screen_layout,
            container = container,
            inflater = inflater
        )
        //viewBinding.setOnClick(R.id.button_register_screen_login){
          //  (activity as UserBridge).navigation(Login())
        //}
        viewBinding.postExecute() 
        return viewBinding.view
    }

    fun onRegister() = compositeDisposable.add(viewModel.onRegister(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
			is RegisterRegisterSuccessful -> {}//Perform action on Register successful, please check your e-mail to verify your account.
			is RegisterUnmatchede_mail -> {}//Perform action on An Account with this e-mail already exists
			is RegisterControllerError -> {}//Perform action on Problem on backend register controller
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}