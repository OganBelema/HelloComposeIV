package com.oganbelema.hellocomposeiv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.oganbelema.hellocomposeiv.navigation.MovieNavigation
import com.oganbelema.hellocomposeiv.ui.theme.HelloComposeIVTheme

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
    HelloComposeIVTheme {
        content()
    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloComposeIVTheme {
        MyApp {
            MovieNavigation()
        }
    }
}