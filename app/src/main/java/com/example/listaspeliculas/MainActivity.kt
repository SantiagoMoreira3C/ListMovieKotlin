package com.example.listaspeliculas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.listaspeliculas.ui.theme.ListasPeliculasTheme
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

class Pelicula(val nombrepeli: String,val fechaestreno:String,val taquilla:Int, val imagen: Int)


val peliculaList = listOf(
    Pelicula("Avatar",  "16 Diciembre 2022" , 1400000,R.drawable.avatar),
    Pelicula("Mario bros",  "5 de Abril 2023",10000000, R.drawable.mariobros),
    Pelicula("Guardianes de la Galaxia Vol 3","5 de Mayo 2023", 500000,R.drawable.guardianes),
    Pelicula("Spiderman Multiverso","2 de Junio 2023",300000, R.drawable.spiderman),

)



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PeliculaList(peliculaList)
            }
        }
    }
}
@Composable
fun PeliculaList(peliculas: List<Pelicula>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(peliculas) { pelicula ->
            PeliculaCard(pelicula)
        }
    }
}




@Composable
fun PeliculaCard(pelicula: Pelicula) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ) {
            Image(
                painter = painterResource(pelicula.imagen),
                contentDescription = null,
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop,
            )
            Text(
                text = pelicula.nombrepeli,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )
            Text(
                text = "Price: $${pelicula.taquilla.toString()}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(8.dp),
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = pelicula.fechaestreno,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp),
                color = Color.White
            )
        }
    }
}
