package com.example.firstjitcomposeproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.RowScope.gravity
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.firstjitcomposeproject.ui.FirstJitComposeProjectTheme

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val themeState = remember { mutableStateOf(false) }
            val usernameState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }

            FirstJitComposeProjectTheme(themeState.value) {

                Scaffold(
                    topBar = {
                        LoginTopBar(
                            title = stringResource(id = R.string.toolbar_login),
                            onThemeSwitchClick = { themeState.value = themeState.value.not() }
                        )
                    },

                    //  bottomBar = { LoginBottomBar() },

                    bodyContent = {
                        Column {
                            Spacer(modifier = Modifier.preferredHeight(28.dp))
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalGravity = Alignment.CenterHorizontally
                            ) {

                                Text(text = "Europet AdminApplication")
                            }

                            Column(
                                modifier = Modifier.fillMaxWidth()
                                    .wrapContentHeight(align = Alignment.Bottom),
                                verticalArrangement = Arrangement.Center
                            ) {
                                Spacer(modifier = Modifier.preferredHeight(48.dp))
                                UsernameField(usernameState)
                                PasswordField(passwordState)
                                Spacer(modifier = Modifier.preferredHeight(164.dp))
                                button(usernameState, passwordState, this@MainActivity)
                            }

                        }
                    },


                    /* isFloatingActionButtonDocked = true,
                     floatingActionButton = {
                         FloatingActionButton(
                             onClick = {
                                 Toast.makeText(
                                     this@MainActivity,
                                     "Username is ${usernameState.value} and password is ${passwordState.value}",
                                     Toast.LENGTH_LONG
                                 ).show()
                             },
                             icon = { Icon(asset = Icons.Filled.ArrowForward) })
                     },
                     floatingActionButtonPosition = FabPosition.Center*/
                )
            }
        }
    }
}

@Composable
fun LoginTopBar(title: String = "Hello", onThemeSwitchClick: () -> Unit) {
    TopAppBar(modifier = Modifier.gravity(Alignment.Top)) {
        Text(
            text = title,
            style = TextStyle(fontSize = TextUnit.Companion.Sp(16)),
            modifier = Modifier.gravity(Alignment.CenterVertically)
                .padding(start = 16.dp)
        )

        Row {
            IconButton(onClick = { onThemeSwitchClick() }) {
                Icon(vectorResource(id = R.drawable.ic_day_night))
            }

            IconButton(onClick = {
                navigationToList()

            }) {
                Icon(vectorResource(id = R.drawable.ic_folder))
            }
        }
    }
}

fun navigationToList() {
 /* Intent  intent = Intent(con, MovieListActivity::class.java)
    startActivity(intent)*/
}

/*@Composable
fun LoginBottomBar() {
    BottomAppBar(cutoutShape = CircleShape) {
        Text(
            text = stringResource(id = R.string.greeting),
            style = TextStyle(fontSize = TextUnit.Companion.Sp(16)),
            modifier = Modifier.gravity(Alignment.CenterVertically).padding(start = 16.dp)
        )
    }
}*/

@Composable
fun UsernameField(usernameState: MutableState<String>) {
    OutlinedTextField(
        value = usernameState.value,
        onValueChange = { usernameState.value = it },
        label = { Text(text = stringResource(id = R.string.login_hint_enter_username)) },
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
        placeholder = { Text(text = stringResource(id = R.string.login_placeholder_username)) },
        leadingIcon = {
            Icon(asset = vectorResource(id = R.drawable.ic_username))
        })
}

@Composable
fun PasswordField(passwordState: MutableState<String>) {
    OutlinedTextField(value = passwordState.value,
        onValueChange = { passwordState.value = it },
        label = { Text(text = stringResource(id = R.string.login_hint_enter_password)) },
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(asset = vectorResource(id = R.drawable.ic_password))
        }
    )
}

@Composable
fun button(
    usernameState: MutableState<String>,
    passwordState: MutableState<String>,
    mainActivity: MainActivity
) {
    OutlinedButton(
        onClick = {
            Toast.makeText(
                mainActivity,
                "Username is ${usernameState.value} and password is ${passwordState.value}",
                Toast.LENGTH_LONG
            ).show()
        },
        border = BorderStroke(1.dp, Color.Red),
        contentColor = Color.Red,
        shape = RoundedCornerShape(50) //50% percent

    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalGravity = Alignment.CenterHorizontally
        ) {

            Text(text = "SubAdmin")
        }
    }
}