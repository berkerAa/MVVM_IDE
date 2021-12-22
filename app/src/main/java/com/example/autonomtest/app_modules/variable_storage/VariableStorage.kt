package com.example.autonomtest.app_modules.variable_storage

import com.example.autonomtest.app_modules.variable.Variable
import com.example.autonomtest.app_modules.view_model.ViewModelMaster

interface VariableStorage {

    fun setData(logic: String, screen: String, nameField: String, data: Variable<ViewModelMaster>)

    fun pullData(logic: String, screen: String, nameField: String)
}