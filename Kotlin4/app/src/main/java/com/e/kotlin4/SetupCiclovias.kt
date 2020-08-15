package com.e.kotlin4

/**
 * Created by ciromine on 8/26/19.
 */
class SetupCiclovias {
    private val listaNombres = arrayOf(
        "Ciclovia 1",
        "Ciclovia 2",
        "Ciclovia 3",
        "Ciclovia 4",
        "Ciclovia 5",
        "Ciclovia 6",
        "Ciclovia 7",
        "Ciclovia 8",
        "Ciclovia 9",
        "Ciclovia 10"
    )
    private val listaComunas = arrayOf(
        "Las Condes",
        "La Reina",
        "Ñuñoa",
        "Macul",
        "Providencia",
        "Las Condes",
        "La Reina",
        "Ñuñoa",
        "Macul",
        "Providencia"
    )

    fun init(): List<Ciclovia> {
        return listaNombres.zip(listaComunas) { a, b -> Ciclovia(a, b)} as ArrayList<Ciclovia>
    }
}
