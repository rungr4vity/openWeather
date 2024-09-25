package il.pacolo.com.appweather.data


// TODO: Shared proferences as Helper
// Dependency Injection (Optional but recommended)
//Use a Dependency Injection library like Dagger Hilt or Koin
// to provide the SharedPreferencesHelper and UserPreferencesRepositoryImpl
// instances in your ViewModel.

//this version does not support Shared Preferences

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesHelper(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences("MyAppPreferences", Context.MODE_PRIVATE)

    // Check if a key exists in SharedPreferences
    fun keyExists(key: String): Boolean {
        return preferences.contains(key)
    }

    // Save a String value if the key does not already exist
    fun saveStringIfNotExists(key: String, value: String) {
        if (!keyExists(key)) {
            saveString(key, value)
        }
    }

    // Save a String value in SharedPreferences
    private fun saveString(key: String, value: String) {
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    // Retrieve a String value from SharedPreferences
    fun getString(key: String, defaultValue: String = ""): String {
        return preferences.getString(key, defaultValue) ?: defaultValue
    }

    // Save a Boolean value if the key does not already exist
    fun saveBooleanIfNotExists(key: String, value: Boolean) {
        if (!keyExists(key)) {
            saveBoolean(key, value)
        }
    }

    // Save a Boolean value in SharedPreferences
    private fun saveBoolean(key: String, value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    // Save an Integer value if the key does not already exist
    fun saveIntIfNotExists(key: String, value: Int) {
        if (!keyExists(key)) {
            saveInt(key, value)
        }
    }

    // Save an Integer value in SharedPreferences
    private fun saveInt(key: String, value: Int) {
        val editor = preferences.edit()
        editor.putInt(key, value)
        editor.apply()
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
