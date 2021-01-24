package com.uasmpdanoop.uas_mp_oop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uasmpdanoop.uas_mp_oop2.Database.Santri
import kotlinx.android.synthetic.main.adapter_santri.view.*

class SantriAdapter (private val AllSantri: ArrayList<Santri>, private val listener: OnAdapterListener) : RecyclerView.Adapter<SantriAdapter.SantriViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SantriViewHolder {
        return SantriViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_santri, parent, false)
        )
    }

    override fun getItemCount() = AllSantri.size

    override fun onBindViewHolder(holder: SantriViewHolder, position: Int) {
        val santri = AllSantri[position]
        holder.view.text_nomer_induk.text = santri.nomer_induk.toString()
        holder.view.text_nama.text = santri.nama
        holder.view.text_kelas.text = santri.kelas
        holder.view.text_tahun_masuk.text = santri.tahun_masuk.toString()
        holder.view.text_alamat.text = santri.alamat

        holder.view.text_nomer_induk.setOnClickListener {
            listener.onClick(santri)
        }

        holder.view.text_nama.setOnClickListener {
            listener.onClick(santri)
        }

        holder.view.text_kelas.setOnClickListener {
            listener.onClick(santri)
        }

        holder.view.text_tahun_masuk.setOnClickListener {
            listener.onClick(santri)
        }

        holder.view.text_alamat.setOnClickListener {
            listener.onClick(santri)
        }

        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(santri)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(santri)
        }
    }

    class SantriViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Santri>) {
        AllSantri.clear()
        AllSantri.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(santri: Santri)
        fun onDelete(santri: Santri)
        fun onUpdate(santri: Santri)
    }
}
