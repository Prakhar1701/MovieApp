package prakhar.udemy.jetpackcompose.movieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import prakhar.udemy.jetpackcompose.movieapp.navigation.MovieNavigation
import prakhar.udemy.jetpackcompose.movieapp.ui.theme.MovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigation()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        content()
    }
}
