package com.example.autonomtest.src.user_logic.resetpassword

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.autonomtest.R
import android.util.Log
import android.widget.ImageButton
import androidx.core.view.isVisible
import com.example.autonomtest.app_modules.presenter.Presenter
import com.example.autonomtest.src.user_logic.Login
import com.example.autonomtest.src.user_logic.Register
import com.example.autonomtest.src.user_logic.UserBridge
import com.example.autonomtest.src.user_logic.model.*

class ResetPasswordPresenter: Presenter<ResetPasswordViewModel, ResetPasswordModel>() {
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
            layoutId = R.layout.activity_user_resetpassword_layout,
            container = container,
            inflater = inflater
        )


        viewBinding.setOnClick(R.id.imageButton_ac_user_resetpassword_layout_eye){
        onButtonChange(ImageButtonID = R.drawable.group_124)

        }
        viewBinding.setOnClick(R.id.reset_password_button_ac_user_resetpassword_layout){
            (activity as UserBridge).navigation(Login())
        }


        viewBinding.postExecute() 
        return viewBinding.view
    }
    fun View.isVisible(): Boolean {
        return visibility == View.VISIBLE
    }
      fun onButtonChange(ImageButtonID: Int) {
        viewBinding.view.findViewById<ImageButton>(ImageButtonID).setBackgroundResource(R.drawable.group_124)

    }


    fun onResetPassword() = compositeDisposable.add(viewModel.onResetPassword(viewBinding.getObject())
        .subscribe({ status ->
            when (status)
            {
			is ResetPasswordemailerror -> {}//Perform action on Received e_mail is not valid
			is ResetPasswordpasswordmatcherror -> {}//Perform action on Old password and new password can not be the same
			is ResetPasswordResetPasswordSuccess -> {}//Perform action on Password successfully updated 
			is ResetPasswordControllerError -> {}//Perform action on Problem on backend resetPassword controller
                
		//@EndStatusCheck
            }
        },
            {error ->
                Log.d("Error", error.toString())
            })
    )
}