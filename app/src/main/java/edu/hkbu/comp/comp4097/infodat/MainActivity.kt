package edu.hkbu.comp.comp4097.infodat

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import edu.hkbu.comp.comp4097.infodat.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    fun buttonClick(view : View) {
        findNavController(R.id.nav_host_fragment_activity_main)
            .navigate(R.id.action_navigation_home_to_infoFragment)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        val appBarConfiguration = AppBarConfiguration(setOf(
//            R.id.navigation_home, R.id.navigation_dashboard,
//            R.id.navigation_notifications, R.id.mapsFragment))

        findNavController(R.id.nav_host_fragment_activity_main).popBackStack()
        return true
    }


    override fun onResume() {
        super.onResume()
        //The SwitchPreferenceCompat will automatically store
        //the preference value in a key-value dictionary.
        if (getSharedPreferences("${packageName}_preferences", 0)
                .getBoolean("dark_mode", false)) {
            //switch to night mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            //switch to day mode
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}