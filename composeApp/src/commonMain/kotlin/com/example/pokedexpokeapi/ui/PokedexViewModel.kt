package com.example.pokedexpokeapi.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexpokeapi.data.Pokemon
import com.example.pokedexpokeapi.data.PokemonMock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface PokedexUiState {
    data object Loading : PokedexUiState
    data class Success(val pokemonList: List<Pokemon>) : PokedexUiState
    data class Error(val message: String) : PokedexUiState
}

class PokedexViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<PokedexUiState>(PokedexUiState.Loading)
    val uiState: StateFlow<PokedexUiState> = _uiState.asStateFlow()

    init {
        loadPokemon()
    }

    fun loadPokemon() {
        viewModelScope.launch {
            _uiState.value = PokedexUiState.Loading
            try {
                // Simulating network delay to demonstrate Loading state
                delay(1000)
                val pokemon = PokemonMock.getPokemonList()
                _uiState.value = PokedexUiState.Success(pokemon)
            } catch (e: Exception) {
                _uiState.value = PokedexUiState.Error(e.message ?: "Falha ao carregar dados")
            }
        }
    }
}
