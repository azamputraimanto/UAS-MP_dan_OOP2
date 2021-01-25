package com.uasmpdanoop.uas_mp_oop2

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.database.FirebaseDatabase
import com.uasmpdanoop.uas_mp_oop2.Database.AppRoomDB
import com.uasmpdanoop.uas_mp_oop2.Database.Asatid
import com.uasmpdanoop.uas_mp_oop2.Database.Constant
import kotlinx.android.synthetic.main.activity_edit_asatid.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class EditAsatidActivity : AppCompatActivity() {

    private val mFirebaseAnalytics: FirebaseAnalytics? = null

    val db by lazy { AppRoomDB(this) }
    private var asatidId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_asatid)
        setupListener()
        setupView()

        var mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        val database = FirebaseDatabase.getInstance()
    }

    fun setupListener(){
        btn_saveAsatid.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.asatidDao().addAsatid(
                    Asatid(0, Integer.parseInt(txt_kode_asatid.text.toString()), txt_name.text.toString(), txt_alumni.text.toString(), Integer.parseInt(txt_tahun_lulus.text.toString()))
                )
                finish()
            }
        }
        btn_updateAsatid.setOnClickListener{
            CoroutineScope(Dispatchers.IO).launch {
                db.asatidDao().updateAsatid(
                    Asatid(asatidId, Integer.parseInt(txt_kode_asatid.text.toString()), txt_name.text.toString(), txt_alumni.text.toString(), Integer.parseInt(txt_tahun_lulus.text.toString()))
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
                btn_updateAsatid.visibility = View.GONE
            }
            Constant.TYPE_READ -> {
                btn_saveAsatid.visibility = View.GONE
                btn_updateAsatid.visibility = View.GONE
                getAsatid()
            }
            Constant.TYPE_UPDATE -> {
                btn_saveAsatid.visibility = View.GONE
                getAsatid()
            }
        }
    }

    fun getAsatid() {
        asatidId = intent.getIntExtra("intent_id", 0)
        CoroutineScope(Dispatchers.IO).launch {
            val asatids =  db.asatidDao().getAsatid( asatidId )[0]
            txt_kode_asatid.setText( asatids.kode_asatid.toString() )
            txt_name.setText(asatids.name)
            txt_alumni.setText(asatids.alumni)
            txt_tahun_lulus.setText( asatids.tahun_lulus.toString() )
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}