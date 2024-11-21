package com.example.paginafinalpmm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val usuarioValido = "admin"
        val passwordValida = "1111"

        val miBoton = findViewById<Button>(R.id.button)
        val usuarioRecuperado = findViewById<EditText>(R.id.editTextTextUser)
        val passwordRecuperada = findViewById<EditText>(R.id.editTextTextPassword)

        miBoton.setOnClickListener{
            val usuario = usuarioRecuperado.text.toString()
            val password = passwordRecuperada.text.toString()

            if(usuario == usuarioValido && password  == passwordValida ){
                val intent = Intent(this,Greeting::class.java)
                intent.putExtra("USER_NAME", usuario)
                startActivity(intent)
            }else if(usuario.isEmpty() || password.isEmpty()){
                    showAlert("Introduce algún valor")
            }else if(usuario != usuarioValido || password != passwordValida ){
                showAlert("Usuario o contraseña incorrectos")
            }
        }

    }
    private fun showAlert(mensaje : String ){
        var builder = AlertDialog.Builder(this)
        builder.setTitle("Credenciales incorrectas")
        builder.setMessage(mensaje)
        builder.setPositiveButton("Aceptar"){dialog,_-> dialog.dismiss()}
        builder.setNegativeButton("Cancelar"){dialog,_-> dialog.dismiss()}

        val dialog = builder.create()
        dialog.show()

    }
}