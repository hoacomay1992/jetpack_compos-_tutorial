package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ProgressIndicatorComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ProgressIndicatorsHomeCompose()
                }
            }
        }
    }
}

@Composable
fun ProgressIndicatorsHomeCompose() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            // LinearDeterminateIndicator()
            IndeterminateCircularIndicator()
        }
    }
}

@Composable
fun IndeterminateCircularIndicator() {
    var loading by remember {
        mutableStateOf(false)
    }
    Button(
        onClick = { loading = true }, enabled = !loading
    ) {
        Text(text = "Start Loading")
    }
    if (!loading) return
    CircularProgressIndicator(
        modifier = Modifier.width(64.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.surfaceVariant,
    )
}

@Composable
fun LinearDeterminateIndicator() {
    var currentProgress by remember { mutableFloatStateOf(0f) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
    ) {
        Button(
            onClick = {
                loading = true
                scope.launch {
                    loadProgress { progress -> currentProgress = progress }
                    loading = false
                }

            }, enabled = !loading
        ) {
            Text(text = "Start Loading")
        }
        if (loading) {
            LinearProgressIndicator(
                progress = currentProgress, modifier = Modifier.fillMaxWidth()
            )
//            CircularProgressIndicator(
//                progress = currentProgress,
//                modifier = Modifier.size(width = 100.dp, height = 100.dp)
//            )
        }
    }
}

suspend fun loadProgress(updateProgress: (Float) -> Unit) {
    for (i in 1..100) {
        updateProgress(i.toFloat() / 100)
        delay(100)
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressIndicatorPreview() {
    ProgressIndicatorsHomeCompose()
}