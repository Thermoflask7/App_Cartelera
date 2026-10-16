package zaragoza.mateo.cartelera

data class Pelicula(
    val id: Int,
    val titulo: String,
    val anio: Int,
    val duracion: Int,
    val genero: String,
    val director: String,
    val sinopsis: String,
    val imagen: Int
)

val peliculas = listOf(
    Pelicula(
        id = 1,
        titulo = "Raising arizona",
        anio = 1987,
        duracion = 94,
        genero = "comedia",
        director = "Joel Coen",
        sinopsis = "Un criminal recurrente y una policia desean tener un hijo mas que cualquier otra cosa, pero despues de descubrir su infertilidad deciden robar uno",
        imagen = R.drawable.raisingarizona
    ),
    Pelicula(
        id = 2,
        titulo = "Paprika",
        anio = 2006,
        duracion = 90,
        genero = "ciencia ficcion",
        director = "Satoshi Kon",
        sinopsis = "In the near future, a newly created device called the DC Mini allows users to view people's dreams. The head of the team working on this treatment, Dr. Atsuko Chiba, begins using the machine illegally to help psychiatric patients outside the research facility by assuming her dream world alter-ego, a detective named Paprika.",
        imagen = R.drawable.paprika
    ),
    Pelicula(
        id = 3,
        titulo = "Fear and loathing in Las Vegas",
        anio = 1998,
        duracion = 118,
        genero = "comedia negra",
        director = "Terry Gilliam",
        sinopsis = "Dos hombres en un convertible rojo atraviesan el desierto cerca de las vegas, el maletero una farmacia de narcoticos, en la mision de cubrir una carrera de motos en el desierto.",
        imagen = R.drawable.fear_and_loathing
    ),
    Pelicula(
        id = 4,
        titulo = "interstella5555",
        anio = 2003,
        duracion = 68,
        genero = "anime",
        director = "Leiji Matsumoto",
        sinopsis = "4 humanoides azules de un planeta lejano son secuestrados para ser el siguiente grupo musical estrella de la tierra, un  cadete espacial viaja para rescatarlos",
        imagen = R.drawable.intestella
    ),
    Pelicula(
        id = 5,
        titulo = "silence of the lambs",
        anio = 1991,
        duracion = 118,
        genero = "thriller",
        director = "Jonathan Demme",
        sinopsis = "Una agente del FBI en entrenamiento es recrutada para entrevistar al cannibal Hannibal Lecter con la esperanza de obtener alguna pista para capturar al asesino serial Buffalo Bill",
        imagen = R.drawable.silence_of_the_lambs
    ),
    Pelicula(
        id = 6,
        titulo = "The Thing",
        anio = 1982,
        duracion = 109,
        genero = "horror ciencia ficcion",
        director = "John Carpenter",
        sinopsis = "En la antartica un grupo de investigadores americanos se encuentran con una forma de vida alienigena que amenaza contra la humanidad",
        imagen = R.drawable.the_thing
    ),
    Pelicula(
        id = 7,
        titulo = "Wizard of Oz",
        anio = 1939,
        duracion = 102,
        genero = "Fantasia",
        director = "Victor Fleming",
        sinopsis = "Dorothy Gale vive en una grana en Kansas con su tio tia y su perro Toto, hasta que un gran tornado la lleva a una tierra colorida y desconocida",
        imagen = R.drawable.wizard_of_oz
    ),
    Pelicula(
        id = 8,
        titulo = "gato",
        anio = 2026,
        duracion = 999,
        genero = "horror",
        director = "gato",
        sinopsis = "jaja mira el gato",
        imagen = R.drawable.gato
    ),
)