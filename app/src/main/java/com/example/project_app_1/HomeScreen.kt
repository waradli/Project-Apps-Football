package com.example.project_app_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.project_app_1.Componen.clubItem
import com.example.project_app_1.Componen.pemainItem
import com.example.project_app_1.Data.pemain
import com.example.project_app_1.Model.identitasClub
import com.example.project_app_1.Model.identitasPemain
import com.example.project_app_1.Navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    pemain1: List<identitasPemain> = pemain.dataPemain,
    Club1: List<identitasClub> = pemain.dataClub,
) {
    Scaffold (
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(text = "Aplikasi Club Sepak Bola",onTextLayout = {}
                    )
                }
            )

        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                OutlinedTextField(
                    value = "",
                    onValueChange = { /* Change listener for search query */ },
                    label = { Text("Cari klub sepak bola", onTextLayout = {} ) },
                    leadingIcon = {
                        Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                    },
                    modifier = Modifier.fillMaxWidth()
                )
                Box(modifier = Modifier.padding(top = 80.dp)) {
                    Text(
                        text = "Daftar Pemain",
                        fontWeight = FontWeight.Bold,
                        onTextLayout = {}
                    )
                }

                Box (
                    modifier = Modifier.padding(top = 100.dp)
                ){
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = modifier
                    ) {
                        item {
                            LazyRow(
                                contentPadding = PaddingValues(16.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                modifier = modifier
                            ) {
                                items(pemain1, key = { it.id }) {
                                    pemainItem(
                                        pemainRow = it,
                                        onItemClicked = { pemainId -> navController.navigate(Screen.Detail.Route + "/$pemainId") })

                                }
                            }
                        }

                        items(Club1, key = { it.id }) {
                            clubItem(clubColumn = it, modifier = Modifier.padding(horizontal = 16.dp))
                        }
                    }
                }

            }

        }

    }
}