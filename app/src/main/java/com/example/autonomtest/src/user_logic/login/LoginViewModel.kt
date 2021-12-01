package com.example.autonomtest.src.user_logic.login

import com.example.autonomtest.src.user_logic.UserRepository
import javax.inject.Inject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.autonomtest.app_modules.web_api.response.BaseResponse
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.model.*

class LoginViewModel @Inject constructor(private val userRepository: UserRepository) {
/**
* Return Observable API Result status with result data placeholder 
* The model argument must specify a model description of specified business case.
* <p>
* @param  model data class description of unseriliazed Json Format
* @return      Observable API results status
*/
fun onLogin(loginModel: LoginModel): Observable<LoginStatus>
    {
        return userRepository.onLogin(loginModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { status ->
                when(status.status)
                {
			  10002 -> LoginLoginSuccess(status.data)
			  20002 -> LoginEmailAutherror(status.data)
			  20003 -> LoginPasswordAutherror(status.data)
			  20004 -> LoginVerificationerror(status.data)
			  30002 -> Logincontrollererror(status.data)
			  else -> LoginObservableErrorStatus(status.data)
                    
		//@EndStatusMapping
                }
            }
    }

	//@StartRepositoryConnection


/**
* Return Observable Calculation status with result data placeholder 
* The model argument must specify a model description of specified business case.
* <p>
* @return      Observable Calculation results status
*/
	//@StartCustomCalculation
}