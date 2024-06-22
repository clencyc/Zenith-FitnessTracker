package com.example.zenith_fitnesstrack.pages

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.zenith_fitnesstrack.R
import androidx.compose.material.CircularProgressIndicator
import com.google.android.material.progressindicator.CircularProgressIndicator

@Preview(showSystemUi = true, showBackground = true,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420",
    backgroundColor = 0xFFFFFFFF
)
@Composable
fun Progresspage(modifier: Modifier = Modifier
    .verticalScroll(rememberScrollState())

) {
    Column(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween, // Position elements with space between
            verticalAlignment = Alignment.CenterVertically// Align items vertically
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp, 40.dp)
                ,
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = stringResource(id = R.string.arrow))
            Text(
                modifier = Modifier
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
                ,
                text = "Progress",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Icon(
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .padding(10.dp), // Use padding instead of margin for better spacing within Row
                painter = painterResource(id = R.drawable.bell),
                contentDescription = stringResource(id = R.string.noteicon), // Use a descriptive content description
            )
        }

        Card (
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.Black)
        ) {
            //content

        }

        Card(
            modifier = Modifier
                .padding(top = 500.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
                .height(250.dp),
            shape = RoundedCornerShape(8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            border = BorderStroke(2.dp, Color.Black)
        ) { // Wrap content within Card
            Column(modifier = Modifier.padding(16.dp)) {
                Text(
                    text = "Daily Intake",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(16.dp) // Add padding within the Card
                )
                val daysOfWeek = listOf("Carbs", "Proteins", "Vegetable")
                daysOfWeek.forEach { day ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp), // Add vertical spacing between rows
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = day,
                            modifier = Modifier
                                .weight(1f) // Occupy available space before the progress bar

                        )
                        Box(contentAlignment = Alignment.Center) {
                            CircularProgressIndicator(
                                progress = getProgressForDay(day),
                                modifier = Modifier.size(40.dp),
                                strokeWidth = 4.dp
                            )
                            // Text to display percentage
                            Text(
                                text = "${(getProgressForDay(day) * 100).toInt()}%",
                                color = Color.Black,
                            )
                        }
                    }
                }
            }

        }
    }

}

fun getProgressForDay(day: String): Float {
    return when (day) {
        "Carbs" -> 0.7f
        "Proteins" -> 0.3f
        "Vegetable" -> 0.9f
        else -> 0f
    }
}
