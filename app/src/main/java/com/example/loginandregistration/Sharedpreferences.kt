package com.example.loginandregistration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log


class SharedPreference(val context: Context) {

    private val PREFS_NAME = "kotlincodes"

    companion object {
        private const val KEY_CURRENT_ID = "currentId"
        private const val IS_LOGGED = "isLogged"
    }


    val sharedPref: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    fun setIsLogged(){
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(IS_LOGGED, false).apply()
    }

    fun getIsLogged() =  sharedPref.getBoolean(IS_LOGGED,false)


    fun setId(person_id: Int){
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putString(KEY_CURRENT_ID, person_id.toString()).apply()
        editor.putBoolean(IS_LOGGED ,true).apply()
    }

    fun getCurrentId() = sharedPref.getString(KEY_CURRENT_ID,null).toInt()

}
