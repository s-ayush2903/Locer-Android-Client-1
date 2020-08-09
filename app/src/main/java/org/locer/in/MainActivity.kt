package org.locer.`in`

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.locer.`in`.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferenceUtil: SharedPreferenceUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val sharedPref: SharedPreferences =
//            getSharedPreferences(getString(R.string.launched_once), Context.MODE_PRIVATE)

//        val boundLayout: ActivityMainBinding =
//            DataBindingUtil.setContentView(this, R.layout.activity_main)

//        boundLayout.testButton.setOnClickListener {
//                startActivity(Intent(this, IntroActivity::class.java))}
//        startActivity(intentForNextScreen)
        sharedPreferenceUtil = SharedPreferenceUtil(context = this)
        if (sharedPreferenceUtil.showIntro()) {
            val homeIntent = Intent(this, IntroActivity::class.java)
            startActivity(homeIntent)
            sharedPreferenceUtil.putPrefIsFirstRun(isFirstRun = true)
            sharedPreferenceUtil.setIntroShown()
            finish()
        } else {
            val boundLayout: ActivityMainBinding =
                DataBindingUtil.setContentView(this, R.layout.activity_main)

            boundLayout.testButton.setOnClickListener {
                startActivity(Intent(this, IntroActivity::class.java))
            }

        }
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are *not* resumed.
     */
//    override fun onResume() {
//        super.onResume()
//        prefs = activity.getPreferences(Context.MODE_PRIVATE)
//        val previouslyLaunched: Boolean = prefs.getBoolean(getString(R.string.launched_once), false)
//        if (!previouslyLaunched) {
//            with(prefs.edit()) {
//                putBoolean(getString(R.string.launched_once), true)
//                commit()
//            }
//        }
//    }

    private fun launchIntro() {
    }

    val intentForNextScreen: Intent
        get() = if (sharedPreferenceUtil.showIntro())
            Intent(this, IntroActivity::class.java)
        else
            Intent(this, MainActivity::class.java)

}
