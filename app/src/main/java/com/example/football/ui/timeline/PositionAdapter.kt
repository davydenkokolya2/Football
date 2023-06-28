package com.example.football.ui.timeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.recyclerview.widget.RecyclerView
import com.example.football.R
import com.example.football.domain.Position

class PositionAdapter(matchList: ArrayList<Position>) :
    RecyclerView.Adapter<PositionAdapter.PositionViewHolder>() {

    var positionList: List<Position> = matchList
        set(value) {
            field = value
        }
    private var lastSelectedPosition = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PositionViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_timeline, parent, false)
        return PositionViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PositionViewHolder, position: Int) {
        val currentItem = positionList[position]
        holder.type.text = currentItem.type
        holder.type.setOnClickListener {
            lastSelectedPosition = holder.adapterPosition
            notifyDataSetChanged()
        }
        holder.type.isChecked = lastSelectedPosition == position
    }

    override fun getItemCount(): Int {
        return positionList.size
    }

    class PositionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val type: RadioButton = itemView.findViewById(R.id.rbTimeline)
    }
}