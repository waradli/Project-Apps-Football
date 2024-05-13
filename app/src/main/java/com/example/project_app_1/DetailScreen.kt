package com.example.project_app_1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.project_app_1.Componen.peringkatItem
import com.example.project_app_1.Data.pemain
import com.example.project_app_1.Model.klasifikasiClub


@Composable
fun DetailScreen
            (
    modifier: androidx.compose.ui.Modifier = Modifier,
    Peringkats: List<klasifikasiClub> = pemain.dataPeringkat
)


{
    LazyVerticalGrid(
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        columns = GridCells.Adaptive(140.dp),

    ) {
        items(Peringkats, key = { it.id }) {
            peringkatItem(Peringkat = it)
        }
    }
            }