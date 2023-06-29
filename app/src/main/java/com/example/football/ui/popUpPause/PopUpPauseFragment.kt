package com.example.football.ui.popUpPause

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.football.databinding.FragmentPopUpPauseBinding
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens

class PopUpPauseFragment : DialogFragment() {

    companion object {
        fun newInstance() = PopUpPauseFragment()
    }

    private lateinit var viewModel: PopUpPauseViewModel
    val stateViewModel: StateViewModel by activityViewModels()
    private lateinit var binding: FragmentPopUpPauseBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopUpPauseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.btnPopUpExit.setOnClickListener {
            stateViewModel.loadState(Screens.MAINMENU)
            dismiss()
        }
        binding.btnPopUpBackToGame.setOnClickListener {
            dismiss()
        }
        viewModel = ViewModelProvider(this).get(PopUpPauseViewModel::class.java)
        // TODO: Use the ViewModel
    }

}