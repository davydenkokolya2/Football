package com.example.football.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.football.R
import com.example.football.databinding.ActivityMainBinding
import com.example.football.ui.comparison.ComparisonFragment
import com.example.football.ui.game.GameFragment
import com.example.football.ui.guide.GuideFragment
import com.example.football.ui.mainmenu.MainMenuFragment
import com.example.football.ui.match.MatchFragment
import com.example.football.ui.setting.SettingFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        replaceFragment(MainMenuFragment())
        //binding.bottomNavigationView.menu.forEach { it.isChecked = false }
        uncheckableBottomNavigationView()
        binding.bottomNavigationView.setOnItemSelectedListener {
            checkableBottomNavigationView()
            when (it.itemId) {
                R.id.navigation_comparison -> replaceFragment(ComparisonFragment())
                R.id.navigation_game -> replaceFragment(GameFragment())
                R.id.navigation_guide -> replaceFragment(GuideFragment())
                R.id.navigation_match -> replaceFragment(MatchFragment())
                R.id.navigation_setting -> replaceFragment(SettingFragment())
                else -> {
                }
            }
            true
        }
    }

    private fun uncheckableBottomNavigationView() {
        binding.bottomNavigationView.menu.setGroupCheckable(0, false, false)
    }

    private fun checkableBottomNavigationView() {
        binding.bottomNavigationView.menu.setGroupCheckable(0, true, true)
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}