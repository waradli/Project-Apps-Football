package com.example.project_app_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen() {
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
              title = { },

                )

        }
    ){innerPadding ->
        Column (
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.width(8.dp))
            Profile()
            textdesain(
                text = "Ali Wardana",
                icon = Icons.Default.Person,
                textColor = MaterialTheme.colorScheme.onBackground,
                iconAlignment = Alignment.Start
            )
            textdesain(
                text = "wardali269@gmail.com",
                icon = Icons.Default.Email,
                textColor = MaterialTheme.colorScheme.onBackground,
                iconAlignment = Alignment.Start
            )
            textdesain(
                text = "Universitas 17 Agustus 1945 Surabaya",
                icon = Icons.Default.Place,
                textColor = MaterialTheme.colorScheme.onBackground,
                iconAlignment = Alignment.Start
            )
            textdesain(
                text = "Teknik Informatika",
                icon = Icons.Default.AccountBox,
                textColor = MaterialTheme.colorScheme.onBackground,
                iconAlignment = Alignment.Start
            )
        }

    }
}

@Composable
fun Profile() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.bb),
            contentDescription = "foto",
            modifier = Modifier.size(140.dp)
        )
    }
}

@Composable
fun textdesain(
    text: String,
    icon: ImageVector,
    textColor: Color,
    iconAlignment: Alignment.Horizontal
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onBackground,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            color = textColor,
            fontFamily = FontFamily.SansSerif,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Start,
            onTextLayout = {}
        )
    }
}