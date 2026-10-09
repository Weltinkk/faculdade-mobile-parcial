package com.unaerp.mobileparcial.model

import androidx.annotation.ColorRes
import com.unaerp.mobileparcial.R

enum class GrupoMuscular(val rotulo: String, @param:ColorRes val corRes: Int) {
    PEITO("Peito", R.color.grupo_peito),
    COSTAS("Costas", R.color.grupo_costas),
    PERNAS("Pernas", R.color.grupo_pernas),
    OMBROS("Ombros", R.color.grupo_ombros),
    ABDOMEN("Abdômen", R.color.grupo_abdomen)
}
