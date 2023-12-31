package com.example.football.ui.comparison

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.football.R

class ComparisonFragment : Fragment() {

    companion object {
        fun newInstance() = ComparisonFragment()
    }

    private lateinit var viewModel: ComparisonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_comparison, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComparisonViewModel::class.java)
        // TODO: Use the ViewModel
    }

}