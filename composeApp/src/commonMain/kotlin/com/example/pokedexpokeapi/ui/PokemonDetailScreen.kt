package com.example.pokedexpokeapi.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Card
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedexpokeapi.data.Pokemon

@Composable
fun PokemonDetailScreen(
    pokemon: Pokemon,
    addOrRemove: () -> Unit,
    alreadyOnTeam: Boolean,
) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = addOrRemove,
            ) {
                val icon = if (alreadyOnTeam) Icons.Filled.Remove else Icons.Filled.Add
                val description = if (alreadyOnTeam) "Remover do time" else "Adicionar ao time"

                Icon(
                    imageVector = icon,
                    contentDescription = description
                )
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(20.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = pokemon.id.formatPokemonNumber(),
                            style = MaterialTheme.typography.labelLarge
                        )

                        Text(
                            text = pokemon.name.capitalizePokemonName(),
                            style = MaterialTheme.typography.headlineSmall
                        )

                        AsyncImage(
                            model = pokemon.imageUrl,
                            contentDescription = pokemon.name
                        )

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            pokemon.types.forEach { type ->
                                AssistChip(
                                    onClick = {},
                                    label = { Text(type.capitalizePokemonName()) }
                                )
                            }
                        }

                        Text(
                            text = pokemon.description,
                            style = MaterialTheme.typography.bodyLarge
                        )

                        Text(
                            text = "Altura: ${pokemon.height}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "Peso: ${pokemon.weight}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Text(
                            text = "Stats",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp)
                        )

                        pokemon.stats.forEach { stat ->
                            Text(
                                text = "${stat.name}: ${stat.value}",
                                style = MaterialTheme.typography.bodySmall,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        },
    )
}