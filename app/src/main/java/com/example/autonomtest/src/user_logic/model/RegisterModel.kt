package com.example.autonomtest.src.user_logic.model

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


sealed class RegisterStatus

data class RegisterRegisterSuccessful(var data: Any?): RegisterStatus()
data class RegisterUnmatchede_mail(var data: Any?): RegisterStatus()
data class RegisterControllerError(var data: Any?): RegisterStatus()
data class RegisterObservableErrorStatus(var data: Any?): RegisterStatus()

//@EndStatusCheckDecleration

data class RegisterModel(
	@SerializedName("e_mail") val e_mail: String,  //User Email Address
	@SerializedName("password") val password: String,  //User Password
	@SerializedName("name") val name: String,  //User Name Information
	@SerializedName("surname") val surname: String,  //User Surname Information
	@SerializedName("phone_number") val phone_number: String, //User Phone Number
	@Expose(deserialize = false) val ConfirmPassword: String
//@EndDataClassDecleration
)


