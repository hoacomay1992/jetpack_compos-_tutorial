package cmc.com.jpackcomponentcomposetutorial.ui

import android.graphics.drawable.Icon
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ChipElevation
import androidx.compose.material3.ElevatedAssistChip
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme

class ChipComposeActivity : ComponentActivity() {
    @ExperimentalMaterial3Api
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ChipHomeCompose()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun ChipHomeCompose() {

    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            AssistChipCompose()
            // FilterChipCompose()
            // InputChipCompose(text = "Input Chip") {}
            // SuggestionChipCompose()
            // ElevatedChipCompose()
        }
    }
}

/**
 * Hướng dẫn người dùng trong khi thực hiện một nhiệm vụ.
 * Thường xuất hiện dưới dạng thành phần UI tạm thời để phản hồi thông tin đầu vào của người dùng.
 */
@Composable
fun AssistChipCompose() {
    AssistChip(
        onClick = { },
        label = { Text(text = "Assist Chip") },
        leadingIcon = {
            Icon(
                Icons.Filled.Settings,
                modifier = Modifier.size(AssistChipDefaults.IconSize),
                contentDescription = "Localized description"
            )
        })
}

/**
 * Thành phần kết hợp FilterChip yêu cầu bạn theo dõi xem chip có được chọn hay không.
 * Ví dụ sau đây minh họa cách bạn chỉ có thể hiển thị biểu tượng được đánh dấu ở đầu khi người dùng đã chọn khối:
 */
@ExperimentalMaterial3Api
@Composable
fun FilterChipCompose() {
    var selected by remember { mutableStateOf(false) }
    FilterChip(
        selected = selected,
        onClick = {
            selected = !selected
        },
        label = { Text(text = "Fillter Chip") },
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done Icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        })
}

/**
 * Bạn có thể sử dụng  inputChip composable
 * để tạo các chip nhờ sự tương tác của người dùng.
 * Ví dụ: trong ứng dụng email, khi người dùng viết email, input chip có thể đại diện
 * cho một người có địa chỉ mà người dùng đã nhập vào trường "to:".
 */
@ExperimentalMaterial3Api
@Composable
fun InputChipCompose(text: String, onDismiss: () -> Unit) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return
    InputChip(
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        label = { Text(text = text) },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Icon Close",
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        })
}

/**
 * SuggestionChip compose là compose cơ bản nhất được liệt kê
 * trên trang này, cả trong định nghĩa API và các trường hợp sử dụng phổ biến.
 * SuggestionChip trình bày các gợi ý được tạo động. Ví dụ: trong ứng dụng trò chuyện AI,
 * bạn có thể sử dụng khối gợi ý để đưa ra các câu trả lời có thể có cho tin
 * nhắn gần đây nhất.
 */
@Composable
fun SuggestionChipCompose() {
    SuggestionChip(
        onClick = { Log.d("TAG", "Suggestion Chip, Hello world") },
        label = { Text(text = "Suggestion Chip") })
}

/**
 * Tất cả các ví dụ trong tài liệu này đều sử dụng các thành phần kết hợp cơ sở có dạng phẳng.
 * Nếu bạn muốn một con chip có vẻ ngoài sang trọng, hãy sử dụng một trong ba thành phần kết
 * hợp sau:
 */
@Composable
fun ElevatedChipCompose() {
    ElevatedAssistChip(
        onClick = { /*TODO*/ },
        label = { Text(text = "Elevated Chip") },
        elevation = AssistChipDefaults.elevatedAssistChipElevation(8.dp)
    )
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ChipComposePreview() {
    ChipHomeCompose()
}