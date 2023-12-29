package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cmc.com.jpackcomponentcomposetutorial.ui.ui.theme.JpackComponentComposeTutorialTheme

/**
 * Switch Compose cho phép người dùng chuyển đổi giữa hai trạng thái:
 *  checked và unchecked. Trong ứng dụng của mình,
 *  bạn có thể sử dụng switch để cho phép người dùng thực hiện một
 *  trong những thao tác sau:
 *
 * Bật hoặc tắt một cài đặt.
 * Bật hoặc tắt một tính năng.
 * Chọn một tùy chọn.
 * Thành phần này có hai phần: thumb và track.
 *  thumb là phần có thể kéo của switch và track là background.
 *  Người dùng có thể kéo thumb sang trái hoặc phải để thay đổi trạng
 *  thái của switch. Họ cũng có thể tab vào switch để check và clern nó.
 */
class SwitchComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SwitchHomeCompose()
                }
            }
        }
    }
}

@Composable
fun SwitchHomeCompose() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            //SwitchMinimalExample()
            //SwitchWithIconExample()
            SwitchWithCustomColors()
        }
    }
}

@Composable
fun SwitchMinimalExample() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(checked = checked, onCheckedChange = { checked = it })
}

@Composable
fun SwitchWithIconExample() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(checked = checked, onCheckedChange = { checked = it }, thumbContent = {
        if (checked) {
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = null,
                modifier = Modifier.size(SwitchDefaults.IconSize)
            )
        } else {
            null
        }
    })
}

@Composable
fun SwitchWithCustomColors() {
    var checked by remember {
        mutableStateOf(false)
    }
    Switch(
        checked = checked,
        onCheckedChange = { checked = it },
        colors = SwitchDefaults.colors(
            checkedThumbColor = MaterialTheme.colorScheme.primary,
            checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
            uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
            uncheckedTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SwitchComposePreview() {
    JpackComponentComposeTutorialTheme {
        SwitchHomeCompose()
    }
}