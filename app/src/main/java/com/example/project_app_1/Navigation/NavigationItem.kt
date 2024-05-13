package com.example.project_app_1.Navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class NavigationItem(
    val title:String,
    val icon:ImageVector,
    val screen:Screen,
)
