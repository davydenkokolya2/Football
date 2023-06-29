package com.example.football.ui.play

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.football.data.ArrayPlayerPositions
import com.example.football.databinding.FragmentPlayBinding
import com.example.football.ui.BlueTeamPositionViewModel
import com.example.football.ui.RedTeamPositionViewModel
import com.example.football.ui.StateViewModel
import com.example.football.ui.TimeViewModel
import com.example.football.ui.popUpGameOver.PopUpGameOverFragment
import com.example.football.utils.Screens
import kotlinx.coroutines.launch
import kotlin.random.Random

class PlayFragment : Fragment() {

    companion object {
        fun newInstance() = PlayFragment()
    }

    private lateinit var viewModel: PlayViewModel
    private lateinit var binding: FragmentPlayBinding
    private val stateViewModel: StateViewModel by activityViewModels()
    private val timeViewModel: TimeViewModel by activityViewModels()
    private val blueTeamPositionViewModel: BlueTeamPositionViewModel by activityViewModels()
    private val redTeamPositionViewModel: RedTeamPositionViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlayBinding.inflate(inflater, container, false)
        stateViewModel.loadState(Screens.PLAY)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PlayViewModel::class.java)

        val playerPositions = ArrayPlayerPositions()
        val blueNumberPosition = blueTeamPositionViewModel.statePosition.value!!.position
        val redNumberPosition = redTeamPositionViewModel.statePosition.value!!.position
        Log.d("test", blueNumberPosition.toString())
        Log.d("test", redNumberPosition.toString())
        setParams(
            binding.imBluePlayer1,
            playerPositions.listPlayerPositions[blueNumberPosition][1],
            playerPositions.listPlayerPositions[blueNumberPosition][0]
        )
        setParams(
            binding.imBluePlayer2,
            playerPositions.listPlayerPositions[blueNumberPosition][3],
            playerPositions.listPlayerPositions[blueNumberPosition][2]
        )
        setParams(
            binding.imBluePlayer3,
            playerPositions.listPlayerPositions[blueNumberPosition][5],
            playerPositions.listPlayerPositions[blueNumberPosition][4]
        )
        setParams(
            binding.imBluePlayer4,
            playerPositions.listPlayerPositions[blueNumberPosition][7],
            playerPositions.listPlayerPositions[blueNumberPosition][6]
        )
        setParams(
            binding.imRedPlayer1,
            playerPositions.listPlayerPositions[redNumberPosition][1],
            1 - playerPositions.listPlayerPositions[redNumberPosition][0]
        )
        setParams(
            binding.imRedPlayer2,
            playerPositions.listPlayerPositions[redNumberPosition][3],
            1 - playerPositions.listPlayerPositions[redNumberPosition][2]
        )
        setParams(
            binding.imRedPlayer3,
            playerPositions.listPlayerPositions[redNumberPosition][5],
            1 - playerPositions.listPlayerPositions[redNumberPosition][4]
        )
        setParams(
            binding.imRedPlayer4,
            playerPositions.listPlayerPositions[redNumberPosition][7],
            1 - playerPositions.listPlayerPositions[redNumberPosition][6]
        )
        var time: Long = 0
        lifecycleScope.launch {
            timeViewModel.stateTime.collect {
                if (it != null)
                    time = it / 20 * 1000
            }
        }

        object : CountDownTimer(time, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                Log.d("test", time.toString())
                timeViewModel.loadState(time * 20 / 1000 - 20)
                //FragmentActionBarBinding.bind().tvClock.text
                binding.tvScore.text = "${binding.tvScore.text[0].digitToInt() + Random.nextInt(0, 2)}:${binding.tvScore.text[2].digitToInt() + Random.nextInt(0, 2)}"
            }

            override fun onFinish() {
                PopUpGameOverFragment().show(
                    (activity as AppCompatActivity).supportFragmentManager,
                    "showPopUpGameOver"
                )
            }
        }.start()
    }

    fun setParams(image: ImageView, horizontalBias: Float, verticalBIas: Float) {
        val param = image.layoutParams as ConstraintLayout.LayoutParams
        param.horizontalBias = horizontalBias
        param.verticalBias = verticalBIas
    }

}