package com.cead.androiddos

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    // -- permisos android  https://developer.android.com/guide/topics/permissions/overview#normal-dangerous y
    // -- ANKO ACTIVITIES
    //-- soporte multilenguaje: en values (folder click derecho) new -> values resource file el archivo lo llamamos strings y en directory name: values-es clave del pais
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast("Hola soy anko toast!!") //toast rapido
        //longToast("hola long")//toast largo

        btnCalcular!!.setOnClickListener{
            val anioNacimiento : Int = editText.text.toString().toInt()
            val anioActual = Calendar.getInstance().get(Calendar.YEAR)
            val miEdad = anioActual- anioNacimiento

            startActivity<DatosUsuario>("edad" to  miEdad)
        }

        btnAlert!!.onClick {
            longToast(getString(R.string.masAlerta))
        }

        btnAlertSimple.onClick{
            alert(getString(R.string.anko_alert), "ALERT"){
                yesButton { longToast(getString(R.string.superSaludo)) }
                noButton { toast(getString(R.string.tristeSaludo)) }
            }.show()
        }

        btnDialog.onClick {
            val paises = listOf("MEX", "ESP", "ARG", "BOL", "COL")
            selector("¿De donde eres?", paises, {dialogInterface, i ->  longToast("GENIAL, ENTONCES VIVES EN ${paises[i]}") })
        }

        btnProgress.onClick {
            val dialog = progressDialog(message = "por favor espera un momento", title = "cargando datos")
        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
       when (item!!.itemId) {
           R.id.menuContactos -> {
                val intentContactos = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"))
                startActivity(intentContactos)
           }
           R.id.menuCompartir -> {
               share("Anko esta genial","anko for android")
           }
           R.id.menuMensaje -> {
               sendSMS("98989865", "Esto es anko sms")
           }
       }
        return super.onOptionsItemSelected(item)
    }


}
