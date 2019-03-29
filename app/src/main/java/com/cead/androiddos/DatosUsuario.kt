package com.cead.androiddos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos_usuario.*

class DatosUsuario : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_usuario)

        val bundle = intent.extras

        val edad = bundle.getInt("edad")
        txtEdad.text = edad.toString()
    }
}
