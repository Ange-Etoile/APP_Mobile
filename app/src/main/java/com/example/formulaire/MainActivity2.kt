package com.example.formulaire

import android.os.Bundle
import android.widget.Adapter
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nom = findViewById<EditText>(R.id.getnom)
        val prenom = findViewById<EditText>(R.id.getprenom)
        val sexe = findViewById<EditText>(R.id.getsexe)
        val comment = findViewById<EditText>(R.id.editcom)
        val nationalite = findViewById<EditText>(R.id.getnationalite)
        val loisir = findViewById<ListView>(R.id.getloisirs)
        val button = findViewById<Button>(R.id.retour)
        val loisirs = intent.getStringArrayListExtra("array_loisirs")
        nom.setText(intent.getStringExtra("extra_nom"))
        prenom.setText(intent.getStringExtra("extra_prenom"))
        sexe.setText(intent.getStringExtra("extra_sexe"))
        comment.setText(intent.getStringExtra("extra_comment"))
        nationalite.setText(intent.getStringExtra("extra_nationality"))
        if(loisirs != null){
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,loisirs)
            loisir.adapter = adapter
        }
        button.setOnClickListener{
            finish()
        }
    }
}