package id.ac.poltektegal.uasmpdanoop2.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import id.ac.poltektegal.uasmpdanoop2.R
import id.ac.poltektegal.uasmpdanoop2.model.Asatid
import id.ac.poltektegal.uasmpdanoop2.viewmodel.AsatidViewModel
import kotlinx.android.synthetic.main.fragment_update_asatid.*
import kotlinx.android.synthetic.main.fragment_update_asatid.view.*

class UpdateFragmentAsatid : Fragment() {

    private  val args by navArgs<UpdateFragmentAsatidArgs>()

    private lateinit var mAsatidViewModel: AsatidViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update_asatid, container, false)

        mAsatidViewModel = ViewModelProvider(this).get(AsatidViewModel::class.java)

        view.updateKodeAsatid_et.setText(args.currentAsatid.kodeAsatid.toString())
        view.updateNamaAsatid_et.setText(args.currentAsatid.namaAsatid)
        view.updateJenisKelamin_et.setText(args.currentAsatid.jenisKelamin)
        view.updateStafPengajar_et.setText(args.currentAsatid.StafPengajar)
        view.updateStafPengajar_et.setText(args.currentAsatid.TahunPengabdian)
        view.updateAsalPengabdian_et.setText(args.currentAsatid.AsalPengabdian)

        view.update_btn.setOnClickListener{
            updateItem()
        }

        // Add Menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val kodeAsatid = Integer.parseInt(updateKodeAsatid_et.text.toString())
        val namaAsatid = updateNamaAsatid_et.text.toString()
        val jenisKelamin = updateJenisKelamin_et.text.toString()
        val StafPengajar = updateStafPengajar_et.text.toString()
        val TahunPengabdian = updateStafPengajar_et.text.toString()
        val AsalPengabdian = updateAsalPengabdian_et.text.toString()

        if (inputCheck(updateKodeAsatid_et.text, namaAsatid, jenisKelamin, StafPengajar, TahunPengabdian, AsalPengabdian)){
            // Create Asatid Update
            val updatedAsatid = Asatid(args.currentAsatid.id, kodeAsatid, namaAsatid, jenisKelamin, StafPengajar, TahunPengabdian, AsalPengabdian)
            // Update Current Asatid
            mAsatidViewModel.updateAsatid(updatedAsatid)
            Toast.makeText(requireContext(), "Update Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragmentAsatid_to_listFragmentAsatid)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(
        kodeAsatid: Editable,
        namaAsatid: String,
        jenisKelamin: String,
        StafPengajar: String,
        TahunPengabdian : String,
        AsalPengabdian: String
    ): Boolean{
        return !(kodeAsatid.isEmpty() && TextUtils.isEmpty(namaAsatid) && TextUtils.isEmpty(jenisKelamin) && TextUtils.isEmpty(StafPengajar) && TextUtils.isEmpty(TahunPengabdian) && TextUtils.isEmpty(AsalPengabdian))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAsatid()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAsatid() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mAsatidViewModel.deleteAsatid(args.currentAsatid)
            Toast.makeText(
                    requireContext(),
                    "Successfully removed: ${args.currentAsatid.kodeAsatid}",
                    Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragmentAsatid_to_listFragmentAsatid)
        }
        builder.setNegativeButton("No") {_, _ ->}
        builder.setTitle("Delete ${args.currentAsatid.kodeAsatid}?")
        builder.setMessage("Are you sure tou want to delete ${args.currentAsatid.kodeAsatid}")
        builder.create().show()
    }

}