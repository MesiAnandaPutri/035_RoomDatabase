package com.example.myroom1_035.view.unicontroller
// PETA NAVIGASI

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myroom1_035.view.DetailSiswaScreen
import com.example.myroom1_035.view.EditSiswaScreen
import com.example.myroom1_035.view.route.DestinasiEntry
import com.example.myroom1_035.view.route.DestinasiHome
import com.example.myroom1_035.view.EntrySiswaScreen
import com.example.myroom1_035.view.HomeScreen
import com.example.myroom1_035.view.route.DestinasiDetailSiswa
import com.example.myroom1_035.view.route.DestinasiDetailSiswa.itemIdArg
import com.example.myroom1_035.view.route.DestinasiEditSiswa


@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier = Modifier){
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(navController=navController, startDestination = DestinasiHome.route
        , modifier = Modifier)
    {
        composable(DestinasiHome.route){
            HomeScreen(
                navigateToItemEntry = {navController.navigate(DestinasiEntry.route)},
                onDetailClick = { itemId ->
                    navController.navigate("${DestinasiDetailSiswa.route}/$itemId")
                }
            )
        }
        composable(DestinasiEntry.route){
            EntrySiswaScreen(navigateBack = { navController.popBackStack()})
        }

        composable(route = DestinasiDetailSiswa.routeWithArgs,
            arguments = listOf(navArgument(itemIdArg){
                type = NavType.IntType
            })
        ){
            DetailSiswaScreen(
                navigateToEditItem = {navController.navigate("${DestinasiEditSiswa.route}/$it")},
                navigateBack = { navController.navigateUp() })
        }
        composable(route = DestinasiEditSiswa.routeWithArgs,
            arguments = listOf(navArgument(DestinasiEditSiswa.itemIdArg){
                type = NavType.IntType
            })){
            EditSiswaScreen(
                navigateBack = {navController.popBackStack()},
                onNavigateUp = { navController.navigateUp() })
        }
    }
}