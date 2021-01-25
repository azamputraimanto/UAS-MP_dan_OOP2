package com.uasmpdanoop.uas_mp_oop2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.uasmpdanoop.uas_mp_oop2.Database.AppRoomDB
import com.uasmpdanoop.uas_mp_oop2.Database.Constant
import com.uasmpdanoop.uas_mp_oop2.Database.Asatid
import kotlinx.android.synthetic.main.activity_asatid.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AsatidActivity : AppCompatActivity() {

    val db by lazy { AppRoomDB(this) }
    lateinit var asatidAdapter: AsatidAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asatid)
        setupListener()
        setupRecyclerView()
    }

    override fun onStart() {
        super.onStart()
        loadAsatid()
    }

    fun loadAsatid() {
        CoroutineScope(Dispatchers.IO).launch {
            val allAsatid = db.asatidDao().getAllAsatid()
            Log.d("AsatidActivity", "dbResponse: $allAsatid")
            withContext(Dispatchers.Main) {
                asatidAdapter.setData(allAsatid)
            }
        }
    }

    fun setupListener() {
        btn_createAsatid.setOnClickListener {
            intentEdit(0, Constant.TYPE_CREATE)
        }
    }

    fun setupRecyclerView() {
        asatidAdapter = AsatidAdapter(arrayListOf(), object: AsatidAdapter.OnAdapterListener {
            override fun onClick(asatid: Asatid) {
                // read detail
                intentEdit(asatid.id, Constant.TYPE_READ)
            }
            override fun onDelete(asatid: Asatid) {
                // delete data
                deleteDialog(asatid)
            }
            override fun onUpdate(asatid: Asatid) {
                // edit data
                intentEdit(asatid.id, Constant.TYPE_UPDATE)
            }

        })
        list_asatid.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = asatidAdapter
        }
    }

    fun intentEdit(asatidId: Int, intentType: Int ) {
        startActivity(
            Intent(applicationContext, EditAsatidActivity::class.java)
                .putExtra("intent_id", asatidId)
                .putExtra("intent_type", intentType)
        )
    }

    private fun deleteDialog(asatid: Asatid) {
        val alertDialog = AlertDialog.Builder(this)
        alertDialog.apply {
            setTitle("Konfirmasi")
            setMessage("Yakin ingin menghapus data ini?")
            setNegativeButton("Batal") { dialogInterface, i ->
                dialogInterface.dismiss()
            }
            setPositiveButton("Hapus") { dialogInterface, i ->
                dialogInterface.dismiss()
                CoroutineScope(Dispatchers.IO).launch {
                    db.asatidDao().deleteAsatid(asatid)
                    loadAsatid()
                }
            }
        }
        alertDialog.show()
    }

}
