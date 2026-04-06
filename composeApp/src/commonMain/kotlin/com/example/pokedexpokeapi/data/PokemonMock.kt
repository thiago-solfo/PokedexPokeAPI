package com.example.pokedexpokeapi.data

import isAndroid

object PokemonMock {

    private val pokedex = listOf(
        Pokemon(
            id = 1,
            name = "bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
            types = listOf("grass", "poison"),
            height = 7,
            weight = 69,
            stats = listOf(
                PokemonStat("hp", 45),
                PokemonStat("attack", 49),
                PokemonStat("defense", 49),
                PokemonStat("special-attack", 65),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 45)
            ),
            description = "Bulbasaur carrega uma semente em suas costas desde o nascimento."
        ),
        Pokemon(
            id = 4,
            name = "charmander",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/4.png",
            types = listOf("fire"),
            height = 6,
            weight = 85,
            stats = listOf(
                PokemonStat("hp", 39),
                PokemonStat("attack", 52),
                PokemonStat("defense", 43),
                PokemonStat("special-attack", 60),
                PokemonStat("special-defense", 50),
                PokemonStat("speed", 65)
            ),
            description = "Charmander possui uma chama na ponta da cauda que indica sua vitalidade."
        ),
        Pokemon(
            id = 7,
            name = "squirtle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/7.png",
            types = listOf("water"),
            height = 5,
            weight = 90,
            stats = listOf(
                PokemonStat("hp", 44),
                PokemonStat("attack", 48),
                PokemonStat("defense", 65),
                PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 64),
                PokemonStat("speed", 43)
            ),
            description = "Squirtle se protege com seu casco e lança jatos d’água."
        ),
        Pokemon(
            id = 25,
            name = "pikachu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/25.png",
            types = listOf("electric"),
            height = 4,
            weight = 60,
            stats = listOf(
                PokemonStat("hp", 35),
                PokemonStat("attack", 55),
                PokemonStat("defense", 40),
                PokemonStat("special-attack", 50),
                PokemonStat("special-defense", 50),
                PokemonStat("speed", 90)
            ),
            description = "Pikachu armazena eletricidade em suas bochechas."
        ),
        Pokemon(
            id = 39,
            name = "jigglypuff",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/39.png",
            types = listOf("normal", "fairy"),
            height = 5,
            weight = 55,
            stats = listOf(
                PokemonStat("hp", 115),
                PokemonStat("attack", 45),
                PokemonStat("defense", 20),
                PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 25),
                PokemonStat("speed", 20)
            ),
            description = "Jigglypuff encanta adversários com sua canção."
        ),
        Pokemon(
            id = 133,
            name = "eevee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/133.png",
            types = listOf("normal"),
            height = 3,
            weight = 65,
            stats = listOf(
                PokemonStat("hp", 55),
                PokemonStat("attack", 55),
                PokemonStat("defense", 50),
                PokemonStat("special-attack", 45),
                PokemonStat("special-defense", 65),
                PokemonStat("speed", 55)
            ),
            description = "Eevee possui uma estrutura genética instável e várias evoluções possíveis."
        ),
        Pokemon(
            id = 94,
            name = "gengar",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/94.png",
            types = listOf("ghost", "poison"),
            height = 15,
            weight = 405,
            stats = listOf(
                PokemonStat("hp", 60),
                PokemonStat("attack", 65),
                PokemonStat("defense", 60),
                PokemonStat("special-attack", 130),
                PokemonStat("special-defense", 75),
                PokemonStat("speed", 110)
            ),
            description = "Gengar se esconde nas sombras e gosta de pregar peças."
        ),
        Pokemon(
            id = 149,
            name = "dragonite",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/149.png",
            types = listOf("dragon", "flying"),
            height = 22,
            weight = 2100,
            stats = listOf(
                PokemonStat("hp", 91),
                PokemonStat("attack", 134),
                PokemonStat("defense", 95),
                PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100),
                PokemonStat("speed", 80)
            ),
            description = "Diz-se que Dragonite vive em algum lugar do oceano e salva náufragos."
        ),
        Pokemon(
            id = 150,
            name = "mewtwo",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/150.png",
            types = listOf("psychic"),
            height = 20,
            weight = 1220,
            stats = listOf(
                PokemonStat("hp", 106),
                PokemonStat("attack", 110),
                PokemonStat("defense", 90),
                PokemonStat("special-attack", 154),
                PokemonStat("special-defense", 90),
                PokemonStat("speed", 130)
            ),
            description = "Um Pokémon criado por manipulação genética. É um dos mais poderosos."
        ),
        Pokemon(
            id = 448,
            name = "lucario",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/448.png",
            types = listOf("fighting", "steel"),
            height = 12,
            weight = 540,
            stats = listOf(
                PokemonStat("hp", 70),
                PokemonStat("attack", 110),
                PokemonStat("defense", 70),
                PokemonStat("special-attack", 115),
                PokemonStat("special-defense", 70),
                PokemonStat("speed", 90)
            ),
            description = "Lucario pode ler as auras dos seres vivos para entender seus sentimentos."
        ),
        Pokemon(
            id = 6,
            name = "charizard",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/6.png",
            types = listOf("fire", "flying"),
            height = 17,
            weight = 905,
            stats = listOf(
                PokemonStat("hp", 78),
                PokemonStat("attack", 84),
                PokemonStat("defense", 78),
                PokemonStat("special-attack", 109),
                PokemonStat("special-defense", 85),
                PokemonStat("speed", 100)
            ),
            description = "Charizard voa à procura de oponentes poderosos e cospe fogo que derrete rochas."
        ),
        Pokemon(
            id = 151,
            name = "mew",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/151.png",
            types = listOf("psychic"),
            height = 4,
            weight = 40,
            stats = listOf(
                PokemonStat("hp", 100),
                PokemonStat("attack", 100),
                PokemonStat("defense", 100),
                PokemonStat("special-attack", 100),
                PokemonStat("special-defense", 100),
                PokemonStat("speed", 100)
            ),
            description = "Mew possui o mapa genético de todos os Pokémon. É capaz de ficar invisível."
        ),
        Pokemon(
            id = 249,
            name = "lugia",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/249.png",
            types = listOf("psychic", "flying"),
            height = 52,
            weight = 2160,
            stats = listOf(
                PokemonStat("hp", 106),
                PokemonStat("attack", 90),
                PokemonStat("defense", 130),
                PokemonStat("special-attack", 90),
                PokemonStat("special-defense", 154),
                PokemonStat("speed", 110)
            ),
            description = "Lugia é tão poderoso que diz-se que um leve bater de asas causa tempestades."
        ),
        Pokemon(
            id = 250,
            name = "ho-oh",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/250.png",
            types = listOf("fire", "flying"),
            height = 38,
            weight = 1990,
            stats = listOf(
                PokemonStat("hp", 106),
                PokemonStat("attack", 130),
                PokemonStat("defense", 90),
                PokemonStat("special-attack", 110),
                PokemonStat("special-defense", 154),
                PokemonStat("speed", 90)
            ),
            description = "As penas de Ho-Oh brilham em sete cores. Diz-se que quem o vê terá felicidade eterna."
        ),
        Pokemon(
            id = 384,
            name = "rayquaza",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/384.png",
            types = listOf("dragon", "flying"),
            height = 70,
            weight = 2065,
            stats = listOf(
                PokemonStat("hp", 105),
                PokemonStat("attack", 150),
                PokemonStat("defense", 90),
                PokemonStat("special-attack", 150),
                PokemonStat("special-defense", 90),
                PokemonStat("speed", 95)
            ),
            description = "Rayquaza vive na camada de ozônio e desce para mediar conflitos entre Groudon e Kyogre."
        ),
        Pokemon(
            id = 445,
            name = "garchomp",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/445.png",
            types = listOf("dragon", "ground"),
            height = 19,
            weight = 950,
            stats = listOf(
                PokemonStat("hp", 108),
                PokemonStat("attack", 130),
                PokemonStat("defense", 95),
                PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 85),
                PokemonStat("speed", 102)
            ),
            description = "Garchomp voa em velocidade sônica e suas escamas afiadas podem cortar oponentes."
        ),
        Pokemon(
            id = 493,
            name = "arceus",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/493.png",
            types = listOf("normal"),
            height = 32,
            weight = 3200,
            stats = listOf(
                PokemonStat("hp", 120),
                PokemonStat("attack", 120),
                PokemonStat("defense", 120),
                PokemonStat("special-attack", 120),
                PokemonStat("special-defense", 120),
                PokemonStat("speed", 120)
            ),
            description = "Diz a mitologia que Arceus emergiu de um ovo e criou todo o universo."
        ),
        Pokemon(
            id = 658,
            name = "greninja",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/658.png",
            types = listOf("water", "dark"),
            height = 15,
            weight = 400,
            stats = listOf(
                PokemonStat("hp", 72),
                PokemonStat("attack", 95),
                PokemonStat("defense", 67),
                PokemonStat("special-attack", 103),
                PokemonStat("special-defense", 71),
                PokemonStat("speed", 122)
            ),
            description = "Greninja move-se com a rapidez de um ninja e cria shurikens de água comprimida."
        ),
        Pokemon(
            id = 888,
            name = "zacian",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/888.png",
            types = listOf("fairy"),
            height = 28,
            weight = 1100,
            stats = listOf(
                PokemonStat("hp", 92),
                PokemonStat("attack", 130),
                PokemonStat("defense", 115),
                PokemonStat("special-attack", 80),
                PokemonStat("special-defense", 115),
                PokemonStat("speed", 138)
            ),
            description = "Zacian absorve metal para se transformar e é conhecido como o herói que salvou Galar."
        )
    )

    fun findById(id: Int): Pokemon? = getPokemonList().firstOrNull { it.id == id }
    fun getPokemonList(): List<Pokemon> = pokedex.filterIndexed {
        index, _ -> val resto = 1.takeIf { isAndroid() } ?: 0; return@filterIndexed index % 2 == resto;
    }
}