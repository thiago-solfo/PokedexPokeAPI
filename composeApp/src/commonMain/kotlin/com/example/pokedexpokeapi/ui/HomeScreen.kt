package com.example.pokedexpokeapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedexpokeapi.data.PokemonMock
import com.example.pokedexpokeapi.data.PokemonTypeColors
import isAndroid
import isIOS
import org.jetbrains.compose.resources.painterResource
import pokedexpokeapi.composeapp.generated.resources.Res
import pokedexpokeapi.composeapp.generated.resources.banner
import pokedexpokeapi.composeapp.generated.resources.pokemon_android
import pokedexpokeapi.composeapp.generated.resources.pokemon_iphone

@Composable
fun HomeScreen (
    onSeePokedexClick: () -> Unit
) {
    val imageRes = when {
        isAndroid() -> Res.drawable.pokemon_android
        isIOS() -> Res.drawable.pokemon_iphone
        else -> Res.drawable.pokemon_android
    }

    val pokemonOfDay = remember { PokemonMock.pokedex.random() }
    val typeColor = PokemonTypeColors.getColorForType(pokemonOfDay.types.firstOrNull() ?: "")

    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(Res.drawable.banner),
            contentDescription = "Pokedex Banner",
            modifier = Modifier
                .padding(vertical = 24.dp, horizontal = 100.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(imageRes),
            contentDescription = "descrição"
        )
        Text(
            text = "Bem-vindo ao Pokedex KMP!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp, bottom = 24.dp)
        )
        Text(
            text = "Visualize os Pokémons em uma pokedex extensiva, e monte o time dos seus sonhos!",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 24.dp, bottom = 12.dp, start = 24.dp, end = 24.dp)
        )

        ElevatedCard(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 16.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.extraLarge,
           // colors = CardDefaults.elevatedCardColors(
               // containerColor = typeColor.copy(alpha = 0.2f)
            //)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {
                Text(
                    text = "POKÉMON DO DIA",
                    style = MaterialTheme.typography.labelLarge,
                    color = typeColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    AsyncImage(
                        model = pokemonOfDay.imageUrl,
                        contentDescription = pokemonOfDay.name,
                        modifier = Modifier.size(100.dp)
                    )

                    Column {
                        Text(
                            text = pokemonOfDay.name.capitalizePokemonName(),
                            style = MaterialTheme.typography.headlineSmall,
                            color = MaterialTheme.colorScheme.onSurface,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )

                        Row(
                            horizontalArrangement = Arrangement.spacedBy(3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            pokemonOfDay.types.forEach { type ->
                                val chipColor = PokemonTypeColors.getColorForType(type)
                                AssistChip(
                                    onClick = {},
                                    label = {
                                        Text(
                                            type.capitalizePokemonName(),
                                            style = MaterialTheme.typography.labelMedium,
                                            color = Color.White
                                        )
                                    },
                                    colors = AssistChipDefaults.assistChipColors(
                                        containerColor = chipColor,
                                        labelColor = Color.White
                                    ),
                                    border = null,
                                    shape = MaterialTheme.shapes.extraLarge
                                )
                            }
                        }
                    }
                }
            }
        }

        Button(onClick = onSeePokedexClick, modifier = Modifier.padding(top = 16.dp)) {
            Text("Ver Pokedex")
        }
    }
}