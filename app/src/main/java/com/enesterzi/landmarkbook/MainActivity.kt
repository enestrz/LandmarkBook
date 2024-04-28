package com.enesterzi.landmarkbook

import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.enesterzi.landmarkbook.databinding.ActivityMainBinding

//var chosenLandmark: Landmark? = null // Güvensiz

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList: ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        landmarkList = ArrayList()

        val pisa = Landmark("Pisa", "Italy", R.drawable.pisa_kulesi)
        val colessium = Landmark("Colessium", "Italy", R.drawable.collesium)
        val eiffel = Landmark("Eiffel", "France", R.drawable.eiffel)
        val londonBridge = Landmark("London Bridge", "UK", R.drawable.london_tower_bridge)
        
        landmarkList.add(pisa)
        landmarkList.add(colessium)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter

        // Adapter : Layout & Data

        // Basit ama kullanılmayan
        // mapping
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, landmarkList.map { it.name  })
//
//        binding.listView.adapter = adapter
//
//        binding.listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
//            val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//            intent.putExtra("landmark", landmarkList.get(position))
//            startActivity(intent)
//        }
    }
}