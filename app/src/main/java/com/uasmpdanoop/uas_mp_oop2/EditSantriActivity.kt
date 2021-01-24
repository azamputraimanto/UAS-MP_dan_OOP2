package com.uasmpdanoop.uas_mp_oop2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import com.uasmpdanoop.uas_mp_oop2.Database.AppRoomDB
import com.uasmpdanoop.uas_mp_oop2.Database.Constant
import com.uasmpdanoop.uas_mp_oop2.Database.Santri
import kotlinx.android.synthetic.main.activity_edit_santri.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditSantriActivity : AppCompatActivity() {

    private val mFirebaseAnalytics: FirebaseAnalytics? = null
    var database = FirebaseDatabase.getInstance()

    val db by lazy { AppRoomDB(this) }
    private var santriId: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_santri)
        setupListener()
        setupView()

        var mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

    }

    fun setupListener(){
        btn_saveSantri.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.santriDao().addSantri(
                    Santri(0, Integer.parseInt(txt_nomer_induk.text.toString()), txt_nama.text.toString(), txt_kelas.text.toString(), Integer.parseInt(txt_tahun_masuk.text.toString()), txt_alamat.text.toString() )
                )
                finish()
            }
        }
        btn_updateSantri.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.santriDao().updateSantri(
                    Santri(santriId, Integer.parseInt(txt_nomer_induk.text.toString()), txt_nama.text.toString(), txt_kelas.text.toString(), Integer.parseInt(txt_tahun_masuk.text.toString()), txt_alamat.text.toString() )
                )
                finish()
            }
        }
    }

    fun setupView() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        val intentType = intent.getIntExtra("intent_type", 0)
        when (intentType) {
            Constant.TYPE_CREATE -> {
                btn_updateSantri.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_saveSantri.visibility = View.GONE
                btn_updateSantri.visibility = View.GONE
                getSantri()
            }
            Constant.TYPE_UPDATE -> {
                btn_saveSantri.visibility = View.GONE
                getSantri()
            }
        }
    }

    fun getSantri() {
        santriId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val santris =  db.santriDao().getSantri( santriId )[0]
            txt_nomer_induk.setText( santris.nomer_induk.toString() )
            txt_nama.setText( santris.nama )
            txt_kelas.setText( santris.kelas )
            txt_tahun_masuk.setText( santris.tahun_masuk.toString() )
            txt_alamat.setText( santris.alamat )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}

