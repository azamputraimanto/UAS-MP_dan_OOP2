package id.ac.poltektegal.uasmpdanoop2.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(tableName = "santri")
data class Santri(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nomerInduk: Int,
    val namaSantri: String,
    val tanggalLahir: String,
    val asal: String,
    val alamat: String
): Parcelable