package com.example.zenith_fitnesstrack.views

import java.time.DayOfWeek

data class WeeklyWorkouts(
    val maxworkout: Int, // Max weekly workouts
    val workoutByDay: List<WorkoutData>
)

data class WorkoutData(
    val dayOfWeek: String, // Monday, Tue, etc..
    val workoutCount: Int
)


