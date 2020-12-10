package id.ac.poltektegal.uasmpdanoop2.repository

import androidx.lifecycle.LiveData
import id.ac.poltektegal.uasmpdanoop2.data.SantriDao
import id.ac.poltektegal.uasmpdanoop2.model.Santri

class SantriRepository(private val santriDao: SantriDao) {

    val readAllData: LiveData<List<Santri>> = santriDao.readAllData()

    suspend fun addSantri(santri: Santri) {
        santriDao.addSantri(santri)
    }

    suspend fun updateSantri(santri: Santri){
        santriDao.updateSantri(santri)
    }

    suspend fun deleteSantri(santri: Santri){
        santriDao.deleteSantri(santri)
    }

    suspend fun deleteAllSantris(){
        santriDao.deleteAllSantris()
    }
    
}