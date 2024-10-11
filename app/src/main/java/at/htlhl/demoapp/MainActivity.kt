package at.htlhl.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import at.htlhl.demoapp.ui.theme.LoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Modifier.padding(innerPadding)

                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "login_Screen") {
                        composable("login_Screen") {
                            LoginScreen(navController)
                        }

                        composable("registration_Screen") {
                            RegistrationScreen(navController)
                        }

                        composable("team_screen") {
                            TeamScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}
