import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.zenith_fitnesstrack.views.WeeklyWorkouts
import com.example.zenith_fitnesstrack.views.WorkoutData

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WorkoutApp() { val weeklyWorkouts = remember {
    WeeklyWorkouts(
        maxworkout = 5,
        workoutByDay = listOf(
            WorkoutData("Mon", 3),
            WorkoutData("Tue", 2),
            WorkoutData("Wed", 4),
            WorkoutData("Thu", 1),
            WorkoutData("Fri", 5)
        )
    )
}
    Column {
        Text("Weekly Workout Chart")
        WorkoutLineChart(
            modifier = Modifier.height(200.dp), // Adjust height as needed
            weeklyWorkouts = weeklyWorkouts
        )
    }
}


@Composable
fun WorkoutLineChart(
    modifier: Modifier = Modifier,
    weeklyWorkouts: WeeklyWorkouts
) {
    if (weeklyWorkouts.workoutByDay.isEmpty()) return

    Canvas(modifier = modifier) {
        // Total number of days (data points)
        val totalDays = weeklyWorkouts.workoutByDay.size

        // Maximumdistance between dots (days)
        val lineDistance = size.width / (totalDays + 1)

        // Canvas height
        val cHeight = size.height

        // Add padding for the initial point
        var currentLineDistance = 0F + lineDistance

        weeklyWorkouts.workoutByDay.forEachIndexed { index, workoutData ->
            if (totalDays >= index + 2) {
                drawLine(
                    start = Offset(
                        x = currentLineDistance,
                        y = calculateYCoordinate(
                            higherWorkoutCount = weeklyWorkouts.maxworkout.toDouble(),
                            currentWorkoutCount = workoutData.workoutCount.toDouble(),
                            canvasHeight = cHeight
                        )
                    ),
                    end = Offset(
                        x = currentLineDistance + lineDistance,
                        y = calculateYCoordinate(
                            higherWorkoutCount = weeklyWorkouts.maxworkout.toDouble(),
                            currentWorkoutCount = weeklyWorkouts.workoutByDay[index + 1].workoutCount.toDouble(),
                            canvasHeight = cHeight
                        )
                    ),
                    color = Color(40, 193, 218),
                    strokeWidth = Stroke.DefaultMiter
                )
            }
            currentLineDistance += lineDistance
        }
    }
}

// Helper function to calculate Y coordinate based on workout count
private fun calculateYCoordinate(
    higherWorkoutCount: Double,
    currentWorkoutCount: Double,
    canvasHeight: Float
): Float {
    val normalizedValue = (currentWorkoutCount / higherWorkoutCount).toFloat() // Convert before division
    return canvasHeight - (normalizedValue * canvasHeight)
}