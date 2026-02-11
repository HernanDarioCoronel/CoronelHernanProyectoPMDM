package ies.murallaromana.coronelhernanproyectopmdp.sharedPreferences

import android.content.Context

class UserPreferences(context: Context) {
    private val prefs = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveData(user: String, pass: String) {
        prefs.edit().apply {
            putString("user_name", user)
            putString("user_pass", pass)
            apply()
        }
    }

    fun getUser(): String = prefs.getString("user_name", "") ?: ""
    fun getPass(): String = prefs.getString("user_pass", "") ?: ""
}