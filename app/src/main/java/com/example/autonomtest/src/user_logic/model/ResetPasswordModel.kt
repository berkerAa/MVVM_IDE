package com.example.autonomtest.src.user_logic.model

import com.google.gson.annotations.SerializedName

sealed class ResetPasswordStatus

data class ResetPasswordemailerror(var data: Any?): ResetPasswordStatus()
data class ResetPasswordpasswordmatcherror(var data: Any?): ResetPasswordStatus()
data class ResetPasswordResetPasswordSuccess(var data: Any?): ResetPasswordStatus()
data class ResetPasswordControllerError(var data: Any?): ResetPasswordStatus()
data class ResetPasswordObservableErrorStatus(var data: Any?): ResetPasswordStatus()

//@EndStatusCheckDecleration

data class ResetPasswordModel(
	@SerializedName("password") val password: String,  //User New Password

//@EndDataClassDecleration
)


