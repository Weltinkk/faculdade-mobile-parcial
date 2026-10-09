package com.unaerp.mobileparcial.ui.lista

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.recyclerview.widget.LinearLayoutManager
import com.unaerp.mobileparcial.data.MockData
import com.unaerp.mobileparcial.databinding.ActivityListaBinding
import com.unaerp.mobileparcial.ui.detalhe.DetalheActivity

class ListaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityListaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val barras = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(barras.left, barras.top, barras.right, barras.bottom)
            WindowInsetsCompat.CONSUMED
        }

        binding.rvExercicios.layoutManager = LinearLayoutManager(this)
        binding.rvExercicios.adapter = ExercicioAdapter(MockData.exercicios) { exercicio ->
            val intent = Intent(this, DetalheActivity::class.java)
                .putExtra(DetalheActivity.EXTRA_EXERCICIO_ID, exercicio.id)
            startActivity(intent)
        }
    }
}
