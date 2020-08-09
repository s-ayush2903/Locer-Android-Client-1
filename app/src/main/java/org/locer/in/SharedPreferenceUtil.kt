package org.locer.`in`

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager

/**
 * Authored by Ayush Shrivastava on 7/8/20
 */
class SharedPreferenceUtil(context: Context) {

    private val sharedPreferences: SharedPreferences =
        PreferenceManager.getDefaultSharedPreferences(context)

    val prefIsFirstRun: Boolean
        get() = sharedPreferences.getBoolean(PREF_IS_FIRST_RUN, false)


    fun putPrefIsFirstRun(isFirstRun: Boolean) =
        sharedPreferences.edit { putBoolean(PREF_IS_FIRST_RUN, isFirstRun) }

    fun showIntro(): Boolean = sharedPreferences.getBoolean(LAUNCHED_INTRO, true)
    fun setIntroShown() = sharedPreferences.edit { putBoolean(LAUNCHED_INTRO, false) }


    companion object {
        const val LAUNCHED_INTRO = "Launched intro screen once"
        private const val PREF_IS_FIRST_RUN = "isFirstRun"
    }

}
