package com.example.project_app_1

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.project_app_1.Data.pemain
import com.example.project_app_1.Model.identitasPemain

@Composable
fun DetailFiles(
    modifier: Modifier = Modifier,
    navController: NavController,
    pemainId: Int?
) {
    val pemainList = pemain.dataPemain.filter { pemains ->
        pemains.id == pemainId
    }
    Column(
        modifier = modifier
    ) {
        DetailPemainFile(pemainList = pemainList)
    }
}

@Composable
fun DetailPemainFile(
    pemainList: List<identitasPemain>,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(data = pemainList[0].photo)
                .build(),
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(height = 250.dp, width = 170.dp),
            contentDescription = "data pemain"
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.padding(4.dp)) {
            Text(
                onTextLayout = {},
                text = pemainList[0].name,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold)

        }
    }
}