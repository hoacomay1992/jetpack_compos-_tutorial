package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmc.com.jpackcomponentcomposetutorial.R
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme
import coil.compose.rememberAsyncImagePainter

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Column(modifier = Modifier.padding(20.dp)) {
        BannerCompose(ContentScale.Crop)
        Spacer(modifier = Modifier.height(12.dp))
        CircleAvatar()
        Spacer(modifier = Modifier.height(12.dp))
        UrlImageCompose()

    }
}

@Composable
fun BannerCompose(contentScale: ContentScale) {
    Image(
        painter = painterResource(id = R.drawable.banner),
        contentDescription = null,
        contentScale = contentScale,
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = 8.dp)
            )
            .aspectRatio(3.0f),
        alignment = Alignment.Center
    )
}

@Composable
fun VectorImageCompose() {
    Image(imageVector = Icons.Filled.Person, contentDescription = null)
}

@Composable
fun UrlImageCompose() {
    Image(
        rememberAsyncImagePainter(
            model = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fhelpx.adobe.com%2Fphotoshop%2Fusing%2Fconvert-color-image-black-white.html&psig=AOvVaw0VbAimU09Bhg_Vy5mNZi79&ust=1703305563260000&source=images&cd=vfe&ved=0CBEQjRxqFwoTCPih_uqZooMDFQAAAAAdAAAAABAE",
            placeholder = painterResource(id = R.drawable.hotgirt)
        ),
        contentDescription = null
    )
}

@Composable
fun CircleAvatar() {
    Image(
        painter = painterResource(id = R.drawable.hotgirt),
        contentDescription = null,
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .border(width = 1.dp, MaterialTheme.colorScheme.secondary, shape = CircleShape)

    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JpackComponentComposeTutorialTheme {
        HomeScreen()
    }
}