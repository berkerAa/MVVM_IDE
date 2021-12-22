package com.example.autonomtest.src.user_logic.forgetpassword

import com.example.autonomtest.app_modules.storage.Storage
import com.example.autonomtest.src.user_logic.UserRepository
import javax.inject.Inject
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.autonomtest.app_modules.web_api.response.BaseResponse
import com.example.autonomtest.src.user_logic.ds.UserScope
import com.example.autonomtest.src.user_logic.model.*

class ForgetPasswordViewModel @Inject constructor(private val userRepository: UserRepository,  private val storage: Storage) {
/**
* Return Observable API Result status with result data placeholder 
* The model argument must specify a model description of specified business case.
* <p>
* @param  model data class description of unseriliazed Json Format
* @return      Observable API results status
*/
fun onForgetPassword(forgetpasswordModel: ForgetPasswordModel): Observable<ForgetPasswordStatus>
    {
        return userRepository.onForgetPassword(forgetpasswordModel)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { status ->
                when(status.status)
                {
			  20030 -> ForgetPasswordEmailError(status.data)
			  20031 -> ForgetPasswordEmailMatchError(status.data)
			  10003 -> storage.setString(VERIFY_CODE, status.message).run {
                  ForgetPasswordCodeSendSuccess(
                      status.data
                  )
              }
			  30003 -> ForgetPasswordControllerError(status.data)
			  else -> ForgetPasswordObservableErrorStatus(status.data)
                    
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

    companion object{
        const val VERIFY_CODE = "verify_code"
    }
}