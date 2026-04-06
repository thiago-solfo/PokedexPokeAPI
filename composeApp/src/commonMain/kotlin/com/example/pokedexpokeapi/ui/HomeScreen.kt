package com.example.pokedexpokeapi.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.LocalPlatformContext
import isAndroid
import isIOS
import org.jetbrains.compose.resources.painterResource
import pokedexpokeapi.composeapp.generated.resources.Res
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

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 24.dp, bottom = 24.dp),
            text = "Pokedex KMP",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary
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
            modifier = Modifier.padding(top = 100.dp, bottom = 24.dp, end = 10.dp, start = 10.dp)
        )
        Button(onClick = onSeePokedexClick, modifier = Modifier.padding(top = 40.dp)) {
            Text("Ver Pokedex")
        }
    }
}