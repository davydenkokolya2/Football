package com.example.football.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.football.R
import com.example.football.databinding.ActivityMainBinding
import com.example.football.ui.comparison.ComparisonFragment
import com.example.football.ui.game.GameFragment
import com.example.football.ui.guide.GuideFragment
import com.example.football.ui.mainmenu.MainMenuFragment
import com.example.football.ui.match.MatchFragment
import com.example.football.ui.play.PlayFragment
import com.example.football.ui.setting.SettingFragment
import com.example.football.ui.timeline.TimelineFragment
import com.example.football.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val stateViewModel: StateViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        replaceFragment(MainMenuFragment())
        lifecycleScope.launch {
            stateViewModel.stateScreen.collect {
                when (it) {
                    Screens.SETTING -> replaceFragment(SettingFragment())
                    Screens.MAINMENU -> replaceFragment(MainMenuFragment())
                    Screens.MATCH -> replaceFragment(MatchFragment())
                    Screens.TIMELINE -> replaceFragment(TimelineFragment())
                    Screens.PLAY -> replaceFragment(PlayFragment())
                    Screens.GAME -> replaceFragment(GameFragment())
                    Screens.COMPARISON -> replaceFragment(ComparisonFragment())
                    Screens.GUIDE -> replaceFragment(GuideFragment())
                    else -> {}
                }
            }
        }

        //viewModel.stateScreen
        binding.bottomNavigationView.setOnItemSelectedListener {
            //checkableBottomNavigationView()
            when (it.itemId) {
                R.id.navigation_comparison -> stateViewModel.loadState(Screens.COMPARISON)
                R.id.navigation_game -> stateViewModel.loadState(Screens.GAME)
                R.id.navigation_guide -> stateViewModel.loadState(Screens.GUIDE)
                R.id.navigation_match -> stateViewModel.loadState(Screens.MATCH)
                R.id.navigation_setting -> stateViewModel.loadState(Screens.SETTING)
                else -> {
                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }
}