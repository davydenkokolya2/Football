package com.example.football.ui.comparison

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.domain.Comparison

class ComparisonAdapter(comparisonList: ArrayList<Comparison>) :
    RecyclerView.Adapter<ComparisonAdapter.ComparisonViewHolder>() {

    var comparisonList: List<Comparison> = comparisonList
        set(value) {
            field = value
        }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ComparisonViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_comparison, parent, false)
        return ComparisonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ComparisonViewHolder, position: Int) {
        val currentItem = comparisonList[position]
        holder.date.text = currentItem.date
        holder.nameFirstTeam.text = currentItem.nameFirstTeam
        holder.goalFirstName.text = currentItem.goalFirstTeam.toString()
        holder.nameSecondTeam.text = currentItem.nameSecondTeam
        holder.goalSecondTeam.text = currentItem.goalSecondTeam.toString()
        holder.scoreBlueTeam.text = currentItem.scoreBlueTeam.toString()
        holder.scoreRedTeam.text = currentItem.scoreRedTeam.toString()
    }

    override fun getItemCount(): Int {
        return comparisonList.size
    }

    class ComparisonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date: TextView = itemView.findViewById(R.id.tvDate)
        val nameFirstTeam: TextView = itemView.findViewById(R.id.tvFirstTeam)
        val goalFirstName: TextView = itemView.findViewById(R.id.tvGoalFirstTeam)
        val nameSecondTeam: TextView = itemView.findViewById(R.id.tvSecondTeam)
        val goalSecondTeam: TextView = itemView.findViewById(R.id.tvGoalSecondTeam)
        val scoreBlueTeam: TextView = itemView.findViewById(R.id.tvBlueScore)
        val scoreRedTeam: TextView = itemView.findViewById(R.id.tvRedScore)
    }
}