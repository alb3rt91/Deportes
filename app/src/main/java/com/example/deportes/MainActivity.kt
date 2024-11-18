package com.example.deportes

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var sportsAdapter: SportAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Configurar Toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerView)
        fab = findViewById(R.id.fab)

        val sportsList = listOf(
            Sport("Baloncesto", R.drawable.baloncesto),
            Sport("Béisbol", R.drawable.beisbol),
            Sport("Ciclismo", R.drawable.ciclismo),
            Sport("Fútbol", R.drawable.futbol),
            Sport("Golf", R.drawable.golf),
            Sport("Hípica", R.drawable.hipica),
            Sport("Natación", R.drawable.natacion),
            Sport("Pingpong", R.drawable.pinpon),
            Sport("Tenis", R.drawable.tenis)
        )

        sportsAdapter = SportAdapter(sportsList) {
            // No action needed for now on checkbox change
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = sportsAdapter

        fab.setOnClickListener {
            val selectedSports = sportsList.filter { it.isSelected }.joinToString(", ") { it.name }
            val message = if (selectedSports.isEmpty()) {
                "No has elegido ninguna opción"
            } else {
                "Has elegido: $selectedSports"
            }
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }

    // Inflar el menú en la Toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // Manejar clics en el menú (por ahora solo muestra Toasts)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                Toast.makeText(this, "Buscar seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_add -> {
                Toast.makeText(this, "Agregar seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_more -> {
                Toast.makeText(this, "Más opciones seleccionado", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
