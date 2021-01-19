package id.ac.poltektegal.uasmpdanoop2.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import id.ac.poltektegal.uasmpdanoop2.R
import id.ac.poltektegal.uasmpdanoop2.model.Asatid
<<<<<<< HEAD
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.custom_row_asatid.view.*
import kotlinx.android.synthetic.main.custom_row_asatid.view.id_text
=======
import kotlinx.android.synthetic.main.custom_row_asatid.view.*
>>>>>>> 4efe68ea3f48dd1d894d905eeac682cb8c06567d

class ListAdapterAsatid: RecyclerView.Adapter<ListAdapterAsatid.MyViewHolder>() {

    private var asatidList = emptyList<Asatid>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row_asatid, parent, false))
    }

    override fun getItemCount(): Int {
        return asatidList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = asatidList[position]
        holder.itemView.id_text.text = currentItem.id.toString()
        holder.itemView.kodeAsatid_text.text = currentItem.kodeAsatid.toString()
        holder.itemView.namaAsatid_text.text = currentItem.namaAsatid
        holder.itemView.jenisKelamin_text.text = currentItem.jenisKelamin
        holder.itemView.StafPengajar_text.text = currentItem.StafPengajar
        holder.itemView.TahunPengabdian_text.text = currentItem.TahunPengabdian
        holder.itemView.AsalPengabdian_text.text = currentItem.AsalPengabdian

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentAsatidDirections.actionListFragmentAsatidToUpdateFragmentAsatid(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(asatid: List<Asatid>){
        this.asatidList = asatid
        notifyDataSetChanged()
    }
}