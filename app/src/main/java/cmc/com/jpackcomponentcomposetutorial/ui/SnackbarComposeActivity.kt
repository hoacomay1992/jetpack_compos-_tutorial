package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cmc.com.jpackcomponentcomposetutorial.ui.ui.theme.JpackComponentComposeTutorialTheme
import kotlinx.coroutines.launch

/**
 * Snackbar compose đóng vai trò như một thông báo ngắn gọn xuất hiện ở cuối màn hình.
 * Nó cung cấp phản hồi về một thao tác hoặc hành động mà không làm gián đoạn trải nghiệm
 * của người dùng. Snackbars biến mất sau vài giây. Người dùng cũng có thể loại bỏ
 * chúng bằng một hành động, chẳng hạn như nhấn vào nút.
 *
 * Hãy xem xét ba trường hợp sử dụng sau khi bạn có thể sử dụng thanh thông tin nhanh:
 *
 * Action Confirmation: Sau khi người dùng xóa email hoặc tin nhắn,
 *                     thanh thông báo nhanh sẽ xuất hiện để xác nhận hành động và đưa ra tùy chọn
 *                     "Hoàn tác".
 * Network Status: Khi ứng dụng mất kết nối internet, một thanh thông báo nhanh sẽ
 *                  bật lên để thông báo rằng ứng dụng hiện đang ngoại tuyến.
 * Data Submission: Sau khi gửi thành công biểu mẫu hoặc cập nhật cài đặt,
 *              thanh thông báo nhanh sẽ lưu ý rằng thay đổi đã được lưu thành công.
 */
class SnackbarComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SnackbarHomeCompose()
                }
            }
        }
    }
}

@Composable
fun SnackbarHomeCompose() {
    //BasicSnackbarCompose()
    SnackbarWithActionCompose()
}

@Composable
fun BasicSnackbarCompose() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Star, contentDescription = "") },
                onClick = {
                    scope.launch {
                        snackbarHostState.showSnackbar("Snackbar")
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Composable
fun SnackbarWithActionCompose() {
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                text = { Text("Show snackbar") },
                icon = { Icon(Icons.Filled.Star, contentDescription = "") },
                onClick = {
                    scope.launch {
                        val result = snackbarHostState
                            .showSnackbar(
                                message = "Snackbar",
                                actionLabel = "Action",
                                // Defaults to SnackbarDuration.Short
                                duration = SnackbarDuration.Indefinite
                            )
                        when (result) {
                            SnackbarResult.ActionPerformed -> {
                                /* Handle snackbar action performed */
                            }

                            SnackbarResult.Dismissed -> {
                                /* Handle snackbar dismissed */
                            }
                        }
                    }
                }
            )
        }
    ) {
        Column(modifier = Modifier.padding(it)) {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun SnackBarComposePreview() {
    JpackComponentComposeTutorialTheme {
        SnackbarHomeCompose()
    }
}