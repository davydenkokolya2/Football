package com.example.football.ui.match

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.domain.Match

class MatchAdapter(matchList: ArrayList<Match>) :
    RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    var matchList: List<Match> = matchList
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MatchViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val currentItem = matchList[position]
        holder.date.text = currentItem.date
        holder.nameFirstTeam.text = currentItem.nameFirstTeam
        holder.goalFirstName.text = currentItem.goalFirstTeam.toString()
        holder.nameSecondTeam.text = currentItem.nameSecondTeam
        holder.goalSecondTeam.text = currentItem.goalSecondTeam.toString()

    }

    override fun getItemCount(): Int {
        return matchList.size
    }

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val nameFirstTeam: TextView = itemView.findViewById(R.id.tvFirstTeam)
        val goalFirstName: TextView = itemView.findViewById(R.id.tvGoalFirstTeam)
        val nameSecondTeam: TextView = itemView.findViewById(R.id.tvSecondTeam)
        val goalSecondTeam: TextView = itemView.findViewById(R.id.tvGoalSecondTeam)
    }
}