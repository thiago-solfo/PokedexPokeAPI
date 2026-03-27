package com.example.pokedexpokeapi

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedexpokeapi.data.PokemonMock
import com.example.pokedexpokeapi.navigation.HomeRoute
import com.example.pokedexpokeapi.navigation.PokedexRoute
import com.example.pokedexpokeapi.navigation.PokemonDetailRoute
import com.example.pokedexpokeapi.ui.HomeScreen
import com.example.pokedexpokeapi.ui.PokedexGridScreen
import com.example.pokedexpokeapi.ui.PokemonDetailScreen
import org.jetbrains.compose.resources.painterResource

import pokedexpokeapi.composeapp.generated.resources.Res
import pokedexpokeapi.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ) {
            composable<HomeRoute> {
                HomeScreen (
                    onSeePokedexClick = {
                        navController.navigate(PokedexRoute)
                    }
                )
            }
            composable<PokedexRoute> {
                PokedexGridScreen(
                    pokemons = PokemonMock.pokedex,
                    onPokemonClick = { pokemonId ->
                        navController.navigate(PokemonDetailRoute(pokemonId))
                    },
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

            composable<PokemonDetailRoute> { backStackEntry ->
                val route = backStackEntry.toRoute<PokemonDetailRoute>()
                val pokemon = PokemonMock.findById(route.pokemonId)

                PokemonDetailScreen(
                    pokemon = pokemon,
                    onBackClick = {
                        navController.popBackStack()
                    }
                )
            }

        }
    }
}