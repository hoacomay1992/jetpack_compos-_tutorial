package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cmc.com.jpackcomponentcomposetutorial.ui.theme.JpackComponentComposeTutorialTheme
import kotlinx.coroutines.launch

/**
 * Navigation Drawer compose là một menu trượt cho phép người dùng điều hướng đến
 * các phần khác nhau trong ứng dụng của bạn. Người dùng có thể kích hoạt nó
 * bằng cách vuốt từ bên cạnh hoặc nhấn vào biểu tượng menu.
 *
 *
 * Hãy xem xét ba trường hợp sử dụng sau để triển khai Ngăn Điều hướng:
 *
 * Content Organization: Cho phép người dùng chuyển đổi giữa các danh mục (categories) khác nhau,
 *                       chẳng hạn như trong ứng dụng tin tức hoặc blog.
 * Account Management: Cung cấp liên kết nhanh (quick link) đến Setting Account và
 *                     phần hồ sơ (profile section) trong ứng dụng có tài khoản người dùng.
 * Feature Discovery: Sắp xếp nhiều tính năng và Settings trong một menu duy nhất để hỗ trợ
 *                    người dùng khám phá và truy cập trong các ứng dụng phức tạp.
 *
 * Trong Material Design, có hai loại Navigation Drawer:
 *
 * Standard: Chia sẻ không gian trong màn hình với nội dung khác.
 * Modal: Xuất hiện phía trên cùng của nội dung khác trong màn hình.
 */
class NavigationDrawerComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    NavigationDrawerHomeCompose()
                }
            }
        }
    }
}

@Composable
fun NavigationDrawerHomeCompose() {
    ControlBehaviorNavigationDrawer()
}

@Composable
fun NavigationDrawerComponent() {
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        },
        gesturesEnabled = true
    ) {
        // Screen content
    }
}

@Composable
fun ControlBehaviorNavigationDrawer() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Drawer title", modifier = Modifier.padding(16.dp))
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Drawer Item") },
                    selected = false,
                    onClick = { /*TODO*/ }
                )
                // ...other drawer items
            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
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
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JpackComponentComposeTutorialTheme {
        NavigationDrawerHomeCompose()
    }
}