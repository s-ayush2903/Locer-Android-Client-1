package org.locer.`in`

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.appintro.AppIntro
import com.github.appintro.AppIntroFragment
import com.github.appintro.AppIntroPageTransformerType

/**
 * Authored by Ayush Shrivastava on 7/8/20
 */

class IntroActivity : AppIntro() {
    private lateinit var prefs: SharedPreferences

    //    private val activity: IntroActivity()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        isButtonsEnabled = false

        setImmersiveMode()
        isIndicatorEnabled = true
        isColorTransitionsEnabled = true
        isVibrate = false
        setProgressIndicator()

        setTransformer(
            AppIntroPageTransformerType.Parallax(
                titleParallaxFactor = 1.0,
                imageParallaxFactor = -1.0,
                descriptionParallaxFactor = 2.0
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                backgroundColor = ContextCompat.getColor(this, R.color.dotInactive),
                title = "Greetings! \n You've landed at LOCER",
                description = getString(R.string.quick_deliv),
                imageDrawable = R.drawable.driver,
                titleColor = Color.YELLOW,
                descriptionColor = Color.CYAN
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                backgroundColor = ContextCompat.getColor(this, R.color.brownish),
                title = "An agreement of trust!",
                description = getString(R.string.deliv_reliability),
                imageDrawable = R.drawable.food1,
                titleColor = Color.YELLOW,
                descriptionColor = Color.BLACK
            )
        )

        addSlide(
            AppIntroFragment.newInstance(
                backgroundColor = ContextCompat.getColor(this, R.color.teal),
                title = "Now order food from a vast range of categories",
                description = getString(R.string.food_varieties),
                imageDrawable = R.drawable.food2,
                titleColor = Color.BLUE,
                descriptionColor = Color.BLACK
            )
        )

    }

    /** Called when the AppIntro reached the end. */
    override fun onIntroFinished() {
        super.onIntroFinished()
        setResult(Activity.RESULT_OK)
        finish()
        startActivity(Intent(this, MainActivity::class.java))

    }

    /** Called when the user clicked the skip button */
    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        startActivity(Intent(this, MainActivity::class.java))
        setResult(Activity.RESULT_OK)
        finish()
    }

    /** Called when the user clicked the done button */
    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        setResult(Activity.RESULT_OK)
        finish()
        startActivity(Intent(this, MainActivity::class.java))
        // start a new intent
    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are *not* resumed.
     */
    override fun onResume() {
        super.onResume()
        // FIXME created @ 7/8/20: add the flag in sharedPref to check whether the introScreen has been launched once or not
//        prefs = activity.getPreferences(Context.MODE_PRIVATE)
//        val previouslyLaunched: Boolean = prefs.getBoolean(getString(R.string.launched_once), false)
//        if (!previouslyLaunched) {
//            with(prefs.edit()) {
//                putBoolean(getString(R.string.launched_once), true)
//                commit()
//            }
//        }
    }

}
