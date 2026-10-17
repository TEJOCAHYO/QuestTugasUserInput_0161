package com.example.questtugasuserinput_0161

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormDataDiri(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState()

    var skillAndroid by remember { mutableStateOf(false) }
    var skillUiUx by remember { mutableStateOf(false) }
    var skillWeb by remember { mutableStateOf(false) }

    var expandedExperience by remember { mutableStateOf(false) }
    val expList = listOf("Beginner (< 1 thn)", "Intermediate (1-3 thn)", "Expert (> 3 thn)")

    var submittedNamaDepan by remember { mutableStateOf("") }
    var submittedNamaBelakang by remember { mutableStateOf("") }
    var submittedEmail by remember { mutableStateOf("") }
    var submittedTglLahir by remember { mutableStateOf("") }
    var submittedExperience by remember { mutableStateOf("") }
    var submittedSkills by remember { mutableStateOf("") }

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = {
                        datePickerState.selectedDateMillis?.let { millis ->
                            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                            tglLahir = sdf.format(Date(millis))
                        }
                        showDatePicker = false
                    }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.badut),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.header_height)),
                contentScale = ContentScale.Crop
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(top = dimensionResource(R.dimen.content_top_padding)),
                shape = MaterialTheme.shapes.large.copy(
                    topStart = CornerSize(dimensionResource(R.dimen.corner_radius_large)),
                    topEnd = CornerSize(dimensionResource(R.dimen.corner_radius_large)),
                    bottomStart = CornerSize(dimensionResource(R.dimen.padding_small)),
                    bottomEnd = CornerSize(dimensionResource(R.dimen.padding_small))
                ),
                color = MaterialTheme.colorScheme.surface,
                tonalElevation = dimensionResource(R.dimen.card_elevation)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(dimensionResource(R.dimen.padding_large)),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(R.string.title_form),
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.purple_header)
                    )

                    Text(
                        text = stringResource(R.string.subtitle_form),
                        style = MaterialTheme.typography.bodySmall,
                        color = colorResource(R.color.text_dark),
                        modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_small))
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            label = { Text(stringResource(R.string.label_nama_depan)) },
                            singleLine = true,
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier.weight(1f)
                        )
                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            label = { Text(stringResource(R.string.label_nama_belakang)) },
                            singleLine = true,
                            shape = MaterialTheme.shapes.medium,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    }