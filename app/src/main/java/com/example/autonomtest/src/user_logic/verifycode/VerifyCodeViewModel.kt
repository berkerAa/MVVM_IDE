package com.example.autonomtest.src.user_logic.verifycode

import com.example.autonomtest.src.user_logic.UserRepository
import javax.inject.Inject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.autonomtest.app_modules.web_api.response.BaseResponse
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.model.*

class VerifyCodeViewModel @Inject constructor(private val userRepository: UserRepository) {
/**
* Return Observable API Result status with result data placeholder 
* The model argument must specify a model description of specified business case.
* <p>
* @param  model data class description of unseriliazed Json Format
* @return      Observable API results status
*/
fun onVerifyCode(verifycodeModel: VerifyCodeModel): Observable<VerifyCodeStatus>
    {
        return userRepository.onVerifyCode(verifycodeModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { status ->
                when(status.status)
                {
			  else -> VerifyCodeObservableErrorStatus(status.data)
                    
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