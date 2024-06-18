package com.example.zenith_fitnesstrack

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation

@Composable
fun LoginScreen() {
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.login),
            contentDescription = "Login page",
            modifier = Modifier.size(200.dp, 200.dp)
            )
        Text(
            text = "Welcome Back!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Sign in to continue",
        )
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = "email", onValueChange = {
            email = it
        }, label = {
            Text(text = "Email address")
        })

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = "password", onValueChange = {
            password = it
        }, label = {
            Text(text = "Password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(4.dp))
        
        Button(onClick = {
            Log.i("Credentials", "Email: $email Password: $password")
        }) {
            Text(
                text = "Login",
                modifier = Modifier.size(60.dp, 30.dp)
                .padding(6.dp, 6.dp)
            )
            
        }

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = "Forgot password",
            modifier = Modifier.clickable {

            })
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "Or sign in with")


//        TextButton(onClick = { /*TODO*/ }) {
//            Text(text = "Forgot Password")
//        }

        Image(
            painter = painterResource(id = R.drawable.google),
            contentDescription = "Google",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    // Google clicked
                }
        )

    }

}