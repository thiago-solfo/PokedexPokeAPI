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
package com.joelkanyi.focusbloom.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pokedexpokeapi.navigation.HomeRoute
import com.example.pokedexpokeapi.navigation.PokedexRoute
import com.example.pokedexpokeapi.navigation.PokemonDetailRoute

enum class BottomNav(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon:  ImageVector,
    val index: Int,
    val route: Any,
) {
    Home(
        label = "Home",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Filled.Add,
        route = HomeRoute,
        index = 0,
    ),
    Calendar(
        label = "Calendar",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Filled.Add,
        route = PokedexRoute,
        index = 1,
    ),
    Statistics(
        label = "Statistics",
        selectedIcon = Icons.Filled.Add,
        unselectedIcon = Icons.Filled.Add,
        route = PokemonDetailRoute,
        index = 2,
    ),
}
