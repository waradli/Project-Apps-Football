package com.example.project_app_1.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.project_app_1.AboutScreen

import com.example.project_app_1.DetailFiles
import com.example.project_app_1.DetailScreen
import com.example.project_app_1.HomeScreen
import com.example.project_app_1.R

@Composable
fun Nav(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val context = LocalContext.current
    Scaffold (

        bottomBar = {
            BottomBar(navController)
        },
        modifier = modifier
    ){
            contentPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.Route,
            modifier = modifier.padding(contentPadding)
        ) {
            composable(Screen.Home.Route) {
                HomeScreen(navController)
            }

            composable(Screen.Detail.Route) {
                DetailScreen()
            }

            composable(Screen.About.Route) {
                AboutScreen(  )
            }

            composable(
                Screen.Detail.Route + "/{pemainId}",
                arguments = listOf(navArgument("pemainId") { type = NavType.IntType })
            ) { navBackStackEntry ->
                DetailFiles(
                    navController = navController,
                    pemainId = navBackStackEntry.arguments?.getInt("pemainId")
                )
            }
        }
    }

    }


@Composable
fun BottomBar(navController: NavHostController,
              modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.HomeScreen),
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = stringResource(id = R.string.DetailScreen),
                icon = Icons.Default.Info,
                screen = Screen.Detail
            ),
            NavigationItem(
                title = stringResource(id = R.string.AboutScreen),
                icon = Icons.Default.AccountCircle,
                screen = Screen.About
            )
        )
        navigationItems.map { item ->
            NavigationBarItem(
                selected = currentRoute == item.screen.Route,
                onClick = {
                    navController.navigate(item.screen.Route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                },
                icon = { Icon(imageVector = item.icon, contentDescription = item.title) },
                label = { Text(text = item.title, onTextLayout = { textLayoutResult ->

                }) }
            )
        }
    }
}