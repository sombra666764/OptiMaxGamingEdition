package com.optimax.gaming



import android.content.Context

import android.content.Intent

import android.provider.Settings

import android.util.Log



class ProcessManager(private val context: Context) {
  

  
    private val TAG = "ProcessManager"
  

  
    // Función para llevar al usuario a la configuración de aplicaciones para forzar el cierre
  
    fun redirectToAppInfo(packageName: String) {
      
        try {
          
            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            
            intent.data = android.net.Uri.parse("package:$packageName")
            
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            
            context.startActivity(intent)
            
            Log.d(TAG, "Redirigiendo a la información de la app: $packageName")
            
        } catch (e: Exception) {
          
            Log.e(TAG, "Error al redirigir a la información de la app: ${e.message}")
            
        }
        
    }
    

    
    // Función para llevar al usuario a la configuración de "Aplicaciones en segundo plano" (si existe)
    
    fun redirectToBackgroundAppSettings() {
      
        try {
          
            val intent = Intent(Settings.ACTION_USAGE_ACCESS_SETTINGS)
            
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            
            context.startActivity(intent)
            
            Log.d(TAG, "Redirigiendo a la configuración de acceso de uso.")
            
        } catch (e: Exception) {
          
            Log.e(TAG, "Error al redirigir a la configuración de acceso de uso: ${e.message}")
            
            // Si no funciona, intentar con la configuración de batería
            
            try {
              
                val intent = Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS)
                
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                
                context.startActivity(intent)
                
                Log.d(TAG, "Redirigiendo a la configuración de ahorro de batería.")
                
            } catch (e2: Exception) {
              
                Log.e(TAG, "Error al redirigir a la configuración de ahorro de batería: ${e2.message}")
                
            }
            
        }
        
    }
    

    
    // Función para llevar al usuario a las Opciones de Desarrollador para ajustar animaciones
    
    fun redirectToDeveloperOptions() {
      
        try {
          
            val intent = Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS)
            
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            
            context.startActivity(intent)
            
            Log.d(TAG, "Redirigiendo a las Opciones de Desarrollador.")
            
        } catch (e: Exception) {
          
            Log.e(TAG, "Error al redirigir a las Opciones de Desarrollador: ${e.message}")
            
        }
        
    }
    

    
    // Función para activar/desactivar el modo de bajo consumo (solo para informar al usuario)
    
    // La activación directa requiere permisos de sistema o root.
    
    fun toggleLowPowerMode(enable: Boolean): Boolean {
      
        Log.w(TAG, "La activación/desactivación directa del modo de bajo consumo requiere permisos de sistema o root.")
        
        Log.w(TAG, "Se recomienda informar al usuario sobre cómo hacerlo manualmente desde la configuración.")
        
        // Aquí se podría lanzar una Intent para llevar al usuario a la configuración de batería
        
        return false
      
    }
    

    
    // Función para obtener una lista de aplicaciones en ejecución (limitado en Android moderno)
    
    // En Android 5.0 (API 21) y superior, getRunningAppProcesses() solo devuelve las apps del propio paquete
    
    // o las que tienen permisos de sistema. Para obtener todas, se necesita USAGE_STATS_SERVICE o root.
    
    fun getRunningApps(): List<String> {
      
        Log.w(TAG, "Obtener una lista completa de apps en ejecución está restringido en Android moderno por seguridad.")
        
        Log.w(TAG, "Se recomienda usar UsageStatsManager (requiere permiso USAGE_STATS_SERVICE y que el usuario lo active)































































