package com.optimax.gaming



import android.content.Context

import android.net.ConnectivityManager

import android.net.LinkProperties

import android.net.Network

import android.net.NetworkCapabilities

import android.net.NetworkRequest

import android.os.Build

import android.provider.Settings

import android.util.Log

import androidx.annotation.RequiresApi



class DNSManager(private val context: Context) {
  

  
    private val TAG = "DNSManager"
  

  
    // Función para activar DNS de Cloudflare (1.1.1.1)
  
    fun activateCloudflareDNS(): Boolean {
      
        return setPrivateDNS("1dot1dot1dot1.cloudflare-dns.com")
        
    }
    

    
    // Función para activar DNS de Google (8.8.8.8)
    
    fun activateGoogleDNS(): Boolean {
      
        return setPrivateDNS("dns.google")
        
    }
    

    
    // Función para desactivar DNS privado
    
    fun deactivatePrivateDNS(): Boolean {
      
        return setPrivateDNS("")
        
    }
    

    
    // Intenta configurar el DNS privado (Android 9+)
    
    private fun setPrivateDNS(hostname: String): Boolean {
      
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) { // Android 9 (Pie) o superior
          
            try {
              
                Settings.Global.putString(context.contentResolver, Settings.Global.PRIVATE_DNS_MODE, if (hostname.isEmpty()) "off" else "hostname")
                
                Settings.Global.putString(context.contentResolver, Settings.Global.PRIVATE_DNS_SPECIFIER, hostname)
                
                Log.d(TAG, "DNS privado configurado a: $hostname")
                
                return true
              
            } catch (e: Exception) {
              
                Log.e(TAG, "Error al configurar DNS privado: ${e.message}")
                
                // Esto puede fallar si la app no tiene permisos de escritura en Settings.Global
                
                // En un entorno real, se necesitaría un permiso especial o una solución de root/VPN.
                
                return false
              
            }
            
        } else {
          
            Log.w(TAG, "La configuración de DNS privado requiere Android 9 (API 28) o superior.")
            
            // Para versiones anteriores, se necesitaría una solución de VPN o root.
            
            return false
          
        }
        
    }
    

    
    // Función para limpiar la tabla ARP (requiere permisos de root o comandos específicos de red)
    
    // En Android, esto no es directamente accesible para apps sin root por seguridad.
    
    // Se puede informar al usuario sobre cómo hacerlo manualmente o sugerir apps de terceros.
    
    fun clearArpCache(): Boolean {
      
        Log.w(TAG, "La limpieza de la tabla ARP directamente desde una app sin root no es posible en Android por seguridad.")
        
        Log.w(TAG, "Se recomienda informar al usuario sobre métodos manuales o el uso de herramientas de terceros con root.")
        
        return false // Indica que no se pudo realizar directamente
      
    }
    

    
    // Función para obtener los DNS actuales (solo para depuración/información)
    
    @RequiresApi(Build.VERSION_CODES.M)
    
    fun getCurrentDnsServers(): List<String> {
      
        val dnsServers = mutableListOf<String>()
        
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
      

      
        connectivityManager.activeNetwork?.let { network ->
          
            connectivityManager.getLinkProperties(network)?.let { linkProperties ->
              
                for (dns in linkProperties.dnsServers) {
                  
                    dnsServers.add(dns.hostAddress)
                    
                }
                
            }
            
        }
        
        return dnsServers
      
    }
    
}































































