package com.example.pokedexpokeapi

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedexpokeapi.data.PokemonMock
import com.example.pokedexpokeapi.navigation.HomeRoute
import com.example.pokedexpokeapi.navigation.PokedexRoute
import com.example.pokedexpokeapi.navigation.PokemonDetailRoute
import com.example.pokedexpokeapi.ui.HomeScreen
import com.example.pokedexpokeapi.ui.PokedexGridScreen
import com.example.pokedexpokeapi.ui.PokemonDetailScreen
import com.joelkanyi.focusbloom.core.presentation.navigation.BottomNav
import org.jetbrains.compose.resources.painterResource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

@Composable
fun App(navController: NavHostController,) {
    MaterialTheme {
        Scaffold(
            content = { innerPadding ->
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
            },
            floatingActionButtonPosition = FabPosition.Center,
            floatingActionButton = {
                FloatingActionButton(
                    modifier = Modifier
                        .offset(y = 60.dp)
                        .size(42.dp),
                    containerColor = MaterialTheme.colorScheme.primary,
                    onClick = {
                        navController.navigate(PokedexRoute)
                    },
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 0.dp,
                    ),
                    shape = CircleShape,
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Add Task",
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(24.dp),
                    )
                }
            },
            bottomBar = {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route?.substringBefore("?")
                    currentRoute in BottomNav.entries.map { it.route::class.qualifiedName }

                    BottomNavigation(
                        backgroundColor = MaterialTheme.colorScheme.background,
                    ) {
                        BottomNav.entries
                            .forEach { navigationItem ->
                                val isSelected by remember(currentRoute) {
                                    derivedStateOf { currentRoute == navigationItem.route::class.qualifiedName }
                                }
                                BottomNavigationItem(
                                    modifier = Modifier
                                        .testTag(navigationItem.name)
                                        .offset(
                                            x = when (navigationItem.index) {
                                                0 -> 0.dp
                                                1 -> (-24).dp
                                                2 -> 24.dp
                                                3 -> 0.dp
                                                else -> 0.dp
                                            },
                                        ),
                                    selected = isSelected,
                                    label = {
                                        Text(
                                            text = navigationItem.label,
                                            style = MaterialTheme.typography.labelSmall
                                        )
                                    },
                                    icon = {
                                        Icon(
                                            imageVector = (if (isSelected) navigationItem.selectedIcon else navigationItem.unselectedIcon),
                                            contentDescription = navigationItem.label,
                                            tint = if (isSelected) {
                                                MaterialTheme.colorScheme.primary
                                            } else {
                                                MaterialTheme.colorScheme.onBackground
                                            },
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