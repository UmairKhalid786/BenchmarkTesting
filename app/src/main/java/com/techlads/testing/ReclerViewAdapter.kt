package com.techlads.testing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.techlads.tmdbmobileapi.remote.dto.Movie


class CustomAdapter(private var dataSet: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val iv: ImageView

        init {
            // Define click listener for the ViewHolder's View
            iv = view.findViewById(R.id.iv)
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_rv, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = "Item: $position"
        viewHolder.iv.loadImage(dataSet[position])
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size


    fun updateData(movies: List<Movie>) {
        dataSet = movies.map { it.posterPath }.toTypedArray()
        notifyDataSetChanged()
    }

}

private fun ImageView.loadImage(url: String) {
    Glide.with(this).load("https://image.tmdb.org/t/p/w500$url").into(this)
}

