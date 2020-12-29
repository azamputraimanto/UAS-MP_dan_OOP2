package id.ac.poltektegal.uasmpdanoop2.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.ac.poltektegal.uasmpdanoop2.R
import id.ac.poltektegal.uasmpdanoop2.model.Asatid
import id.ac.poltektegal.uasmpdanoop2.viewmodel.AsatidViewModel
import kotlinx.android.synthetic.main.fragment_add_asatid.view.*
import kotlinx.android.synthetic.main.fragment_add_asatid.*

class addFragmentAsatid : Fragment() {

    private lateinit var mAsatidViewModel: AsatidViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_asatid, container, false)

        mAsatidViewModel = ViewModelProvider(this).get(AsatidViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val kodeAsatid = addKodeAsatid_et.text
        val namaAsatid = addNamaAsatid_et.text.toString()
        val jenisKelamin = addJenisKelamin_et.text.toString()
        val StafPengajar = addStafPengajar_et.text.toString()
        val TahunPengabdian = addTahunPengabdian_et.text.toString()
        val AsalPengabdian = addAsalPengabdian_et.text.toString()

        if(inputCheck(kodeAsatid, namaAsatid, jenisKelamin, StafPengajar, TahunPengabdian, AsalPengabdian)){
            // Create Asatid Object
            val asatid = Asatid(0, Integer.parseInt(kodeAsatid.toString()), namaAsatid, jenisKelamin, StafPengajar, TahunPengabdian, AsalPengabdian)
            // Add Data to Database
            mAsatidViewModel.addAsatid(asatid)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragmentAsatid_to_listFragmentAsatid)
        }else{
            Toast.makeText(requireContext(), "Please fill out fielsd.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(
        kodeAsatid: Editable,
        namaAsatid: String,
        jenisKelamin: String,
        StafPengajar: String,
        TahunPengabdian: String,
        AsalPengabdian: String
    ): Boolean{
        return !(kodeAsatid.isEmpty() && TextUtils.isEmpty(namaAsatid) &&
                TextUtils.isEmpty(jenisKelamin) && TextUtils.isEmpty(StafPengajar) &&
                TextUtils.isEmpty(TahunPengabdian) && TextUtils.isEmpty(AsalPengabdian))
    }

}