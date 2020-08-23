package org.locer.`in`

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import org.locer.`in`.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    private lateinit var boundLayout: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferenceUtil = SharedPreferenceUtil(context = this)
        if (sharedPreferenceUtil.showIntro()) {
            val homeIntent = Intent(this, IntroActivity::class.java)
            startActivity(homeIntent)
            sharedPreferenceUtil.setIntroShown()
            finish()
        } else {
            boundLayout = DataBindingUtil.setContentView(this, R.layout.activity_main)

            boundLayout.testButton.setOnClickListener {
                startActivity(Intent(this, IntroActivity::class.java))
            }
        }
    }

// don't remove the following code, it may be helpful in future that's why it is kept here
//    val intentForNextScreen: Intent
//        get() = if (sharedPreferenceUtil.showIntro())
//            Intent(this, IntroActivity::class.java)
//        else
//            Intent(this, MainActivity::class.java)

}
