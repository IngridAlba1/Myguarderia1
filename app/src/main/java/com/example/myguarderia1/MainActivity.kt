package com.example.ejercicio2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetDaycareApp()
        }
    }
}

@Composable
fun PetDaycareApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("register_pet") { RegisterPetScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Bienvenido a la Guardería de Mascotas Oreo y Zoe", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = { navController.navigate("register_pet") }) {
            Text("Registrar Nueva Mascota")
        }
    }
}

@Composable
fun RegisterPetScreen(navController: NavController) {
    var petName by remember { mutableStateOf("") }
    var petType by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Registrar Nueva Mascota", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = petName,
            onValueChange = { petName = it },
            label = { Text("Nombre de la Mascota") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = petType,
            onValueChange = { petType = it },
            label = { Text("Tipo de Mascota (Perro, Gato, etc.)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Aquí puedes agregar la lógica para guardar la mascota
            // Luego, navega de regreso a la pantalla de inicio
            navController.popBackStack()
        }) {
            Text("Guardar")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}

@Preview(showBackground = true)
@Composable
fun RegisterPetScreenPreview() {
    RegisterPetScreen(navController = rememberNavController())
}
