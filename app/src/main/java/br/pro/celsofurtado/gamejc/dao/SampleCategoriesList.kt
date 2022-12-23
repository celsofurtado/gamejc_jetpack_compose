package br.pro.celsofurtado.gamejc.dao

import androidx.compose.ui.graphics.Color
import br.pro.celsofurtado.gamejc.model.Category

fun categoriesListSample(): List<Category> {

    var categories = listOf<Category>(
        Category(
            "Mood swings",
            color = Color(135, 54, 0),
            textColor = Color(248, 249, 249),
        ),
        Category("Stress", color = Color(  248, 249, 249  ), textColor = Color(
            135,
            54,
            0
        )),
        Category("Depression", color = Color(  248, 249, 249 ), textColor = Color(
            135,
            54,
            0
        )),
        Category("Anxiety", color = Color(  248, 249, 249 ), textColor = Color(
            135,
            54,
            0
        )),
        Category("Mood swings", color = Color(  248, 249, 249  ), textColor = Color(
            135,
            54,
            0
        )),
        Category("Mood swings", color = Color(  248, 249, 249  ), textColor = Color(
            135,
            54,
            0
        )),
    )

    return categories

}