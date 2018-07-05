package mn.factory.crafftgiraffe.adapter

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import mn.factory.crafftgiraffe.R
import mn.factory.crafftgiraffe.data.model.Category
import mn.factory.crafftgiraffe.ui.results.ResultsActivity
import java.util.*

/**
 * Created by Turkin A. on 05.07.2018.
 */
class CategoriesAdapter
    :
        RecyclerView.Adapter<CategoriesViewHolder>() {

    val items = ArrayList<Category>()

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        when (position) {
            0 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.first))
            1 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.second))
            2 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.third))
            3 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.fourth))
            4 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.fifth))
            5 -> holder.itemView.findViewById<ImageView>(R.id.categoryImage)
                    .setImageDrawable(holder.itemView.resources.getDrawable(R.drawable.sixth))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_category, parent, false) as View
        return CategoriesViewHolder(view)
    }

    override fun getItemCount(): Int = items.size
}

class CategoriesViewHolder(view: View)
    :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (adapterPosition) {
            2 -> v?.context?.startActivity(Intent(v.context, ResultsActivity::class.java))
        }
    }

}