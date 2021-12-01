package com.example.autonomtest.app_modules.variable

import androidx.lifecycle.LiveData
import com.example.autonomtest.app_modules.view_model.ViewModelMaster
import javax.inject.Inject

sealed class VariableResult

data class VariableSuccess<DataType: Any>(val Data: DataType): VariableResult()

/**
 * Variable pre check output for fail cases, Status code represents story code of given wrong input parameter.
 * @constructor Takes message and status code value for initialization
 * @param message Log message for status debugging
 * @param statusCode Case code of occurred exception
 * @Inherits Variable Result
 */
data class VariableFail(val message: String, val statusCode: Int=-1): VariableResult()

/**
 * Variable Setter object for initial setup
 * @constructor Takes data value for initialization
 * @param data data that will be parsed to variable class
 * @Type statusCode Case code of occurred exception
 * @Inherits Variable Result for case switch
 */
data class VariableSetter<out DataType: Any>(val data: DataType): VariableResult()


abstract class Variable<T: ViewModelMaster>: VariableResult(){
    @Inject lateinit var viewModel: T
    var DATA: VariableResult
        get() = get()
        set(value) = set(value)

    abstract fun get(): VariableResult

    abstract fun set(value: VariableResult)

}