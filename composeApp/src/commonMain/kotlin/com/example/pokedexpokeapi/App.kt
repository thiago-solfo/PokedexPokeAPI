package com.example.pokedexpokeapi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedexpokeapi.data.Pokemon
import com.example.pokedexpokeapi.data.PokemonMock
import com.example.pokedexpokeapi.navigation.BottomNav
import com.example.pokedexpokeapi.navigation.HomeRoute
import com.example.pokedexpokeapi.navigation.PokedexRoute
import com.example.pokedexpokeapi.navigation.PokemonDetailRoute
import com.example.pokedexpokeapi.navigation.PokemonTeamRoute
import com.example.pokedexpokeapi.ui.HomeScreen
import com.example.pokedexpokeapi.ui.PokedexGridScreen
import com.example.pokedexpokeapi.ui.PokemonDetailScreen
import com.example.pokedexpokeapi.ui.PokemonTeamScreen

@Composable
fun App() {
    val navController = rememberNavController()
    val selectedPokemon = remember { mutableStateListOf<Pokemon>() }

    MaterialTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            content = { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = HomeRoute
                    )
                    {
                        composable<HomeRoute> {
                            HomeScreen(
                                onSeePokedexClick = {
                                    navController.navigate(PokedexRoute)
                                }
                            )
                        }
                        composable<PokedexRoute> {
                            PokedexGridScreen(
                                pokemons = PokemonMock.getPokemonList(),
                                onPokemonClick = { pokemonId ->
                                    navController.navigate(PokemonDetailRoute(pokemonId))
                                }
                            )
                        }
                        composable<PokemonTeamRoute> {
                            PokemonTeamScreen(
                                pokemons = selectedPokemon.toList(),
                                onPokemonClick = { pokemonId ->
                                    navController.navigate(PokemonDetailRoute(pokemonId))
                                }
                            )
                        }
                        composable<PokemonDetailRoute> { backStackEntry ->
                            val route = backStackEntry.toRoute<PokemonDetailRoute>()
                            val pokemon = PokemonMock.findById(route.pokemonId)

                            if (pokemon == null) {
                                navController.popBackStack()
                                return@composable
                            }

                            PokemonDetailScreen(
                                pokemon = pokemon,
                                alreadyOnTeam = selectedPokemon.contains(pokemon),
                                addOrRemove = {
                                    if (selectedPokemon.contains(pokemon)) {
                                        selectedPokemon.remove(pokemon)
                                    } else {
                                        selectedPokemon.add(pokemon)
                                    }
                                },
                            )
                        }
                    }
                }

            },
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route?.substringBefore("?")
                currentRoute in BottomNav.entries.map { it.route::class.qualifiedName }

                BottomNavigation(
                    modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
                    backgroundColor = MaterialTheme.colorScheme.background,
                ) {
                    BottomNav.entries
                        .forEach { navigationItem ->
                            val isSelected by remember(currentRoute) {
                                derivedStateOf { currentRoute == navigationItem.route::class.qualifiedName }
                            }
                            BottomNavigationItem(
                                modifier = Modifier
                                    .testTag(navigationItem.name),
                                selected = isSelected,
                                label = {
                                    Text(
                                        text = navigationItem.label,
                                        style = MaterialTheme.typography.labelSmall
                                    )
                                },
                                icon = {
                                    val iconColor = if (isSelected) {
                                        when (navigationItem) {
                                            BottomNav.Pokedex -> Color(0xFFEE1515)
                                            BottomNav.PokemonTeam -> Color(0xFF8B4513)
                                            else -> MaterialTheme.colorScheme.primary
                                        }
                                    } else {
                                        MaterialTheme.colorScheme.onBackground
                                    }

                                    Icon(
                                        imageVector = (if (isSelected) navigationItem.selectedIcon else navigationItem.unselectedIcon),
                                        contentDescription = navigationItem.label,
                                        tint = iconColor,
                                    )
                                },
                                onClick = {
                                    navController.navigate(navigationItem.route)
                                },
                            )
                        }
                }
            },
        )
    }
}