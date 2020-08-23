package org.locer.`in`

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.locer.`in`.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferenceUtil: SharedPreferenceUtil
    private lateinit var boundLayout: ActivityMainBinding
    private lateinit var bottomNavView: BottomNavigationView
    private lateinit var navController:NavController
    private var actionMode: ActionMode? = null
    private val finishActionModeOnDestinationChanged =
        NavController.OnDestinationChangedListener { controller, destination, bundle -> actionMode?.finish() }


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
            bottomNavView = boundLayout.mainBottomNavView
            findNavController(R.id.main_nav_host_fragment)
//            navController.addOnDestinationChangedListener(finishActionModeOnDestinationChanged)
//            setUpNavMenus(navController)
//            setUpBottomNavMenu(findNavController(R.id.main_bottom_nav_view))
//            boundLayout.mainBottomNavView.setOnNavigationItemSelectedListener {
//                when(it.itemId){
//                    R.id.actionCart -> findNavController(R.id.action_homeFragment_to_cartFragment)
//                }
//            }
//            findNavController(R.id.main_nav_host_fragment)
//            boundLayout.testButton.setOnClickListener {
//                startActivity(Intent(this, IntroActivity::class.java))
//            }
        }
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     *
     *
     * Derived classes should call through to the base class for it to
     * perform the default menu handling.
     *
     * @param item The menu item that was selected.
     *
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     *
     * @see .onCreateOptionsMenu
     */
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return item.onNavDestinationSelected(navController)||super.onOptionsItemSelected(item)
//    }

    private fun setUpNavMenus(navController: NavController) {
        boundLayout.mainBottomNavView.setupWithNavController(navController = navController)
        findNavController(R.id.main_nav_host_fragment)
    }

// don't remove the following code, it may be helpful in future that's why it is kept here
//    val intentForNextScreen: Intent
//        get() = if (sharedPreferenceUtil.showIntro())
//            Intent(this, IntroActivity::class.java)
//        else
//            Intent(this, MainActivity::class.java)

}
