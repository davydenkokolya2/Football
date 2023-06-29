package com.example.football.ui.action_bar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.football.ui.popUpPause.PopUpPauseFragment
import com.example.football.databinding.FragmentActionBarBinding
import com.example.football.ui.StateViewModel
import com.example.football.ui.TimeViewModel
import com.example.football.utils.Screens
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ActionBarFragment : Fragment() {

    companion object {
        fun newInstance() = ActionBarFragment()
    }

    private lateinit var binding: FragmentActionBarBinding
    private val viewModel: StateViewModel by activityViewModels()
    private val timeViewModel: TimeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentActionBarBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnBack.setOnClickListener {
            viewModel.loadState(Screens.MAINMENU)
        }
        binding.btnPause.setOnClickListener {
            PopUpPauseFragment().show(
                (activity as AppCompatActivity).supportFragmentManager,
                "showPopUp"
            )
        }
        lifecycleScope.launch {
            viewModel.stateScreen.collect {
                binding.btnBack.isInvisible = it == Screens.MAINMENU
                binding.textView3.text = it.toString()
                binding.tvClock.isInvisible = it != Screens.PLAY
                binding.btnPause.isInvisible = it != Screens.PLAY
                binding.imageView16.isInvisible = it != Screens.PLAY
            }
        }
        lifecycleScope.launch {
            timeViewModel.stateTime.collect {
                val time = it
                if (time != null) {
                    if (time % 60 < 10)
                        binding.tvClock.text = "${time / 60}:0${time % 60}"
                    else
                        binding.tvClock.text = "${time / 60}:${time % 60}"
                }
            }
        }
    }
}
