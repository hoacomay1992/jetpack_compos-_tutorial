package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme

/**
 * AppBar là nơi chứa cung cấp cho người dùng quyền truy cập
 * vào các tính năng chính và navigation item.
 * Có hai loại AppBar, thanh TopAppBar cùng và BottomAppBar.
 * Sự xuất hiện và mục đích tương ứng của chúng như sau:
 */
class AppBarComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    HomeAppBarCompose()
                }
            }
        }
    }
}

@Composable
fun HomeAppBarCompose() {
    TopAppBarCompose()
}

/**
 * Cung cấp quyền truy cập vào các nhiệm vụ và thông tin chính.
 * Thường lưu trữ tiêu đề, mục hành động cốt lõi và các mục điều hướng nhất định.
 */
@Composable
fun TopAppBarCompose() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(text = "Bottom App Bar")
            }
        },
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "AppBar")
        }
    }
}

/**
 * Thường bao gồm các mục điều hướng cốt lõi. Cũng có thể cung cấp
 * quyền truy cập vào các hành động chính khác, chẳng hạn như thông qua
 * FloatActionButton có sẵn.
 */
@Composable
fun BottomAppBarCompose() {
}

@Preview(showBackground = true)
@Composable
fun AppBarComposePreview() {
    HomeAppBarCompose()
}