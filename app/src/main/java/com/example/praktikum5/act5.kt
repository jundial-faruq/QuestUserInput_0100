
package com.example.praktikum5

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.lifecycle.DEFAULT_ARGS_KEY

@Composable
fun FromDataDiri(modifier: Modifier = Modifier) {

    // Variabel untuk input dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    // Variabel untuk menyimpan data
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender: List<String> = listOf("Laki-laki", "Perempuan")

    Column(
        modifier = modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { textNama = it }
        )

        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Alamat") },
            onValueChange = { textAlamat = it }
        )

        Text(
            text = "Jenis Kelamin",
            modifier = Modifier.padding(top = 16.dp)
        )

        Row {
            gender.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = textJK == item,
                            role = Role.RadioButton,
                            onClick = { textJK = item }
                        )
                        .padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = { textJK = item }
                    )
                    Text(text = item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat  ,
            singleLine = true,
            modifier = Modifier.width(250.dp),
            label = { Text(text = "Alamat") },
            onValueChange = { textAlamat = it }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = androidx.compose.ui.graphics.Color.DarkGray
        )

        Button(
            modifier = Modifier.fillMaxWidth(),
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama = textNama
                jenis = textJK
                alamat = textAlamat
            }
        ) {
            Text(stringResource(id = R.string.submit))
        }
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(id = R.dimen.padding_medium),
                top = dimensionResource(id = R.dimen.padding_medium)
            ),
            thickness = dimensionResource(id = R.dimen.divider_tipis),
            color = androidx.compose.ui.graphics.Color.DarkGray
        )
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier
                .height(100.dp)
                .width(300.dp)
        ) {
            Column (modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),){
                Text(text = "Nama : "+nama, color = Color.White)
                Text(text = "Gender : "+jenis, color = Color.White)
                Text(text = "Alamat : "+alamat, color = Color.White)

                }
            }
        }
    }

