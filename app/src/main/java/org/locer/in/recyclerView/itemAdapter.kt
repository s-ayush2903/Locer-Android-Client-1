package org.locer.`in`.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.locer.`in`.HomeFragment
import org.locer.`in`.R
//This class is the adapter i.e. brain of how recycler view will look
class ItemAdapter(private val context: HomeFragment, private val dataset: List<Affirmation>) :  RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()  {
    //This class is holding all the views that we want to display in a container of recycler view
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView:TextView = view.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ItemViewHolder(
            adapterLayout
        )
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
    }
}