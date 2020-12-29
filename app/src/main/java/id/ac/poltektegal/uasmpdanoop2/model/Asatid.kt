package id.ac.poltektegal.uasmpdanoop2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "asatid")
class Asatid(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val kodeAsatid: Int,
    val namaAsatid: String,
    val jenisKelamin: String,
    val StafPengajar: String,
    val TahunPengabdian: String,
    val AsalPengabdian: String
): Parcelable