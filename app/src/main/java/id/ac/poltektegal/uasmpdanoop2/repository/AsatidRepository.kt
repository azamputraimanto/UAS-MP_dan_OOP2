package id.ac.poltektegal.uasmpdanoop2.repository

import androidx.lifecycle.LiveData
import id.ac.poltektegal.uasmpdanoop2.data.AsatidDao
import id.ac.poltektegal.uasmpdanoop2.model.Asatid

class AsatidRepository(private val asatidDao: AsatidDao) {

    val readAllData: LiveData<List<Asatid>> = asatidDao.readAllData()

    suspend fun addAsatid(asatid: Asatid) {
        asatidDao.addAsatid(asatid)
    }

    suspend fun updateAsatid(asatid: Asatid){
        asatidDao.updateAsatid(asatid)
    }

    suspend fun deleteAsatid(asatid: Asatid){
        asatidDao.deleteAsatid(asatid)
    }

    suspend fun deleteAllAsatids(){
        asatidDao.deleteAllAsatids()
    }

}