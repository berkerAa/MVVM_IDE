package com.example.autonomtest.app_modules.view_binding

import android.view.View
import android.widget.EditText

interface  ViewBinding<T>{
    var view: View
    fun setOnClick(tag: String, executor: () -> Unit) = run {
        view.findViewWithTag<View>(tag).setOnClickListener{ executor()}
    }
    fun setAdapter(items: Any?, listener: Any) = 0
    fun setAdapter(items: Any?): Int{
        return 0
    }
    fun getMap(): Map<Int, ArrayList<ArrayList<Float>>> = mapOf()

    fun getObject(items: ArrayList<String> = arrayListOf()) : T

    fun setEditText(tag: String, value:String)
        = view.findViewWithTag<EditText>(tag).setText(value)
    fun getEditText(id:Int)
            = view.findViewById<EditText>(id).text.toString()
    fun postExecute( ): Int = 0
}