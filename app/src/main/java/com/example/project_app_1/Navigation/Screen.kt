package com.example.project_app_1.Navigation

sealed class Screen(
    val Route : String,
) {
   data object Home:Screen("HomeScreen")
    data object Detail:Screen("DetailScreen")
    data object About:Screen("AboutScreen")
    data object fixDetail:Screen("fixDetailScreen")
}