package com.ashwani.composesample.screens.profile

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.ashwani.composesample.R
import com.ashwani.composesample.common.AppNavConstants

@Composable
fun ProfileScreen(navController: NavHostController) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val galleryLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }
    Column(
        Modifier
            .padding(20.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.h5
        )
        Text(
            modifier = Modifier.padding(top = 20.dp),
            text = stringResource(R.string.subtitle),
            style = MaterialTheme.typography.subtitle1
        )
        Text(
            text = stringResource(R.string.message),
            style = MaterialTheme.typography.body1
        )
        Column(modifier = Modifier.weight(1f)) {
            Button(onClick = {
                galleryLauncher.launch("image/*")
            }) {
                Text(text = "Load Image")
            }
            Image(
                painter = rememberAsyncImagePainter(imageUri),
                contentDescription = "My Image",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Fit
            )
        }

        Button(onClick = {
            navController.navigate(AppNavConstants.CONVERSATION_SCREEN)
        }, Modifier.fillMaxWidth()) {
            Text(text = stringResource(R.string.conversation))
        }
    }
}

