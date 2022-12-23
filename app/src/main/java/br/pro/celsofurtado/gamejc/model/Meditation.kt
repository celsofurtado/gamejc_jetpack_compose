package br.pro.celsofurtado.gamejc.model

import androidx.compose.ui.graphics.Color

data class Meditation(
    var meditationTitle: String,
    var meditationText: String,
    var meditationTime: Int,
    var meditationAuthor: String,
    var meditationColor: Color
)