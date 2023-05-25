
package com.example.words

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.words.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val letterId = intent?.extras?.getString("letter").toString()

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letterId, this)

        // Adds a [DividerItemDecoration] between items
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        title = getString(R.string.detail_prefix) + " " + letterId
    }
    companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
}