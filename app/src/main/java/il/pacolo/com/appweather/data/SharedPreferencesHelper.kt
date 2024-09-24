package il.pacolo.com.appweather.data

import android.content.Context
import android.content.SharedPreferences



// TODO: Shared proferences as Helper
// Dependency Injection (Optional but recommended)
//Use a Dependency Injection library like Dagger Hilt or Koin
// to provide the SharedPreferencesHelper and UserPreferencesRepositoryImpl
// instances in your ViewModel.

//this version does not support Shared Preferences


class SharedPreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    // Save a String value in SharedPreferences
    fun saveString(key: String, value: String) {
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()  // or commit() for synchronous saving
    }

    // Retrieve a String value from SharedPreferences
    fun getString(key: String, defaultValue: String = ""): String {
        return preferences.getString(key, defaultValue) ?: defaultValue
    }

    // Save a Boolean value in SharedPreferences
    fun saveBoolean(key: String, value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    // Retrieve a Boolean value from SharedPreferences
    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    // Save an Integer value in SharedPreferences
    fun saveInt(key: String, value: Int) {
        val editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    // Retrieve an Integer value from SharedPreferences
    fun getInt(key: String, defaultValue: Int = 0): Int {
        return preferences.getInt(key, defaultValue)
    }

    // Remove a specific key from SharedPreferences
    fun removeKey(key: String) {
        val editor = preferences.edit()
        editor.remove(key)
        editor.apply()
    }

    // Clear all data from SharedPreferences
    fun clearAll() {
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}
