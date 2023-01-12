package com.example.quizapp

import Constants
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.QuizAppTheme

class ResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizAppTheme {
                // A surface container using the 'background' color from the theme
                window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Result(intent = intent)
                }
            }
        }
    }
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    QuizAppTheme {
        val mockIntent = Intent().apply {
            putExtra(Constants.USER_NAME, "John")
        }
        Result(intent = mockIntent)
    }
}

@Composable
fun Result(intent: Intent){
    val text=intent.getStringExtra(Constants.USER_NAME)
    val correctAnswer=intent.getIntExtra(Constants.CORRECT_QUESTION,0)
    val incorrectAnswer=intent.getIntExtra(Constants.INCORRECT_ANSWER,0)
    val totalQuestions=intent.getIntExtra(Constants.TOTAL_QUESTION,16)
    Box {
        val context= LocalContext.current
        Image(painter = painterResource(id = R.drawable.pink_bg),
            contentDescription = "background Image",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = CenterHorizontally,
            modifier = Modifier.verticalScroll(rememberScrollState()),
        ) {
            Text(
                text = "Result", fontSize = 36.sp,
                modifier = Modifier
                    .wrapContentWidth(CenterHorizontally)
                    .padding(top = 10.dp),
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.h1
            )
            Image(
                painter = painterResource(id = R.drawable.trophy),
                contentDescription = "trophy_image",
                modifier = Modifier
                    .padding(top = 2.dp, start = 20.dp, end = 20.dp)
                    .wrapContentWidth()
                    .height(300.dp)
            )
            Text(
                text = "Hey, Congratulations!",fontSize = 25.sp,
                modifier = Modifier
                    .wrapContentWidth(CenterHorizontally)
                    .padding(top = 2.dp),
                color = colorResource(id = R.color.black),
                style = MaterialTheme.typography.h1
            )
            if (text != null) {
                Text(
                    text = text,fontSize = 25.sp,
                    modifier = Modifier
                        .wrapContentWidth(CenterHorizontally)
                        .padding(top = 2.dp),
                    color = colorResource(id = R.color.black),
                    style = MaterialTheme.typography.h1
                )
            }
            Text(
                text = "Your score is $correctAnswer out of $totalQuestions",fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
                    .padding(top = 2.dp),
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "Correct : $correctAnswer",fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
                    .padding(top = 2.dp),
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "Incorrect : $incorrectAnswer",fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(CenterHorizontally)
                    .padding(top = 2.dp),
                color = colorResource(id = R.color.black)
            )
            Button(
                onClick = {
                    context.startActivity(Intent(context,MainActivity::class.java))
                },
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(top = 2.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            ) {
                Text(
                    text = "Restart",
                    color = Color.Black
                )
            }
        }
    }
}