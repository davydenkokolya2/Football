package com.example.football.ui.comparison

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentComparisonBinding

class ComparisonFragment : Fragment() {

    lateinit var binding: FragmentComparisonBinding

    companion object {
        fun newInstance() = ComparisonFragment()
    }

    private lateinit var viewModel: ComparisonViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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