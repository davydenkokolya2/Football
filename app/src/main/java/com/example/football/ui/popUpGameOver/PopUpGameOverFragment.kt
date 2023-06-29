package com.example.football.ui.popUpGameOver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.football.databinding.FragmentPopUpGameOverBinding
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens

class PopUpGameOverFragment : DialogFragment() {

    companion object {
        fun newInstance() = PopUpGameOverFragment()
    }

    private val stateViewModel: StateViewModel by activityViewModels()
    private lateinit var viewModel: PopUpGameOverViewModel
    private lateinit var binding: FragmentPopUpGameOverBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopUpGameOverBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PopUpGameOverViewModel::class.java)
        binding.btnPopUpOk.setOnClickListener {
            stateViewModel.loadState(Screens.MAINMENU)
            dismiss()
        }
    }

}