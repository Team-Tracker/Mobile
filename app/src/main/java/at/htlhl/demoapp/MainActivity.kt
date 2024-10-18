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
import at.htlhl.demoapp.data.User
import at.htlhl.demoapp.screens.CalendarScreen
import at.htlhl.demoapp.screens.ChatScreen
import at.htlhl.demoapp.screens.LoginScreen
import at.htlhl.demoapp.screens.ProfileScreen
import at.htlhl.demoapp.screens.RegistrationScreen
import at.htlhl.demoapp.screens.TeamScreen
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

                    val user = User()

                    NavHost(navController = navController, startDestination = "login_screen") {
                        composable("login_screen") {
                            LoginScreen(navController, user)
                        }

                        composable("registration_screen") {
                            RegistrationScreen(navController, user)
                        }

                        composable("team_screen") {
                            TeamScreen(navController, user)
                        }

                        composable("calendar_screen") {
                            CalendarScreen(navController, user)
                        }

                        composable("chat_screen") {
                            ChatScreen(navController, user)
                        }

                        composable("profile_screen") {
                            ProfileScreen(navController, user)
                        }
                    }
                }
            }
        }
    }
}
