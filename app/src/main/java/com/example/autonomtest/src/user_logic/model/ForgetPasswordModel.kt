package com.example.autonomtest.src.user_logic.model

import com.google.gson.annotations.SerializedName

sealed class ForgetPasswordStatus

data class ForgetPasswordEmailError(var data: Any?): ForgetPasswordStatus()
data class ForgetPasswordEmailMatchError(var data: Any?): ForgetPasswordStatus()
data class ForgetPasswordCodeSendSuccess(var data: Any?): ForgetPasswordStatus()
data class ForgetPasswordControllerError(var data: Any?): ForgetPasswordStatus()
data class ForgetPasswordObservableErrorStatus(var data: Any?): ForgetPasswordStatus()

//@EndStatusCheckDecleration

data class ForgetPasswordModel(
	@SerializedName("e_mail") val e_mail: String,  //User Email Address

//@EndDataClassDecleration
)


