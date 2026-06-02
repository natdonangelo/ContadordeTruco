package com.natalia_donangelo.contadordetruco

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ContadorViewModel : ViewModel() {

    // Pontuação do Time A
    private val _pontosA = MutableStateFlow(0)
    val pontosA: StateFlow<Int> = _pontosA.asStateFlow()

    // Pontuação do Time B
    private val _pontosB = MutableStateFlow(0)
    val pontosB: StateFlow<Int> = _pontosB.asStateFlow()

    fun somarTimeA(valor: Int = 1) {
        if (_pontosA.value + valor <= 12) {
            _pontosA.value += valor
        }
    }

    fun subtrairTimeA() {
        if (_pontosA.value > 0) {
            _pontosA.value -= 1
        }
    }

    fun somarTimeB(valor: Int = 1) {
        if (_pontosB.value + valor <= 12) {
            _pontosB.value += valor
        }
    }

    fun subtrairTimeB() {
        if (_pontosB.value > 0) {
            _pontosB.value -= 1
        }
    }

    fun reiniciarPartida() {
        _pontosA.value = 0
        _pontosB.value = 0
    }
}