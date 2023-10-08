package com.techlads.testing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.techlads.testing.ui.compose.gallery.MoviesViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val moviesViewModel by viewModels<MoviesViewModel>()
        val customAdapter = CustomAdapter(emptyArray())

        lifecycleScope.launch {
            moviesViewModel.movies.collect {
                customAdapter.updateData(it)
            }
        }



        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.adapter = customAdapter
    }
}