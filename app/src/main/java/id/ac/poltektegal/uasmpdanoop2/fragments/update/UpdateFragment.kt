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
import id.ac.poltektegal.uasmpdanoop2.model.Santri
import id.ac.poltektegal.uasmpdanoop2.viewmodel.SantriViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private  val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mSantriViewModel: SantriViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mSantriViewModel = ViewModelProvider(this).get(SantriViewModel::class.java)

        view.updateNomerInduk_et.setText(args.currentSantri.nomerInduk.toString())
        view.updateNamaSantri_et.setText(args.currentSantri.namaSantri)
        view.updateTanggalLahir_et.setText(args.currentSantri.tanggalLahir)
        view.updateAsal_et.setText(args.currentSantri.asal)
        view.updateAlamat_et.setText(args.currentSantri.alamat)

        view.update_btn.setOnClickListener{
            updateItem()
        }

        // Add Menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val nomerInduk = Integer.parseInt(updateNomerInduk_et.text.toString())
        val namaSantri = updateNamaSantri_et.text.toString()
        val tanggalLahir = updateTanggalLahir_et.text.toString()
        val asal = updateAsal_et.text.toString()
        val alamat = updateAlamat_et.text.toString()

        if (inputCheck(updateNomerInduk_et.text, namaSantri, tanggalLahir, asal, alamat)){
            // Create Santri Update
            val updatedSantri = Santri(args.currentSantri.id, nomerInduk, namaSantri, tanggalLahir, asal, alamat)
            // Update Current Santri
            mSantriViewModel.updateSantri(updatedSantri)
            Toast.makeText(requireContext(), "Update Successfully!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(noInduk: Editable, namaSantri: String, tanggalLahir: String, asal: String, alamat: String): Boolean{
        return !(noInduk.isEmpty() && TextUtils.isEmpty(namaSantri) && TextUtils.isEmpty(tanggalLahir) && TextUtils.isEmpty(asal) && TextUtils.isEmpty(alamat))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteSantri()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteSantri() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mSantriViewModel.deleteSantri(args.currentSantri)
            Toast.makeText(
                requireContext(),
                "Successfully removed: ${args.currentSantri.nomerInduk}",
                Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No") {_, _ ->}
        builder.setTitle("Delete ${args.currentSantri.nomerInduk}?")
        builder.setMessage("Are you sure tou want to delete ${args.currentSantri.nomerInduk}")
        builder.create().show()
    }

}