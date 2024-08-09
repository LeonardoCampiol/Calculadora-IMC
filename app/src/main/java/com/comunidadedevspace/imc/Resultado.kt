package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val classificacao: String

        classificacao = if (resultado < 18.5f) {
            "MAGREZA"
        } else if (resultado >= 18.5f && resultado <= 24.9f) {
            "NORMAL"
        } else if (resultado >= 25f && resultado <= 29.9f) {
            "SOBREPESO"
        } else if (resultado >= 30f && resultado <= 39.9f) {
            "OBESIDADE"
        } else {
            "OBESIDADE GRAVE"
        }
        tvclassificacao.text = classificacao
    }
}