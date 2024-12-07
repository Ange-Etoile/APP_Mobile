package com.example.formulaire

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nom = findViewById<EditText>(R.id.editnom)
        val prenom = findViewById<EditText>(R.id.editprenom)
        val sexe = findViewById<RadioGroup>(R.id.radiogrp)
        val nationalite = findViewById<Spinner>(R.id.spinner)
        val loisirsport =findViewById<CheckBox>(R.id.checksport)
        val loisirlec = findViewById<CheckBox>(R.id.checklec)
        val butonsave = findViewById<Button>(R.id.butonsave)
        val comment = findViewById<EditText>(R.id.editcom)
        val array_loisir: ArrayList<String> = arrayListOf<String>()
        butonsave.setOnClickListener{
            val getnom = nom.text.toString()
            val getprenom = prenom.text.toString()
            val sexeselected = findViewById<Button>(sexe.checkedRadioButtonId).text.toString()
            val getnationalite = nationalite.selectedItem.toString()
            val getComment = comment.text.toString()
            if(loisirlec.isChecked){
                array_loisir.add(loisirlec.text.toString())
            }
            if(loisirsport.isChecked){
                array_loisir.add(loisirsport.text.toString())
            }
            val startsecond = Intent(this,MainActivity2::class.java)
            startsecond.putExtra("extra_nom", getnom)
            startsecond.putExtra("extra_prenom",getprenom)
            startsecond.putExtra("extra_sexe", sexeselected)
            startsecond.putExtra("extra_nationality", getnationalite)
            startsecond.putStringArrayListExtra("array_loisirs",array_loisir)
            startsecond.putExtra("extra_comment", getComment)
            startActivity(startsecond)


        }
    }
}