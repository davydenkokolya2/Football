package com.example.football.ui.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.domain.LastMatches

class LastMatchesAdapter(lastMatchesList: ArrayList<LastMatches>) :
    RecyclerView.Adapter<LastMatchesAdapter.LastMatchesViewHolder>() {

    var lastMatchesList: List<LastMatches> = lastMatchesList
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LastMatchesViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_last_match, parent, false)
        return LastMatchesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LastMatchesViewHolder, position: Int) {
        val currentItem = lastMatchesList[position]
        holder.date.text = currentItem.date
        holder.nameFirstTeam.text = currentItem.nameFirstTeam
        holder.goalFirstName.text = currentItem.goalFirstTeam.toString()
        holder.nameSecondTeam.text = currentItem.nameSecondTeam
        holder.goalSecondTeam.text = currentItem.goalSecondTeam.toString()

    }

    override fun getItemCount(): Int {
        return lastMatchesList.size
    }

    class LastMatchesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val nameFirstTeam: TextView = itemView.findViewById(R.id.tvFirstTeam)
        val goalFirstName: TextView = itemView.findViewById(R.id.tvGoalFirstTeam)
        val nameSecondTeam: TextView = itemView.findViewById(R.id.tvSecondTeam)
        val goalSecondTeam: TextView = itemView.findViewById(R.id.tvGoalSecondTeam)
    }
}