package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import javax.security.auth.login.LoginException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instanciando a Toolbar
        setSupportActionBar(toolbar)

        //Evento de click no navigIcon
        toolbar.setNavigationOnClickListener{
            Log.i("Main Activity", "Clicando no navigation")
        }
    }

    // Incluindo o menu que criamos na toolbar -  Inflate aumenta a exibição

     fun OnCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId
        when(itemView){
            R.id.add_menu -> Log.i("Main Activity", "add")
            R.id.nots_menu -> showSnackbar("notificação em snack")
        }
        return false
    }
    // Criando a snackbar com evento de click nela
    fun showSnackbar(msg: String) {
        var snack = Snackbar.make(snack_layout, msg, Snackbar.LENGTH_SHORT)
        snack.setDuration(10000)

        snack.setAction("clicar", View.OnClickListener {
            Log.i("Main Snackbar", "showSnackbar: ")
        })
        snack.show()
    }
}