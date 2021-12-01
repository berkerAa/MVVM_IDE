package com.example.autonomtest.src.user_logic.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

sealed class VerifyCodeStatus

data class VerifyCodeObservableErrorStatus(var data: Any?): VerifyCodeStatus()

//@EndStatusCheckDecleration

data class VerifyCodeModel(


//@EndDataClassDecleration
)


