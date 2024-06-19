package com.example.zenith_fitnesstrack.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showSystemUi = true, showBackground = true,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420"
)
@Composable
fun Homepage(modifier: Modifier = Modifier) {
    
    

//    Column(modifier = Modifier.padding(16.dp)) {
//        Text("Today's Activity", style = MaterialTheme.typography.h6)
//        Spacer(modifier = Modifier.height(16.dp))
//        Row(horizontalArrangement = Arrangement.SpaceAround) {
//            CircularProgressWithLabel(progress = 0.75f, label = "Steps", value = "8500", unit = "steps")
//            CircularProgressWithLabel(progress = 0.5f, label = "Calories", value = "1200", unit = "kcal")
//            CircularProgressWithLabel(progress = 0.8f, label = "Distance", value = "5.2", unit = "km")
//        }
//        // ... other sections of the screen
//    }

}


//@Composable
//fun CircularProgressWithLabel(progress: Float, label: String, value: String, unit: String) {
//    Column(horizontalAlignment = Alignment.CenterHorizontally) {
//        CircularProgressIndicator(
//            progress = progress,
//            modifier = Modifier.size(80.dp),
//            strokeWidth = 8.dp
//        )
//        Spacer(modifier = Modifier.height(8.dp))
//        Text(value, style = MaterialTheme.typography.h5)
//        Text("$label ($unit)", style = MaterialTheme.typography.body2)
//    }
//}
//
