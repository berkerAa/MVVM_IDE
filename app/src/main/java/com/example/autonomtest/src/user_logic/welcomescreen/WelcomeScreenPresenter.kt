package com.example.autonomtest.src.user_logic.welcomescreen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.Login
import com.example.autonomtest.src.user_logic.Register
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.model.WelcomeScreenModel

class WelcomeScreenPresenter: Presenter<WelcomeScreenViewModel, WelcomeScreenModel>() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as UserBridge).component.inject(WelcomeScreenPresenter())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setView(
            inflater = inflater,
            layoutId = R.layout.activity_user_welcome_screen_layout,
            container = container


        )

        viewBinding.setOnClick(R.id.button_welcome_screen_register){
            (activity as UserBridge).navigation(Register())
        }

        viewBinding.setOnClick(R.id.textview_activity_welcome_screen_login){
            (activity as UserBridge).navigation(Login())
        }

        return viewBinding.view
    }
}