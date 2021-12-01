package com.example.autonomtest.src.user_logic.model

import com.google.gson.annotations.SerializedName

sealed class LoginStatus

data class LoginLoginSuccess(var data: Any?): LoginStatus()
data class LoginEmailAutherror(var data: Any?): LoginStatus()
data class LoginPasswordAutherror(var data: Any?): LoginStatus()
data class LoginVerificationerror(var data: Any?): LoginStatus()
data class Logincontrollererror(var data: Any?): LoginStatus()
data class LoginObservableErrorStatus(var data: Any?): LoginStatus()

//@EndStatusCheckDecleration

data class LoginModel(
	@SerializedName("e_mail") val e_mail: String,  //User Email Address
	@SerializedName("password") val password: String //User Password

//@EndDataClassDecleration
)


