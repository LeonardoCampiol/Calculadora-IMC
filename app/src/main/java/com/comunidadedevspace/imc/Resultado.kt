package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


const val CHAVE_RESULTADO_IMC = "Resultado.Chave_IMC"


class Resultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val resultado = intent.getFloatExtra(CHAVE_RESULTADO_IMC, 0f)

        val tvresultadocalculo = findViewById<TextView>(R.id.tv_resultadocalculo)
        val tvclassificacao = findViewById<TextView>(R.id.tv_classificacao)

        tvresultadocalculo.text = resultado.toString()

        val (classificacao: String , cor: Int) = when {
            resultado < 18.5f -> {
                "MAGREZA" to R.color.Magreza
            }

            resultado >= 18.5f && resultado <= 24.9f -> {
                "NORMAL" to R.color.Normal
            }


            resultado >= 25f && resultado <= 29.9f -> {
            "SOBREPESO" to R.color.Sobrepeso
        }


            resultado >= 30f && resultado <= 39.9f -> {
                "OBESIDADE" to R.color.Obesidade
            }

            else -> {
                "OBESIDADE GRAVE" to R.color.Obesidade_grave
            }
        }

        tvclassificacao.setTextColor(ContextCompat.getColor(this, cor))

        tvclassificacao.text = classificacao
            }
        }