package com.example.projetofaculdademobile2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button


class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_component)

        val container: LinearLayout = findViewById(R.id.menu_container)

        val inflater = LayoutInflater.from(this)
        val menuView: View = inflater.inflate(R.layout.menu_component, container, true)

        val btnMenu: Button = menuView.findViewById(R.id.btn_menu)
        btnMenu.setOnClickListener {
            // Ação quando o botão do menu for clicado
        }
    }
}

