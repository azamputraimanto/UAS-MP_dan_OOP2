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
import id.ac.poltektegal.uasmpdanoop2.model.Santri
import id.ac.poltektegal.uasmpdanoop2.viewmodel.SantriViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mSantriViewModel: SantriViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mSantriViewModel = ViewModelProvider(this).get(SantriViewModel::class.java)

        view.add_btn.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val nomerInduk = addNomerInduk_et.text
        val namaSantri = addNamaSantri_et.text.toString()
        val tanggalLahir = addTanggalLahir_et.text.toString()
        val asal = addAsal_et.text.toString()
        val alamat = addAlamat_et.text.toString()

        if(inputCheck(nomerInduk, namaSantri, tanggalLahir, asal, alamat)){
            // Create Santri Object
            val santri = Santri(0, Integer.parseInt(nomerInduk.toString()), namaSantri, tanggalLahir, asal, alamat)
            // Add Data to Database
            mSantriViewModel.addSantri(santri)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out fielsd.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(nomerInduk: Editable, namaSantri: String, tanggalLahir: String, asal: String, alamat: String): Boolean{
        return !(nomerInduk.isEmpty() && TextUtils.isEmpty(namaSantri) && TextUtils.isEmpty(tanggalLahir) && TextUtils.isEmpty(asal) && TextUtils.isEmpty(alamat))
    }

}