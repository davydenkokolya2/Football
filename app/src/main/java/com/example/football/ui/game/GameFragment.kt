package com.example.football.ui.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.football.R
import com.example.football.databinding.FragmentGameBinding
import com.example.football.ui.StateViewModel
import com.example.football.ui.TimeViewModel
import com.example.football.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }

    private val stateViewModel: StateViewModel by activityViewModels()
    private lateinit var binding: FragmentGameBinding
    private val timeViewModel: TimeViewModel by activityViewModels()
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        stateViewModel.loadState(screens = Screens.GAME)
        binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)

        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
            Log.d(
                "test",
                group.indexOfChild(group.findViewById(group.checkedRadioButtonId)).toString()
            )
            when (group.indexOfChild(group.findViewById(group.checkedRadioButtonId))) {
                0 -> timeViewModel.loadState(60)
                1 -> timeViewModel.loadState(90)
                2 -> timeViewModel.loadState(120)
            }
        }
        binding.btnTimeline.setOnClickListener {
            stateViewModel.loadState(Screens.TIMELINE)
        }
        binding.btnPlay.setOnClickListener {
            stateViewModel.loadState(Screens.PLAY)
        }
        lifecycleScope.launch {
            timeViewModel.stateTime.collect {
                if (it != null)
                    when (it) {
                        60L -> binding.radioButton2.isChecked = true
                        90L -> binding.radioButton7.isChecked = true
                        120L -> binding.radioButton8.isChecked = true
                    }
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = this.requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

}