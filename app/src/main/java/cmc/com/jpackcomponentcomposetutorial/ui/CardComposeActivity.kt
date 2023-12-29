package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme


class CardComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    CardHomeCompose()
                }
            }
        }
    }
}

@Composable
fun CardHomeCompose() {
    Scaffold() {
        Column(modifier = Modifier.padding(it)) {
            //FilledCard()
            //ElevatedCard()
            OutlinedCard()
        }
    }
}

@Composable
fun FilledCard() {
    Card(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Filled Card",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ElevatedCard() {
    androidx.compose.material3.ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(text = "Elevated Card", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
    }
}

@Composable
fun OutlinedCard() {
    androidx.compose.material3.OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, color = Color.Black),
        modifier = Modifier.size(width = 240.dp, height = 100.dp)
    ) {
        Text(text = "Outlined Card", modifier = Modifier.padding(16.dp), textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true)
@Composable
fun CardComposePreview() {
    CardHomeCompose()
}