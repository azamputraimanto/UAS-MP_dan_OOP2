package id.ac.poltektegal.uasmpdanoop2.fragments.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import id.ac.poltektegal.uasmpdanoop2.R
import id.ac.poltektegal.uasmpdanoop2.viewmodel.AsatidViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListFragmentAsatid : Fragment() {

    private lateinit var mAsatidViewModel: AsatidViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_asatid, container, false)

        // Recyclerview
        val adapter = ListAdapterAsatid()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // AsatidViewModel
        mAsatidViewModel = ViewModelProvider(this).get(AsatidViewModel::class.java)
        mAsatidViewModel.readAllData.observe(viewLifecycleOwner, Observer { asatid ->
            adapter.setData(asatid)
        })

        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragmentAsatid_to_addFragmentAsatid)
        }

        //Add menu
        setHasOptionsMenu(true)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete){
            deleteAllAsatids()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteAllAsatids() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes") {_, _ ->
            mAsatidViewModel.deleteAllAsatids()
            Toast.makeText(
                    requireContext(),
                    "Successfully removed everything",
                    Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") {_, _ ->}
        builder.setTitle("Delete everything?")
        builder.setMessage("Are you sure tou want to delete everything?")
        builder.create().show()
    }

}