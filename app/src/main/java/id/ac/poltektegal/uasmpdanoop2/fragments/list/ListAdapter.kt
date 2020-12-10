package id.ac.poltektegal.uasmpdanoop2.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.ac.poltektegal.uasmpdanoop2.R
import id.ac.poltektegal.uasmpdanoop2.model.Santri
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var santriList = emptyList<Santri>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun getItemCount(): Int {
        return santriList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = santriList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.nomerInduk_text.text = currentItem.nomerInduk.toString()
        holder.itemView.namaSantri_text.text = currentItem.namaSantri
        holder.itemView.tanggalLahir_text.text = currentItem.tanggalLahir
        holder.itemView.asal_text.text = currentItem.asal
        holder.itemView.alamat_text.text = currentItem.alamat

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(santri: List<Santri>){
        this.santriList = santri
        notifyDataSetChanged()
    }
}