package com.example.autonomtest.src.user_logic

import com.example.autonomtest.app_modules.web_api.WebApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.autonomtest.app_modules.web_api.response.BaseResponse
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.model.*
import javax.inject.Inject

@UserScope
class UserRepository @Inject constructor(private val webApi: WebApi) {
	fun onLogin(loginModel: LoginModel): Observable<BaseResponse> {
        	return webApi.login(loginModel)
            		.subscribeOn(Schedulers.io())
            		.observeOn(AndroidSchedulers.mainThread())
    	}
	fun onRegister(registerModel: RegisterModel): Observable<BaseResponse> {
        	return webApi.register(registerModel)
            		.subscribeOn(Schedulers.io())
            		.observeOn(AndroidSchedulers.mainThread())
    	}
	fun onForgetPassword(forgetpasswordModel: ForgetPasswordModel): Observable<BaseResponse> {
        	return webApi.forgetpassword(forgetpasswordModel)
            		.subscribeOn(Schedulers.io())
            		.observeOn(AndroidSchedulers.mainThread())
    	}
	fun onVerifyCode(verifycodeModel: VerifyCodeModel): Observable<BaseResponse> {
        	return webApi.verifycode(verifycodeModel)
            		.subscribeOn(Schedulers.io())
            		.observeOn(AndroidSchedulers.mainThread())
    	}
	fun onResetPassword(resetpasswordModel: ResetPasswordModel): Observable<BaseResponse> {
        	return webApi.resetpassword(resetpasswordModel)
            		.subscribeOn(Schedulers.io())
            		.observeOn(AndroidSchedulers.mainThread())
    	}

	//@EndRepositoryConnections
}