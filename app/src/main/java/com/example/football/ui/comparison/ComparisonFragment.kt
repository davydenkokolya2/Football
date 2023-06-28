package com.example.football.ui.comparison

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentComparisonBinding
import com.example.football.domain.Comparison
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComparisonFragment : Fragment() {

    lateinit var binding: FragmentComparisonBinding
    val stateViewModel: StateViewModel by activityViewModels()
    companion object {
        fun newInstance() = ComparisonFragment()
    }

    private lateinit var viewModel: ComparisonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        stateViewModel.loadState(Screens.COMPARISON)
        binding = FragmentComparisonBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ComparisonViewModel::class.java)

        var layoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvComparison.layoutManager = layoutManager
        binding.rvComparison.adapter = ComparisonAdapter(
            arrayListOf(
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
                Comparison("14.05", "FC Lutie", 0, "FC Megamonster", 0, 5, 2),
            )
        )
    }

}