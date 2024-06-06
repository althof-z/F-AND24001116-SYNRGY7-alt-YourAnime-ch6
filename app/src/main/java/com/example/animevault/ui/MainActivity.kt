package com.example.animevault.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.animevault.R
import com.example.animevault.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(viewBinding.root)
        setupNavigationComponentWithAppBar()



    }

    private fun setupNavigationComponentWithAppBar() {
       val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment? ?: return
       setupActionBarWithNavController(host.navController)
   }

    override fun onSupportNavigateUp(): Boolean {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment
        return host.navController.navigateUp() || super.onSupportNavigateUp()
    }


}