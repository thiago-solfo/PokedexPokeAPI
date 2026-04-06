/*
 * Copyright 2024 Joel Kanyi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.pokedexpokeapi.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backpack
import androidx.compose.material.icons.filled.CatchingPokemon
import androidx.compose.material.icons.filled.House
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNav(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon:  ImageVector,
    val index: Int,
    val route: Any,
) {
    Home(
        label = "Home",
        selectedIcon = Icons.Filled.House,
        unselectedIcon = Icons.Filled.House,
        route = HomeRoute,
        index = 0,
    ),
    Pokedex(
        label = "Pokedex",
        selectedIcon = Icons.Filled.CatchingPokemon,
        unselectedIcon = Icons.Filled.CatchingPokemon,
        route = PokedexRoute,
        index = 1,
    ),
    PokemonTeam(
        label = "Meu time",
        selectedIcon = Icons.Filled.Backpack,
        unselectedIcon = Icons.Filled.Backpack,
        route = PokemonTeamRoute,
        index = 2,
    ),
}
