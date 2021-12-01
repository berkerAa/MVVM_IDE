package com.example.autonomtest.app_modules.web_api

import com.example.autonomtest.app_modules.web_api.response.BaseResponse

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.Headers
import com.example.autonomtest.src.user_logic.model.LoginModel
import com.example.autonomtest.src.user_logic.model.RegisterModel
import com.example.autonomtest.src.user_logic.model.ForgetPasswordModel
import com.example.autonomtest.src.user_logic.model.VerifyCodeModel
import com.example.autonomtest.src.user_logic.model.ResetPasswordModel
import retrofit2.http.POST
//@EndImportLibraries
interface WebApi {
	@Headers("Content-Type:application/json")
	@POST("/login")
	fun login(@Body loginModel: LoginModel): Observable<BaseResponse>
	@Headers("Content-Type:application/json")
	@POST("/register")
	fun register(@Body registerModel: RegisterModel): Observable<BaseResponse>
	@Headers("Content-Type:application/json")
	@POST("/forget_password")
	fun forgetpassword(@Body forgetpasswordModel: ForgetPasswordModel): Observable<BaseResponse>
	@Headers("Content-Type:application/json")
	@POST("/reset_password")
	fun resetpassword(@Body resetpasswordModel: ResetPasswordModel): Observable<BaseResponse>


//@EndNetworkRegisterEnds
}