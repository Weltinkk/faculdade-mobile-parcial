package com.unaerp.mobileparcial.data

import com.unaerp.mobileparcial.model.Exercicio
import com.unaerp.mobileparcial.model.GrupoMuscular

object MockData {

    val exercicios: List<Exercicio> = listOf(
        Exercicio(1, "Supino reto", GrupoMuscular.PEITO, 4, 12, 40.0, "Mantenha as escápulas retraídas"),
        Exercicio(2, "Flexão de braço", GrupoMuscular.PEITO, 3, 15, null, null),
        Exercicio(3, "Remada curvada", GrupoMuscular.COSTAS, 4, 10, 30.0, "Coluna neutra e puxe até o abdômen"),
        Exercicio(4, "Puxada frontal", GrupoMuscular.COSTAS, 3, 12, 45.0, null),
        Exercicio(5, "Agachamento livre", GrupoMuscular.PERNAS, 4, 12, 60.0, "Joelhos alinhados com a ponta dos pés"),
        Exercicio(6, "Leg press 45°", GrupoMuscular.PERNAS, 4, 15, 120.0, null),
        Exercicio(7, "Desenvolvimento com halteres", GrupoMuscular.OMBROS, 4, 10, 22.5, null),
        Exercicio(8, "Prancha abdominal", GrupoMuscular.ABDOMEN, 3, 1, null, "Segure por 45 segundos em cada série")
    )

    fun buscarPorId(id: Int): Exercicio? = exercicios.firstOrNull { it.id == id }
}
