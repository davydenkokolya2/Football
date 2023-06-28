package com.example.football.ui.match

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentMatchBinding

class MatchFragment : Fragment() {


    companion object {
        fun newInstance() = MatchFragment()
    }

    lateinit var binding: FragmentMatchBinding
    private lateinit var viewModel: MatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMatchBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MatchViewModel::class.java)

        var layoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvMatch.layoutManager = layoutManager
        binding.rvMatch.adapter =
            MatchAdapter(
                arrayListOf(
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    Match("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                )
            )
    }

}