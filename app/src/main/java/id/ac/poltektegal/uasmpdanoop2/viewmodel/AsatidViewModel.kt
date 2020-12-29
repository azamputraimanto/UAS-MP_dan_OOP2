package id.ac.poltektegal.uasmpdanoop2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.ac.poltektegal.uasmpdanoop2.data.AsatidDatabase
import id.ac.poltektegal.uasmpdanoop2.model.Asatid
import id.ac.poltektegal.uasmpdanoop2.repository.AsatidRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AsatidViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Asatid>>
    private val repository: AsatidRepository

    init {
        val asatidDao = AsatidDatabase.getDatabase(application).asatidDao()
        repository = AsatidRepository(asatidDao)
        readAllData = repository.readAllData
    }

    fun addAsatid(asatid : Asatid) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAsatid(asatid)
        }
    }

    fun updateAsatid(asatid: Asatid) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAsatid(asatid)
        }
    }

    fun deleteAsatid(asatid: Asatid) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAsatid(asatid)
        }
    }

    fun deleteAllAsatids() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllAsatids()
        }
    }


}