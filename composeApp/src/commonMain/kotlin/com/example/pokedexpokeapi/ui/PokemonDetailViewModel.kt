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

sealed interface PokemonDetailUiState {
    data object Loading : PokemonDetailUiState
    data class Success(val pokemon: Pokemon) : PokemonDetailUiState
    data class Error(val message: String) : PokemonDetailUiState
}

class PokemonDetailViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<PokemonDetailUiState>(PokemonDetailUiState.Loading)
    val uiState: StateFlow<PokemonDetailUiState> = _uiState.asStateFlow()

    fun loadPokemon(pokemonId: Int) {
        viewModelScope.launch {
            _uiState.value = PokemonDetailUiState.Loading
            try {
                delay(500)
                val pokemon = PokemonMock.findById(pokemonId)
                if (pokemon != null) {
                    _uiState.value = PokemonDetailUiState.Success(pokemon)
                } else {
                    _uiState.value = PokemonDetailUiState.Error("Pokémon não encontrado")
                }
            } catch (e: Exception) {
                _uiState.value = PokemonDetailUiState.Error(e.message ?: "Falha ao carregar Pokémon")
            }
        }
    }
}
