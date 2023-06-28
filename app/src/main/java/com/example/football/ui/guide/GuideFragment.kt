package com.example.football.ui.guide

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.football.R
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens

class GuideFragment : Fragment() {

    companion object {
        fun newInstance() = GuideFragment()
    }

    private val stateViewModel: StateViewModel by activityViewModels()
    private lateinit var viewModel: GuideViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        stateViewModel.loadState(Screens.GUIDE)
        return inflater.inflate(R.layout.fragment_guide, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GuideViewModel::class.java)
        // TODO: Use the ViewModel
    }

}