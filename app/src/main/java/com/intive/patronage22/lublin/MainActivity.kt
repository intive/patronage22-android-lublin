package com.intive.patronage22.lublin

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.intive.patronage22.lublin.configuration.BuildInfo
import com.intive.patronage22.lublin.databinding.ActivityMainBinding
import com.intive.patronage22.lublin.screens.categories.CategoriesFragment
import com.intive.patronage22.lublin.screens.favorites.FavoritesFragment
import com.intive.patronage22.lublin.screens.home.HomeFragment
import com.intive.patronage22.lublin.screens.search.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val buildInfo = BuildInfo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.AppToolbar)

        val bottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(HomeFragment())
                R.id.search -> setCurrentFragment(SearchFragment())
                R.id.favorites -> setCurrentFragment(FavoritesFragment())
                R.id.categories -> setCurrentFragment(CategoriesFragment())
            }
            true
        }
        bottomNavigationView.selectedItemId = R.id.home
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> Toast.makeText(this, "Settings selected", Toast.LENGTH_SHORT).show()
            R.id.about -> displayAppVersionInfo()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun displayAppVersionInfo() {
        val messageInfo = """
            Version Name (Code): ${buildInfo.versionName} (${buildInfo.versionCode})
            SHA: ${buildInfo.buildSHA}            
        """.trimIndent()

        Snackbar.make(binding.root, messageInfo, Snackbar.LENGTH_INDEFINITE)
            .setAction("Ok") {
                // no-action, just dismiss
            }
            .show()
    }
}