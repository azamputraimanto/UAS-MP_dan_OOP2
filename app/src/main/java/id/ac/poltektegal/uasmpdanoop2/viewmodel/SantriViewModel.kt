package id.ac.poltektegal.uasmpdanoop2.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import id.ac.poltektegal.uasmpdanoop2.data.SantriDatabase
import id.ac.poltektegal.uasmpdanoop2.repository.SantriRepository
import id.ac.poltektegal.uasmpdanoop2.model.Santri
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SantriViewModel(application: Application): AndroidViewModel(application) {

    val readAllData: LiveData<List<Santri>>
    private val repository: SantriRepository

    init {
        val santriDao = SantriDatabase.getDatabase(application).santriDao()
        repository = SantriRepository(santriDao)
        readAllData = repository.readAllData
    }

    fun addSantri(santri: Santri) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addSantri(santri)
        }
    }

    fun updateSantri(santri: Santri) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateSantri(santri)
        }
    }

    fun deleteSantri(santri: Santri) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteSantri(santri)
        }
    }

    fun deleteAllSantris() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllSantris()
        }
    }


}