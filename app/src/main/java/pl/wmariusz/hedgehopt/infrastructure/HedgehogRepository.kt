package pl.wmariusz.hedgehopt.infrastructure

import javax.inject.Inject

class HedgehogRepository @Inject constructor() {

    private val data = listOf(
        Hedgehog(
            "Roland",
            2,
            "White",
            DESCRIPTION,
            "https://images.pexels.com/photos/50577/hedgehog-animal-baby-cute-50577.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        Hedgehog(
            "Galaxy",
            3,
            "Brown",
            DESCRIPTION,
            "https://images.pexels.com/photos/206862/pexels-photo-206862.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        Hedgehog(
            "Rupert",
            4,
            "Brown",
            DESCRIPTION,
            "https://images.pexels.com/photos/260143/pexels-photo-260143.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        Hedgehog(
            "Darling",
            5,
            "Brown",
            DESCRIPTION,
            "https://images.pexels.com/photos/134061/pexels-photo-134061.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        Hedgehog(
            "Chowder",
            6,
            "White",
            DESCRIPTION,
            "https://images.pexels.com/photos/248246/pexels-photo-248246.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        ),
        Hedgehog(
            "Chowder",
            6,
            "Brown",
            DESCRIPTION,
            "https://images.pexels.com/photos/12526/pexels-photo-12526.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"
        )
    )

    fun hedgehogs(): List<Hedgehog> = data

    companion object {
        private const val DESCRIPTION =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec vel nisi a ipsum dignissim egestas vitae in dui."
    }
}