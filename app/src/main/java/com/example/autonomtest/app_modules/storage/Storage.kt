package com.example.autonomtest.app_modules.storage

interface Storage {
    fun setString(key: String, value: String)
    fun getString(key: String): String

}