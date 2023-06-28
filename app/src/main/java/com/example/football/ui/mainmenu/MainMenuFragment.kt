package com.example.football.ui.mainmenu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentMainMenuBinding

class MainMenuFragment : Fragment() {

    companion object {
        fun newInstance() = MainMenuFragment()
    }

    private lateinit var viewModel: MainMenuViewModel
    lateinit var binding: FragmentMainMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainMenuViewModel::class.java)

        var layoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.VERTICAL, false)

        binding.rvLastMatches.layoutManager = layoutManager
        binding.rvLastMatches.adapter =
            LastMatchesAdapter(
                arrayListOf(
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                    LastMatches("14.05", "FC Lutie", 5, "FC Megamonster", 2),
                )
            )
    }
}