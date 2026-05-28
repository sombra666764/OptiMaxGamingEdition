package com.optimax.gaming



import android.os.Bundle

import androidx.activity.ComponentActivity

import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp

import com.optimax.gaming.ui.theme.OptiMaxGamingEditionTheme



class MainActivity : ComponentActivity() {
  
    override fun onCreate(savedInstanceState: Bundle?) {
      
        super.onCreate(savedInstanceState)
        
        setContent {
          
            OptiMaxGamingEditionTheme {
              
                Surface(
                  
                    modifier = Modifier.fillMaxSize(),
                  
                    color = MaterialTheme.colorScheme.background
                  
                ) {
                  
                    OptiMaxApp()
                    
                }
                
            }
            
        }
        
    }
    
}



@OptIn(ExperimentalMaterial3Api::class)

@Composable

fun OptiMaxApp() {
  
    val context = LocalContext.current
  

  
    Scaffold(
      
        topBar = {
          
            TopAppBar(title = { Text("OptiMax Gaming Edition") })
            
        }
        
    ) { paddingValues ->
      
        Column(
          
            modifier = Modifier
          
                .padding(paddingValues)
                
                .fillMaxSize()
                
                .padding(16.dp)
                
        ) {
          
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
              
                Column(modifier = Modifier.padding(16.dp)) {
                  
                    Text("Ultra Clean (Memoria)", style = MaterialTheme.typography.headlineSmall)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Button(onClick = { /* Lógica */ }) {
                      
                        Text("Limpiar Caché de Apps")
                        
                    }
                    
                }
                
            }
            

            
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
              
                Column(modifier = Modifier.padding(16.dp)) {
                  
                    Text("Conexión Rayo (DNS)", style = MaterialTheme.typography.headlineSmall)
                    
                    Spacer(modifier = Modifier.height(8.dp))
                    
                    Button(onClick = { /* Lógica */ }) {
                      
                        Text("Activar DNS Cloudflare (1.1.1.1)")
                        
                    }
                    
                }
                
            }
            
        }
        
    }
    
}


















































