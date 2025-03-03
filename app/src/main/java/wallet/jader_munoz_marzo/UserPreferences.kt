package wallet.jader_munoz_marzo

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {
    private val preferences: SharedPreferences = context.getSharedPreferences("user_prefs", Context.MODE_PRIVATE)

    fun saveUser(username: String) {
        preferences.edit().putString("username", username).apply()
    }

    fun getUser(): String {
        return preferences.getString("username", "") ?: ""
    }

    fun clearUser() {
        preferences.edit().remove("username").apply()
    }
}