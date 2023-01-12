package com.example.quizapp

import Constants
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.QuizAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    QuizUi()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuizAppTheme {
        QuizUi()
    }
}

@Composable
fun QuizUi(){
    val context = LocalContext.current
    Box {
        Image(
            painter = painterResource(id = R.drawable.pink_bg),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Text(
            text = "Marvel Quiz", fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .padding(top = 10.dp),
            color = colorResource(id = R.color.black),
            style = MaterialTheme.typography.h1
        )
        Card(
            modifier = Modifier.padding(top = 80.dp, start = 30.dp, end = 30.dp, bottom = 30.dp),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.padding(top = 10.dp, start = 40.dp, end = 40.dp, bottom = 20.dp)
            ){
                Text(
                        text = "Welcome",
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        //modifier = Modifier.padding(top=10.dp,start=100.dp,end=100.dp),
                        fontSize = 32.sp
                    )
                    Text(
                        text = "Please Enter Your Name.",
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 10.dp, bottom = 10.dp),
                        fontSize = 16.sp
                    )
                    var text by remember { mutableStateOf("") }
                    OutlinedTextField(
                        value = text,
                        onValueChange = { newText -> text=newText},
                        label = { Text(text = "Name", color = colorResource(id = R.color.pink))},
                        leadingIcon = {
                            IconButton(onClick = { /*TODO*/ }) {
                                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "Account Box")
                            }
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Next
                        ),
                        placeholder = { Text(text = "e.g. John doe")},
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            focusedBorderColor = colorResource(id = R.color.pink)
                        )
                    )
                    Button(
                        onClick = { if(text==""){
                                Toast.makeText(context,"Please enter your name",Toast.LENGTH_SHORT).show()
                            }
                            else{
                            context.startActivity(Intent(context, QuizQuestionsActivity::class.java).putExtra(Constants.USER_NAME, text))
                            } },
                        modifier = Modifier.fillMaxWidth(),
                        colors= ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink)),
                    ) {
                        Text(text = "Submit")
                    }
                }
            }
    }
}
