package com.example.football.ui.timeline

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.football.databinding.FragmentTimelineBinding
import com.example.football.domain.Position
import com.example.football.ui.BlueTeamPositionViewModel
import com.example.football.ui.RedTeamPositionViewModel
import com.example.football.ui.StateViewModel
import com.example.football.utils.PlayerPositions
import com.example.football.utils.Screens

class TimelineFragment : Fragment() {

    companion object {
        fun newInstance() = TimelineFragment()
    }

    private lateinit var binding: FragmentTimelineBinding
    private lateinit var viewModel: TimelineViewModel
    private val blueTeamPositionViewModel: BlueTeamPositionViewModel by activityViewModels()
    private val redTeamPositionViewModel: RedTeamPositionViewModel by activityViewModels()
    private val stateViewModel: StateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        stateViewModel.loadState(Screens.TIMELINE)
        binding = FragmentTimelineBinding.inflate(inflater, container, false)
        return binding.root
    }

    fun onItemClickRed(view: View, position: Position) {
        Log.d("test", position.type)
        when (position.type) {
            "Random" -> redTeamPositionViewModel.loadState(PlayerPositions.RANDOM)
            "Diffuse" -> redTeamPositionViewModel.loadState(PlayerPositions.DIFFUSE)
            "Pressing" -> redTeamPositionViewModel.loadState(PlayerPositions.PRESSING)
            "Y" -> redTeamPositionViewModel.loadState(PlayerPositions.Y)
            "Holding" -> redTeamPositionViewModel.loadState(PlayerPositions.HOLDING)
            "Attacking" -> redTeamPositionViewModel.loadState(PlayerPositions.ATTACKING)
            "Romb" -> redTeamPositionViewModel.loadState(PlayerPositions.ROMB)
            "Square" -> redTeamPositionViewModel.loadState(PlayerPositions.SQUARE)
            "Defending" -> redTeamPositionViewModel.loadState(PlayerPositions.DEFENDING)
        }
    }

    fun onItemClickBlue(view: View, position: Position) {
        Log.d("test", position.type)
        when (position.type) {
            "Random" -> blueTeamPositionViewModel.loadState(PlayerPositions.RANDOM)
            "Diffuse" -> blueTeamPositionViewModel.loadState(PlayerPositions.DIFFUSE)
            "Pressing" -> blueTeamPositionViewModel.loadState(PlayerPositions.PRESSING)
            "Y" -> blueTeamPositionViewModel.loadState(PlayerPositions.Y)
            "Holding" -> blueTeamPositionViewModel.loadState(PlayerPositions.HOLDING)
            "Attacking" -> blueTeamPositionViewModel.loadState(PlayerPositions.ATTACKING)
            "Romb" -> blueTeamPositionViewModel.loadState(PlayerPositions.ROMB)
            "Square" -> blueTeamPositionViewModel.loadState(PlayerPositions.SQUARE)
            "Defending" -> blueTeamPositionViewModel.loadState(PlayerPositions.DEFENDING)
        }
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
            ), ::onItemClickRed
        )
        binding.rvTopTeam.setOnClickListener {

        }
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
            ), ::onItemClickBlue
        )
        binding.ibtnTopLeftRv.setOnClickListener {
            binding.rvTopTeam.scrollToPosition(topLayoutManager.findFirstVisibleItemPosition() - 1)
        }
        binding.ibtnTopRightRv.setOnClickListener {
            binding.rvTopTeam.getLayoutManager()
                ?.scrollToPosition(topLayoutManager.findLastVisibleItemPosition() + 1)
        }
        binding.ibtnBottomLeftRv.setOnClickListener {
            binding.rvBottomTeam.scrollToPosition(bottomLayoutManager.findFirstVisibleItemPosition() - 1)
        }
        binding.ibtnBottomRightRv.setOnClickListener {
            binding.rvBottomTeam.getLayoutManager()
                ?.scrollToPosition(bottomLayoutManager.findLastVisibleItemPosition() + 1)
        }
        binding.btnTimelineOk.setOnClickListener {
            stateViewModel.loadState(Screens.GAME)
        }
    }
}