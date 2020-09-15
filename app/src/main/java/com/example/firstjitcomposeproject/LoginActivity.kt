package com.example.firstjitcomposeproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Border
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement.Center
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity

import com.example.firstjitcomposeproject.ui.FirstJitComposeProjectTheme
import kotlin.reflect.KProperty

class LoginActivity : AppCompatActivity() {

    var strPassword: String = ""
    var strUserName: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val themeState = remember { mutableStateOf(false) }
            val usernameState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }

            Column(
                modifier = Modifier.fillMaxWidth()
                    .wrapContentHeight(align = Alignment.Bottom),
                verticalArrangement = Arrangement.Center

            ) {
                Spacer(modifier = Modifier.preferredHeight(48.dp))
                user_name(usernameState)
                password_(passwordState)
                Spacer(modifier = Modifier.preferredHeight(164.dp))
            }

            // A surface container using the 'background' color from the theme
          /*  FirstJitComposeProjectTheme(themeState.value) {

                run {

                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .wrapContentHeight(align = Alignment.Bottom),
                        verticalArrangement = Arrangement.Center

                    ) {
                        Spacer(modifier = Modifier.preferredHeight(48.dp))
                        user_name(usernameState)
                        password_(passwordState)
                        Spacer(modifier = Modifier.preferredHeight(164.dp))
                    }
                }
            }*/


        }
    }


    @Composable
    fun user_name(usernameState: MutableState<String>) {
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
    fun password_(passwordState: MutableState<String>) {
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

    fun NewsStory() {
        val image = imageResource(R.drawable.image)
        MaterialTheme {
            val typography = MaterialTheme.typography
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                val imageModifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp))

                Image(
                    image, modifier = imageModifier,
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.preferredHeight(16.dp))

                Text(
                    "A day wandering through the sandhills " +
                            "in Shark Fin Cove, and a few of the " +
                            "sights I saw",
                    style = typography.h6,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "Davenport, California",
                    style = typography.body2
                )
                Text(
                    "December 2018",
                    style = typography.body2
                )
            }
        }
    }
}

