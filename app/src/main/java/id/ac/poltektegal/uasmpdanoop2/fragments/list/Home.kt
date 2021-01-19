package id.ac.poltektegal.uasmpdanoop2.fragments.list

import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import id.ac.poltektegal.uasmpdanoop2.R

class Home : AppCompatActivity(),  View.OnClickListener {
    private lateinit var btnAzam : Button
    private lateinit var btnWiwin : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_azam)

        btnAzam = findViewById(R.id.btn_azam)

        btnAzam.setOnClickListener(this)
    }

    override fun onClick(v: View){
        when(v.id){
            R.id.btn_azam -> run {
                val ListFragment = Intent(this@Home, ListFragment::class.java)
                startActivity(ListFragment)
            }
        }
    }
}