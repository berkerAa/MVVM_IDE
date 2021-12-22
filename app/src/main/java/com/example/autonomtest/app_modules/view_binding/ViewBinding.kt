package com.example.autonomtest.app_modules.view_binding

import android.view.View
import android.widget.EditText
import android.widget.TextView

interface  ViewBinding<T>{
    var view: View
    fun setOnClick(id: Int, executor: () -> Unit) = run {
        view.findViewById<View>(id).setOnClickListener{ executor()}
    }
    fun setAdapter(items: Any?, listener: Any) = 0
    fun setAdapter(items: Any?): Int{
        return 0
    }
    fun getMap(): Map<Int, ArrayList<ArrayList<Float>>> = mapOf()

    fun getObject(items: ArrayList<String> = arrayListOf()) : T

    fun setVisibility(Id: Int, value: Int)
        = view.findViewById<TextView>(Id).setText(value)


    fun setEditText(tag: String, value:String)
        = view.findViewWithTag<EditText>(tag).setText(value)
    fun getEditText(id:Int)
            = view.findViewById<EditText>(id).text.toString()
    fun postExecute( ): Int = 0
}