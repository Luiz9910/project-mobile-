package com.example.projetofaculdademobile2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projetofaculdademobile2.databinding.ActivityFeedBinding

class Feed : AppCompatActivity() {
    private lateinit var binding: ActivityFeedBinding
    private lateinit var persons: ArrayList<Person>
    private lateinit var adapter: PersonRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpList()
    }

    private fun setUpList() {
        persons = createInitialDataSet()
        adapter = PersonRecyclerViewAdapter(
            persons
        )
        val gridLayoutManager = GridLayoutManager(
            this,
            1
        )
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int = 1
        }
        binding.listViewPersons.layoutManager = gridLayoutManager
        binding.listViewPersons.adapter = adapter
    }

    private fun createInitialDataSet(): ArrayList<Person> = arrayListOf(
        Person("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Athletes", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif"),
        Person("Community", "2fjsdnfisdnfionsdiofndsiofnsdifisdonfiosdhnfiosdhfisdmifmsdifmsdif")
    )

    data class PersonOrError(
        val error: Boolean,
        val person: Person
    )
}