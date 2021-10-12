package com.example.a7minworkout.activity.shared

import android.content.Context
import android.content.SharedPreferences

object SharedPreference {
    private const val NAME = "app_name"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var prefernce: SharedPreferences

    fun init(context: Context) {
        prefernce = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor: SharedPreferences.Editor = edit()
        operation(editor)
        editor.apply()
    }

    var userDate: String?
        get() = prefernce.getString("user", "")
        set(value) = prefernce.edit() {
            if (value != null) {
                it.putString("user", value)
            }
        }

}