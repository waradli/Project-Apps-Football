package com.example.project_app_1.Componen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project_app_1.Model.klasifikasiClub

@Composable
fun peringkatItem(
    Peringkat: klasifikasiClub,
    modifier: Modifier = Modifier,
) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)

    ){
        Card(shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(width = 150.dp, height = 180.dp),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 6.dp
            ),
        ) {
            Image(
                painter = painterResource(id = Peringkat.photo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(150.dp, 125.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            Text(text = Peringkat.name, fontSize = 18.sp, fontWeight = FontWeight.Bold,onTextLayout = {})
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Peringkat "+Peringkat.peringkat,onTextLayout = {})
        }


    }

}