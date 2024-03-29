package com.example.autonomtest.app_modules.router


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

interface Router <T> {
    fun <T> onActivityChange(activity: AppCompatActivity, instance: Class<T>) = activity.startActivity(Intent(activity.applicationContext, instance))
    fun <T> onFragmentChange(activity: AppCompatActivity,containerViewId: Int, instance: Class<T>) = activity.supportFragmentManager.beginTransaction()
        .replace(containerViewId, instance.newInstance() as Fragment)
        .setReorderingAllowed(true)
        .commit()
    fun  navigationLogic(activity: AppCompatActivity, navigationStatus: T, containerViewId: Int = 0)
    fun navigationLogicOnBackPressed(activity: AppCompatActivity, activeScreen: Fragment, containerViewId: Int = 0)
}