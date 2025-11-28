package com.example.myroom1_035.view.unicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myroom1_035.view.EntrySiswaScreen
import com.example.myroom1_035.view.HomeScreen
import com.example.myroom1_035.view.route.DestinasiEntry
import com.example.myroom1_035.view.route.DestinasiHome

@Composable
fun SiswaApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
){
    HostNavigasi(navController = navController, modifier = modifier)
}
