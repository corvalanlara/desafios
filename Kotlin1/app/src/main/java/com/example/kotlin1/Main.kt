package com.example.kotlin1

class Main {

    // 2
    fun main(args: Array<String>) {
        // 3
        print("Mi nombre es Daniel Corvalán")

        // 4
        val num1 = 10
        val num2 = 20
        val num3 = 30

        // 5
        print(num1 + num2 + num3)

        // 6
        var cadena: String
        var caracter: Char

        // 7
        cadena = "Arataka Reigen"
        caracter = 'a'

        // 8
        print(cadena.length)
        caracter = 'c'

        // 9
        val flotante: Float

        // 10
        flotante = 1.45f

        // 11
        print(Byte.MAX_VALUE)
        print(Short.MAX_VALUE)

        // 12
        print(Int.MIN_VALUE)
        print(Long.MIN_VALUE)

        // 13
        var buleana = true
        print(buleana)

        // 16
        imprimiendoParametros("Daniel", "Corvalán")
        obtieneIVA()
    }

    // 14
    fun imprimiendoParametros(param1: String, param2: String) {
        print(param1.length + param2.length)
    }

    // 15
    fun obtieneIVA() : Int {
        return 19
    }

}