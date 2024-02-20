package com.example.manejodecard.ui.theme.data
import com.example.manejodecard.R
import com.example.manejodecard.ui.theme.model.Platillo


class DataSource {
    fun LoadPlatillos(): List<Platillo> {
        return listOf<Platillo>(
            Platillo(R.string.desayuno, R.drawable.desayuno, 30.0, true,50.6),
            Platillo(R.string.hamburger, R.drawable.hamburger, 15.0, false,150.99),
            Platillo(R.string.pizza, R.drawable.pizza, 5.0, true,199.99),
            Platillo(R.string.postre, R.drawable.postre, 5.0, false,50.99),
            Platillo(R.string.pozole, R.drawable.pozole, 8.0, true,150.99),
            Platillo(R.string.tacos, R.drawable.tacos, 10.0, false,30.99)
        )
    }
}