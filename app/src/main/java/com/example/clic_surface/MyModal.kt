package com.example.clic_surface

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Help
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

sealed class Options(val title:String, val icon: ImageVector){
    object Option1 :Options("Inicio", Icons.Default.Home)
    object Option2 :Options("Editar", Icons.Default.Edit)
    object Option3 :Options("Configuración", Icons.Default.Settings)
    object Option4 :Options("Ayuda", Icons.Default.Help)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Content() {
    val options = listOf<Options>(Options.Option1,Options.Option2, Options.Option3, Options.Option4)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var selectedOption by rememberSaveable {
        mutableStateOf(options[0].title)
    }
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = selectedOption) },
                navigationIcon = {
                    IconButton(onClick = {
                        if(drawerState.isOpen) scope.launch { drawerState.close()}
                        else scope.launch { drawerState.open() }
                    }) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menú" )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Cyan)
            )
        }
    ) {
        ModalNavigationDrawer(
            drawerState = drawerState,
            drawerContent = {
                ModalDrawerSheet {
                    Spacer(Modifier.height(12.dp))
                    options.forEach{ option ->
                        NavigationDrawerItem(
                            icon = {
                                Icon(imageVector = option.icon, contentDescription = option.title)
                            },
                            label = { Text(option.title) },
                            selected = option.title == selectedOption,
                            onClick = {
                                scope.launch { drawerState.close() }
                                selectedOption = option.title
                            },
                            modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding))
                    }
                }
            },
            modifier = Modifier.padding(it), //Importante para que se visualice correctamente
            content = {
                //Cargar contenido según opción elegida (selectedOption)
            })


    }
}