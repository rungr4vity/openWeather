package il.pacolo.com.appweather.navigation



import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable

import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu

import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import il.pacolo.com.appweather.R
import il.pacolo.com.appweather.data.ApiService
import il.pacolo.com.appweather.data.DataRepository
import il.pacolo.com.appweather.presentation.screens.WeatherScreen
import il.pacolo.com.appweather.presentation.viewmodels.HomeViewModel
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App() {

    val navController = rememberNavController()
    var expanded by remember { mutableStateOf(false) }

    val drawerItems = listOf(


        //Usuario
        Triple("Home", Icons.Default.Home, 2),
        Triple("My map", Icons.Default.Person, 2),
        Triple("General", Icons.Default.AddCircle, 2),
    )//.filter { it.third == userData.typeId }

    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text(text = "app Weather v1.0") },
                navigationIcon = {

                    IconButton(onClick = {
                        scope.launch {
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }

                }
            )
        },
        drawerContent = {

            DrawerContent(drawerItems, navController, closeDrawer = {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
            })
        },
        content = {
            NavHost(
                navController = navController as NavHostController,
                startDestination = "Home"
            ) {

                composable("Home") {

                    WeatherScreen()
                }


                composable(
                    "DetalleOficinas/{capacidad}/{descripcion}/{id}/{mobilaria}/{nombre}/{idArea}/{imageUrl}",
                    arguments = listOf(
                        navArgument("capacidad") { type = NavType.StringType },
                        navArgument("descripcion") { type = NavType.StringType },
                        navArgument("id") { type = NavType.StringType },
                        navArgument("mobilaria") { type = NavType.StringType },
                        navArgument("nombre") { type = NavType.StringType },
                        navArgument("idArea") { type = NavType.StringType },
                        navArgument("imageUrl") { type = NavType.StringType }
                    )
                ) {


                    //var viewModel = OficinasViewModel()
                    val capacidad = it.arguments?.getString("capacidad") ?: ""
                    val descripcion = it.arguments?.getString("descripcion") ?: ""
                    val id = it.arguments?.getString("id") ?: ""
                    val mobilaria = it.arguments?.getString("mobilaria") ?: ""
                    val nombre = it.arguments?.getString("nombre") ?: ""
                    val idArea = it.arguments?.getString("idArea") ?: ""
                    val imageUrl = it.arguments?.getString("imageUrl") ?: ""

//                    DetalleOficinas(
//                        navController = navController,
//                        LocalContext.current,
//                        capacidad,
//                        descripcion,
//                        id,
//                        mobilaria,
//                        nombre,
//                        idArea,
//                        imageUrl,
//                    )
                }


                composable("DetalleCajon/{nombre}/{company}/{cajon}/{piso}/{esEspecial}/{idEstacionamiento}/{imagen}",
                    arguments = listOf(
                        navArgument("nombre") { type = NavType.StringType },
                        navArgument("company") { type = NavType.StringType },
                        navArgument("cajon") { type = NavType.StringType },
                        navArgument("piso") { type = NavType.StringType },
                        navArgument("esEspecial") { type = NavType.BoolType },
                        navArgument("idEstacionamiento") { type = NavType.StringType },
                        navArgument("imagen") { type = NavType.StringType }
                    )) {

                    val nombre = it.arguments?.getString("nombre") ?: ""
                    val company = it.arguments?.getString("company") ?: ""
                    val cajon = it.arguments?.getString("cajon") ?: ""
                    val piso = it.arguments?.getString("piso") ?: ""
                    val esEspecial = it.arguments?.getBoolean("esEspecial") ?: false

                    val esEspecialString = if (esEspecial) "1" else "0"
                    val idEstacionamiento = it.arguments?.getString("idEstacionamiento") ?: ""
                    val imagen = it.arguments?.getString("imagen") ?: ""


                    val context = LocalContext.current
//                    Detalle(
//                        navController = navController,
//                        context,
//                        nombre,
//                        company,
//                        cajon,
//                        piso,
//                        esEspecial,
//                        idEstacionamiento,
//                        imagen
//                    )
                }

                composable("Oficinas") {
                    //AreaScreen(areaViewModel = viewModel(), navController = navController)
                }
            }
        }
    )
}

@Composable
fun DrawerContent(
    drawerItems: List<Triple<String, ImageVector, Any>>,
    navController: NavHostController,
    closeDrawer: () -> Unit
) {
    CompositionLocalProvider(LocalContentColor provides Color.Black) {


        Column(
            modifier = Modifier
                .padding(6.dp)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(2.dp))

            Image(
                painter = painterResource(R.drawable.ic_launcher_foreground), // Reemplaza R.drawable.logo_image con el ID de tu imagen
                contentDescription = "",
                modifier = Modifier
                    .padding(6.dp)
                    .align(Alignment.CenterHorizontally)
                    .size(140.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(22.dp))

            Text(
                text = "Welcome",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Weather app", fontSize = 15.sp, fontWeight = FontWeight.Medium
            )

            Spacer(modifier = Modifier.height(22.dp))
            drawerItems.forEach { (title, icon, _) ->
                DrawerItem(title = title, icon = icon, onClick = {
                    navController.navigate(title)
                }, closeDrawer = closeDrawer)
                Spacer(modifier = Modifier.height(26.dp))
            }
        }
    }
}

@Composable
fun DrawerItem(title: String, icon: ImageVector, onClick: () -> Unit, closeDrawer: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onClick()
            closeDrawer() // Aquí cerramos el menú después de navegar
        }
    ){
        Icon(imageVector = icon, contentDescription = null)
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

@Composable
fun MainContent(selectedSection: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Sección seleccionada: $selectedSection",
            style = MaterialTheme.typography.labelMedium
        )
    }
}