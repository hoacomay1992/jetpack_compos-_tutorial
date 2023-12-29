package cmc.com.jpackcomponentcomposetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cmc.com.jpackcomponentcomposetutorial.ui.ui.theme.JpackComponentComposeTutorialTheme

/**
 * Slider Compose cho phép người dùng đưa ra lựa chọn từ nhiều giá trị.
 * Bạn có thể sử dụng Slider để cho phép người dùng thực hiện những việc sau:
 * Điều chỉnh cài đặt sử dụng nhiều giá trị, chẳng hạn như âm lượng và độ sáng (prightness).
 * Lọc dữ liệu trong biểu đồ, như khi đặt phạm vi giá.
 * User input, như đặt xếp hạng trong bài đánh giá.
 * The slider contains a track, thumb, value label, and tick marks:
 * Track: Rãnh là thanh ngang biểu thị phạm vi giá trị mà thanh trượt có thể nhận.
 * Thumb: Ngón tay cái là thành phần điều khiển có thể kéo trên thanh trượt,
 *    cho phép người dùng chọn một giá trị cụ thể trong phạm vi được xác định bởi bản nhạc.
 * Tick marks: Dấu kiểm là các điểm đánh dấu hoặc chỉ báo trực quan tùy chọn xuất hiện
 *    dọc theo rãnh của thanh trượt.
 */
class SliderComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JpackComponentComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SliderHomeCompose()
                }
            }
        }
    }
}

@Composable
fun SliderHomeCompose() {
    Scaffold {
        Column(modifier = Modifier.padding(it)) {
            //SliderMinimalExample()
            // SliderAdvancedExample()
            RangeSliderExample()
        }
    }
}

@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}

/**
 * colors: Một phiên bản của SliderColors cho phép bạn kiểm soát màu sắc của thanh trượt.
 * steps: Số lượng rãnh trên thanh trượt mà ngón tay cái chạm vào.
 * valueRange: Phạm vi giá trị mà thanh trượt có thể nhận.
 */
@Composable
fun SliderAdvancedExample() {
    var sliderPosition by remember {
        mutableFloatStateOf(0f)
    }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = {
                sliderPosition = it
            },
            colors = SliderDefaults.colors(
                thumbColor = MaterialTheme.colorScheme.secondary,
                activeTrackColor = MaterialTheme.colorScheme.secondary,
                inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
            ),
            steps = 3,
            valueRange = 0f..50f
        )
        Text(text = sliderPosition.toString())
    }
}

@Composable
fun RangeSliderExample() {
    var sliderPosition by remember { mutableStateOf(0f..100f) }
    Column {
        RangeSlider(
            value = sliderPosition,
            steps = 5,
            onValueChange = { range -> sliderPosition = range },
            valueRange = 0f..100f,
            onValueChangeFinished = {
                // launch some business logic update with the state you hold
                // viewModel.updateSelectedSliderValue(sliderPosition)
            },
        )
        Text(text = sliderPosition.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun SliderComposePreview() {
    JpackComponentComposeTutorialTheme {
        SliderHomeCompose()
    }
}