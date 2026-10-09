package com.unaerp.mobileparcial.ui.detalhe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.commit
import com.unaerp.mobileparcial.R
import com.unaerp.mobileparcial.databinding.ActivityDetalheBinding

class DetalheActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val barras = insets.getInsets(
                WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.displayCutout()
            )
            view.updatePadding(barras.left, barras.top, barras.right, barras.bottom)
            WindowInsetsCompat.CONSUMED
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_detalhe)

        if (savedInstanceState == null) {
            val exercicioId = intent.getIntExtra(EXTRA_EXERCICIO_ID, -1)
            supportFragmentManager.commit {
                add(binding.flDetalhe.id, DetalheFragment.newInstance(exercicioId))
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    companion object {
        const val EXTRA_EXERCICIO_ID = "EXTRA_EXERCICIO_ID"
    }
}
