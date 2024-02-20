package com.example.manejodecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.example.manejodecard.ui.theme.data.DataSource
import com.example.manejodecard.ui.theme.model.Platillo
import com.example.manejodecard.ui.theme.ManejoDeCardTheme
import com.example.manejodecard.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ManejoDeCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Content
                    val platillos = DataSource().LoadPlatillos()
                    PlatilloList(platillos)

                }
            }
        }
    }
}

@Composable
fun PlatilloList(platillos: List<Platillo>) {
    Column(modifier = Modifier.padding(5.dp)) {
        platillos.forEach { platillo ->
            MenuCard(platillo = platillo, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Composable
fun MenuCard(platillo: Platillo, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(vertical = 6.dp)) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = platillo.drawableResourceId),
                contentDescription = stringResource(id = platillo.stringResourceId),
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(
                    text = stringResource(id = platillo.stringResourceId),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "$ ${platillo.precio}",
                    style = MaterialTheme.typography.bodyLarge
                )
                if (platillo.b) {
                    Text(
                        text = "Oferta %${platillo.d}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPlatilloPreview() {
    ManejoDeCardTheme{
        /*PlatilloList(platillos)
        platillos = DataSource().LoadPlatillos()

         */

        PlatilloList(
            listOf(

                Platillo(R.string.desayuno, R.drawable.desayuno, 10.0, true,80.00),
                Platillo(R.string.pozole, R.drawable.pozole, 5.0, false,120.00),
                Platillo(R.string.tacos, R.drawable.tacos, 5.0, true,25.00),
                Platillo(R.string.pizza, R.drawable.pizza, 20.0, true,350.00),
                Platillo(R.string.hamburger, R.drawable.hamburger, 15.0, true,150.00),
                Platillo(R.string.postre, R.drawable.postre, 5.0, false, 80.00),



            )
        )



    }
}
