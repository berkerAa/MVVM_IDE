package com.example.autonomtest.app_modules.variable_storage

import com.example.autonomtest.app_modules.variable.Variable

interface VariableStorage {

    fun setData(logic: String, screen: String, nameField: String, data: Variable)

    fun pullData(logic: String, screen: String, nameField: String)
}