package com.example.autonomtest.app_modules.variable_storage

import com.example.autonomtest.app_modules.variable.Variable
import javax.inject.Inject

class VariableStorageProvider @Inject constructor(): VariableStorage {

    val VariableMap: MutableMap<String, Map<String, Map<String, Variable>>> by lazy {
        mutableMapOf()
    }

    override fun  setData(
        logic: String,
        screen: String,
        nameField: String,
        data: Variable
    ) {
        TODO("Map Logic Implementation Needed")
    }

    override fun pullData(logic: String, screen: String, nameField: String) {
        TODO("Not yet implemented")
    }
}