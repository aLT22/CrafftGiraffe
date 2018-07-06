package mn.factory.crafftgiraffe.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.data.model.Master
import mn.factory.crafftgiraffe.ui.master.MasterActivity
import mn.factory.crafftgiraffe.utils.ext.setRegularFont
import java.util.*

/**
 * Created by Turkin A. on 05.07.2018.
 */
class MastersAdapter
    :
        RecyclerView.Adapter<MastersViewHolder>() {

    val items = ArrayList<Master>()

    override fun onBindViewHolder(holder: MastersViewHolder, position: Int) {
        when (position) {
            0 -> {
                holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                        .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person1))
            }
            1 -> {
                holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                        .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person2))
            }
            2 -> {
                holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                        .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person3))
            }
            3 -> {
                holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                        .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person4))
            }
            4 -> {
                holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                        .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person5))
            }
            5 -> holder.itemView.findViewById<ImageView>(R.id.masterAvatar)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.person6))
        }

        holder.itemView.findViewById<TextView>(R.id.masterName).apply {
            text = items[position].name
            setRegularFont(holder.itemView.context)
        }

        holder.itemView.findViewById<RatingBar>(R.id.masterRating)
                .rating = items[position].mark.toFloat()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MastersViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_master, parent, false) as View
        return MastersViewHolder(view)
    }

    override fun getItemCount(): Int = items.size
}

class MastersViewHolder(view: View)
    :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (adapterPosition) {
            0 -> {
                val intent = Intent(v?.context, MasterActivity::class.java)
                intent.putExtra(MasterActivity.KEY_EMAIL, "varnavskaya@factory.mn")

                v?.context?.startActivity(intent)
            }
        }
    }

}