package com.example.football.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.football.R
import com.example.football.databinding.FragmentGameBinding
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameFragment : Fragment() {

    companion object {
        fun newInstance() = GameFragment()
    }
    private val stateViewModel: StateViewModel by activityViewModels()
    private lateinit var binding: FragmentGameBinding
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

        binding.btnTimeline.setOnClickListener {
            stateViewModel.loadState(Screens.TIMELINE)
        }
        binding.btnPlay.setOnClickListener {
            stateViewModel.loadState(Screens.PLAY)
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = this.requireActivity().supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()
    }

}