package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme


class ButtonComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ButtonHomeCompose()
                }
            }
        }
    }
}

@Composable
fun ButtonHomeCompose() {
    Column(modifier = Modifier.padding(5.dp)) {
        Row {
            FilledButtonCompose {
                Log.d("TAG", "Filled button click OK")
            }
            Spacer(modifier = Modifier.width(5.dp))
            FilledTonalButtonCompose {
                Log.d("TAG", "Filled tonal button click OK")
            }
            Spacer(modifier = Modifier.width(5.dp))
            OutlinedButtonCompose {

            }
        }
        Spacer(modifier = Modifier.width(20.dp))
        Row {
            ElevatedButtonCompose {

            }
            Spacer(modifier = Modifier.width(5.dp))
            TextButtonCompose {

            }
        }
    }

}

/**
 * Các Button có độ nhấn cao. Đây là những hành động chính trong ứng dụng,
 * chẳng hạn như "gửi" và "lưu". Hiệu ứng đổ bóng nhấn mạnh tầm quan trọng của nút.
 *
 * Background vững chắc với văn bản tương phản.
 */
@Composable
fun FilledButtonCompose(onClick: () -> Unit) {
    Button(onClick = onClick) {
        Text(text = "Filled")
    }
}

/**
 * Ngoài ra đối với các hành động chính hoặc quan trọng. Filld Button cung cấp
 * nhiều chức năng phù hợp và có trọng lượng trực quan hơn,
 * chẳng hạn như "thêm vào giỏ hàng" và "Đăng nhập".
 *
 * Background thay đổi để phù hợp với bề mặt (surface).
 */
@Composable
fun FilledTonalButtonCompose(onClick: () -> Unit) {
    FilledTonalButton(onClick = onClick) {
        Text(text = "Filled Tonal")
    }
}

/**
 * Phù hợp với vai trò tương tự như các tonal button. Tăng độ cao (elevated) để khiến nút xuất hiện
 * nổi bật hơn nữa.
 *
 * Nổi bật nhờ có bóng (Shadow)
 */
@Composable
fun ElevatedButtonCompose(onClick: () -> Unit) {
    ElevatedButton(onClick = onClick) {
        Text(text = "Elevated")
    }
}

/**
 * Các nút có mức độ nhấn mạnh trung bình, chứa các hành động quan trọng nhưng không phải
 * là hành động chính. Chúng kết hợp tốt với các nút khác để biểu thị các hành động phụ,
 * thay thế như "Hủy" hoặc "Quay lại".
 *
 * Có đường viền không có màu tô (no fill).
 */
@Composable
fun OutlinedButtonCompose(onClick: () -> Unit) {
    OutlinedButton(onClick = onClick) {
        Text(text = "Outlined")
    }
}


/**
 * Các nút nhấn mạnh thấp, lý tưởng cho các hành động ít quan trọng hơn như liên kết
 * điều hướng (navigation link) hoặc các chức năng phụ như "Learn more" hoặc "view detail".
 */
@Composable
fun TextButtonCompose(onClick: () -> Unit) {
    TextButton(onClick = onClick) {
        Text(text = "Text Button")

    }
}

@Preview(showBackground = true)
@Composable
fun ButtonComposePreview() {
    JpackComponentComposeTutorialTheme {
        ButtonHomeCompose()
    }
}