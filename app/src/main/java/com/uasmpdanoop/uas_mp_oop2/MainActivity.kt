package com.uasmpdanoop.uas_mp_oop2


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_santri.setOnClickListener{
            val intent = Intent(this, SantriActivity::class.java)
            startActivity(intent)
        }

        btn_asatid.setOnClickListener{
            val intent = Intent(this, AsatidActivity::class.java)
            startActivity(intent)
        }
    }
}
