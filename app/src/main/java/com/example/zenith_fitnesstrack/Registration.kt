package com.example.zenith_fitnesstrack

import android.content.res.Configuration
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showSystemUi = true,
    device = "spec:id=reference_phone,shape=Normal,width=411,height=891,unit=dp,dpi=420",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable()
fun Registration() {

    var name by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var retypepass by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.register),
            contentDescription = "Login page",
            modifier = Modifier.size(250.dp, 250.dp)
        )
        Text(
            text = "Welcome to Zenith!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Register with us",
        )
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = "Name", onValueChange = {
            name = it
        }, label = {
            Text(text = "Enter your name")
        })
        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(value = "Email", onValueChange = {
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

        OutlinedTextField(value = "Reenter Password", onValueChange = {
            retypepass = it
        }, label = {
            Text(text = "Retype password")
        }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(6.dp))

        Button(onClick = {
            Log.i("Credentials", "Email: $email Password: $password")
        }) {
            Text(
                text = "Register",
                modifier = Modifier
                    .size(70.dp, 30.dp)
                    .padding(6.dp, 6.dp)
            )

        }

        Spacer(modifier = Modifier.height(4.dp))

//        TextButton(onClick = { /*TODO*/ }) {
//            Text(text = "Forgot Password")
//        }

//        Image(
//            painter = painterResource(id = R.drawable.google),
//            contentDescription = "Google",
//            modifier = Modifier
//                .size(30.dp)
//                .clickable {
//                    // Google clicked
//                }
//        )

    }

}


