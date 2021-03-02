package pl.wmariusz.hedgehopt.infrastructure

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hedgehog(
    val name: String,
    val age: Int,
    val color: String,
    val description: String,
    val photoUrl: String
) : Parcelable
