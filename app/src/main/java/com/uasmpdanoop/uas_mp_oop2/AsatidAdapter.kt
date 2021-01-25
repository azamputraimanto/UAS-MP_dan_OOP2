package com.uasmpdanoop.uas_mp_oop2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uasmpdanoop.uas_mp_oop2.Database.Asatid
import kotlinx.android.synthetic.main.adapter_asatid.view.*
import kotlinx.android.synthetic.main.adapter_asatid.view.icon_delete
import kotlinx.android.synthetic.main.adapter_asatid.view.icon_edit

class AsatidAdapter (private val AllAsatid: ArrayList<Asatid>, private val listener: OnAdapterListener) : RecyclerView.Adapter<AsatidAdapter.AsatidViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsatidViewHolder {
        return AsatidViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_asatid,parent, false)
        )
    }

    override fun getItemCount() = AllAsatid.size

    override fun onBindViewHolder(holder: AsatidViewHolder, position: Int) {
        val asatid = AllAsatid[position]
        holder.view.text_kode_asatid.text = asatid.kode_asatid.toString()
        holder.view.text_name.text = asatid.name
        holder.view.text_alumni.text = asatid.alumni
        holder.view.text_tahun_lulus.text = asatid.tahun_lulus.toString()

        holder.view.text_kode_asatid.setOnClickListener {
            listener.onClick(asatid)
        }

        holder.view.text_name.setOnClickListener {
            listener.onClick(asatid)
        }

        holder.view.text_alumni.setOnClickListener {
            listener.onClick(asatid)
        }

        holder.view.text_tahun_lulus.setOnClickListener {
            listener.onClick(asatid)
        }

        holder.view.icon_delete.setOnClickListener {
            listener.onDelete(asatid)
        }
        holder.view.icon_edit.setOnClickListener {
            listener.onUpdate(asatid)
        }
    }

    class AsatidViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Asatid>) {
        AllAsatid.clear()
        AllAsatid.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(asatid: Asatid)
        fun onDelete(asatid: Asatid)
        fun onUpdate(asatid: Asatid)
    }
}