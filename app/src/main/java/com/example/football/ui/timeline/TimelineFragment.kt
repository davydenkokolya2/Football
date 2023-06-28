package com.example.football.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentTimelineBinding
import com.example.football.domain.Position
import com.example.football.ui.StateViewModel
import com.example.football.utils.Screens

class TimelineFragment : Fragment() {

    companion object {
        fun newInstance() = TimelineFragment()
    }

    private lateinit var binding: FragmentTimelineBinding
    private lateinit var viewModel: TimelineViewModel
    private val stateViewModel: StateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        stateViewModel.loadState(Screens.TIMELINE)
        binding = FragmentTimelineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TimelineViewModel::class.java)

        val topLayoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)

        binding.rvTopTeam.layoutManager = topLayoutManager
        binding.rvTopTeam.adapter = PositionAdapter(
            arrayListOf(
                Position(""),
                Position("Random"),
                Position("Diffuse"),
                Position("Pressing"),
                Position("Y"),
                Position("Holding"),
                Position("Attacking"),
                Position("Romb"),
                Position("Square"),
                Position("Defending"),
                Position(""),
            )
        )
        val bottomLayoutManager =
            LinearLayoutManager(this.requireActivity(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvBottomTeam.layoutManager = bottomLayoutManager
        binding.rvBottomTeam.adapter = PositionAdapter(
            arrayListOf(
                Position(""),
                Position("Random"),
                Position("Diffuse"),
                Position("Pressing"),
                Position("Y"),
                Position("Holding"),
                Position("Attacking"),
                Position("Romb"),
                Position("Square"),
                Position("Defending"),
                Position(""),
            )
        )
        binding.ibtnTopLeftRv.setOnClickListener {
            binding.rvTopTeam.scrollToPosition(topLayoutManager.findFirstVisibleItemPosition() - 1);
        }
        binding.ibtnTopRightRv.setOnClickListener {
            binding.rvTopTeam.getLayoutManager()?.scrollToPosition(topLayoutManager.findLastVisibleItemPosition() + 1);
        }
        binding.ibtnBottomLeftRv.setOnClickListener {
            binding.rvBottomTeam.scrollToPosition(bottomLayoutManager.findFirstVisibleItemPosition() - 1);
        }
        binding.ibtnBottomRightRv.setOnClickListener {
            binding.rvBottomTeam.getLayoutManager()?.scrollToPosition(bottomLayoutManager.findLastVisibleItemPosition() + 1);
        }
    }

}