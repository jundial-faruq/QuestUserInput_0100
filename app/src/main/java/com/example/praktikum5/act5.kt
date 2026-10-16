package com.example.praktikum5

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.layout.ParentDataModifier

@Composable
fun FromDataDiri(modifier: Modifier){
    //variable-variabel untuk mengingat nilai masukan dai keyboard
    var textNama by remember{mutableStateOf(value = "")}
    var textAlamat by remember{mutableStateOf(value = "")}
    var textJK by remember{mutableStateOf(value = "")}

    //variabel-variabel untuk menyimpan data yang diperoleh dari  komponen UI
    var nama by remember{mutableStateOf(value = "")}
    var alamat by remember{mutableStateOf(value = "")}
    var jenis by remember{mutableStateOf(value = "")}
    var gender:List<String> = listOf("Laki-laki", "Perempiuan")

}
