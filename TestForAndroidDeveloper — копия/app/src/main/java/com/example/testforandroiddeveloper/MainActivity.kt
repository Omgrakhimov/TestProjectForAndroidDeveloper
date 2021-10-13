package com.example.testforandroiddeveloper



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.fragment.app.Fragment
import com.example.testforandroiddeveloper.fragments.listStrategiesFragment.ListStrategiesFragment
import com.example.testforandroiddeveloper.fragments.listFavoriteFragment.FavoritListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private val listStrategiesFragment = ListStrategiesFragment()
    private val listFavoritesFragment = FavoritListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(listStrategiesFragment)
        var bn_menu = findViewById<BottomNavigationView>(R.id.bn_menu)

        bn_menu.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_favorites -> replaceFragment(listFavoritesFragment)
                R.id.ic_list -> replaceFragment(listStrategiesFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.container, fragment)
            transaction.commit()
        }
    }
}
