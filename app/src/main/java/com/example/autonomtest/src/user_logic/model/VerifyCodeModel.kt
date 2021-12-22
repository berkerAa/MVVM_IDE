package com.example.autonomtest.src.user_logic.model

import androidx.core.app.RemoteInput
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class VerifyCodeStatus

data class VerifyCodeObservableErrorStatus(var data: Any?): VerifyCodeStatus()

//@EndStatusCheckDecleration

data class VerifyCodeModel(
@Expose val verifyCode1:Int,
@Expose val verifyCode2:Int,
@Expose val verifyCode3: Int,
@Expose val verifyCode4: Int,
@Expose val verifyCode5:Int,
@Expose val verifyCode6: Int

)


