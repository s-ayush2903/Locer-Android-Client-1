package org.locer.`in`

import android.Manifest
import android.app.Activity
import android.content.Intent
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setImmersiveMode()
        isButtonsEnabled = false
        isIndicatorEnabled = true
        isColorTransitionsEnabled = true
        isVibrate = false
        setProgressIndicator()

        // for added parallax effect
        setTransformer(
            AppIntroPageTransformerType.Parallax(
                titleParallaxFactor = 1.0,
                imageParallaxFactor = -1.0,
                descriptionParallaxFactor = 2.0
            )
        )

        // TODO: 9/8/20 colors of slides and text need to be changed
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

        addSlide(
            AppIntroFragment.newInstance(
                backgroundColor = ContextCompat.getColor(this, R.color.teal),
                title = getString(R.string.permssions_title),
                description = getString(R.string.permssions_desc),
                imageDrawable = R.drawable.permits,
                titleColor = Color.BLUE,
                descriptionColor = Color.BLACK
            )
        )

        // mandatory permissions, they have to be provided at the time of asking
        // TODO: 9/8/20 Handle the case when user denies the permissions for now or chooses the option *Never ask again*
        askPermissions()
    }

    fun askPermissions() {
        askForPermissions(
            permissions = arrayOf(
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.READ_SMS
            ),
            slideNumber = 4,
            required = true
        )
    }

    /** Called when the AppIntro reached the end. */
    override fun onIntroFinished() {
        super.onIntroFinished()
        setResult(Activity.RESULT_OK)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    /** Called when the user clicked the skip button */
    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        askPermissions()
        startActivity(Intent(this, MainActivity::class.java))
        setResult(Activity.RESULT_OK)
        finish()
    }

    /** Called when the user clicked the done button */
    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        setResult(Activity.RESULT_OK)
        // start a new intent
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}
