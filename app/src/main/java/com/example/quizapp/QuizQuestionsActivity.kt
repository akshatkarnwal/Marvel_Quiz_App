package com.example.quizapp

import Constants
import Constants.questions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Toast
import androidx.compose.material.ButtonDefaults
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quizapp.ui.theme.QuizAppTheme

class QuizQuestionsActivity : ComponentActivity() {
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
                    BgImage(intent = intent)
                }
            }
        }
    }
    private var doubleBackToExitPressedOnce = false
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()
        Handler(Looper.getMainLooper()).postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    val mockIntent = Intent().apply {
        putExtra(Constants.USER_NAME, "John")
    }
    QuizQuestions(intent = mockIntent)
}

@Composable
fun BgImage(intent: Intent){
    Image(
        painter = painterResource(id = R.drawable.pink_bg),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    QuizQuestions(intent = intent)
}
@Composable
fun QuizQuestions(intent: Intent) {
    val totalQuestions = questions.size
    var currentQuestionIndex by remember { mutableStateOf(0) }
    val question = questions[currentQuestionIndex]
    val currentQuestion = currentQuestionIndex + 1
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var buttonColor by remember { mutableStateOf(Color.Gray) }
    var correctAnswers by remember { mutableStateOf(0) }
    var incorrectAnswers by remember { mutableStateOf(0) }
    var correctButtonColor by remember { mutableStateOf(Color.Green) }
    var submitted by remember { mutableStateOf(false) }
    var flag by remember { mutableStateOf(false) }
    var incorrectOption by remember { mutableStateOf(false) }
    val userName=intent.getStringExtra(Constants.USER_NAME)

    Column(
        modifier = Modifier
            .padding(start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = CenterHorizontally
    ) {
        val context= LocalContext.current
        Text(
            text = question.question,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 20.dp),
            fontSize = 20.sp,
            color = colorResource(id = R.color.black)
        )
        Image(
            painter = painterResource(id = question.drawable),
            contentDescription = "Question Image",
            modifier = Modifier.padding(top = 20.dp),
            contentScale = ContentScale.FillHeight,
        )
        Row {
            LinearProgressIndicator(
                progress = currentQuestion.toFloat() / totalQuestions,
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .weight(4f),
                color = colorResource(id = R.color.black)
            )
            Text(
                text = "$currentQuestion/$totalQuestions",
                modifier = Modifier
                    .padding(top = 10.dp),
                color = colorResource(id = R.color.black)
            )
        }
        Button(
            // Set the background color based on the state of each option
            colors = (if (selectedOption == 1) {
                ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            } else if (submitted && question.correctAnswer==1 && incorrectOption){
                ButtonDefaults.buttonColors(backgroundColor = correctButtonColor)
            } else {
                ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            }),
            onClick = {
                flag=true
                if (!submitted) {
                    selectedOption = 1
                }
            },
            modifier = Modifier.padding(top = 10.dp),
            enabled = !submitted || selectedOption == 1 || question.correctAnswer==1
        ) {
            Text(
                text = question.optionOne,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black)
            )
        }
        Button(
            // Set the background color based on the state of each option
            colors = (if (selectedOption == 2) {
                ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            } else if (submitted && question.correctAnswer==2 && incorrectOption){
                ButtonDefaults.buttonColors(backgroundColor = correctButtonColor)
            } else {
                ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            }),
            onClick = {
                flag=true
                if (!submitted) {
                    selectedOption = 2
                }
            },
            modifier = Modifier.padding(top = 10.dp),
            enabled = !submitted || selectedOption == 2 || question.correctAnswer==2
        ) {
            Text(
                text = question.optionTwo,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black)
            )
        }
        Button(
            // Set the background color based on the state of each option
            colors = (if (selectedOption == 3) {
                ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            } else if (submitted && question.correctAnswer==3 && incorrectOption){
                ButtonDefaults.buttonColors(backgroundColor = correctButtonColor)
            } else {
                ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            }),
            onClick = {
                flag=true
                if (!submitted) {
                    selectedOption = 3
                }
            },
            modifier = Modifier.padding(top = 10.dp),
            enabled = !submitted || selectedOption == 3 || question.correctAnswer==3
        ){
            Text(
                text = question.optionThree,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black)
            )
        }
        Button(
            // Set the background color based on the state of each option
            colors = (if (selectedOption == 4) {
                ButtonDefaults.buttonColors(backgroundColor = buttonColor)
            } else if (submitted && question.correctAnswer==4 && incorrectOption){
                ButtonDefaults.buttonColors(backgroundColor = correctButtonColor)
            } else {
                ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            }),
            onClick = {
                flag=true
                if (!submitted) {
                    selectedOption = 4
                }
            },
            modifier = Modifier.padding(top = 10.dp),
            enabled = !submitted || selectedOption == 4 || question.correctAnswer==4
        ) {
            Text(
                text = question.optionFourth,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.black)
            )
        }
        Row{
            Button(
                onClick = {
                    // Change the background color of the selected option based on whether it is correct or not
                    if(flag){
                        if (selectedOption == question.correctAnswer) {
                            buttonColor=Color.Green
                            correctAnswers++
                        } else {
                            buttonColor=Color.Red
                            incorrectOption=true
                            correctButtonColor=Color.Green
                            incorrectAnswers++
                        }
                        submitted=true
                        flag=false
                    }else{
                        Toast.makeText(context,"Please select an option before submitting.",Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .padding(top = 10.dp, end = 10.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink)),
                enabled = !submitted
            ) {
                Text(text = "Submit", color = colorResource(id = R.color.black))
            }
            Button(
                onClick = {
                    if (currentQuestionIndex==15 && submitted){
                        context.startActivity(
                            Intent(context, ResultActivity::class.java)
                                .putExtra(Constants.USER_NAME, userName)
                                .putExtra(Constants.CORRECT_QUESTION, correctAnswers)
                                .putExtra(Constants.TOTAL_QUESTION, currentQuestion)
                                .putExtra(Constants.INCORRECT_ANSWER, incorrectAnswers),
                        )
                    }
                    else if (submitted){
                        selectedOption = null
                        buttonColor=Color.Gray
                        incorrectOption=false
                        submitted=false
                        currentQuestionIndex = (currentQuestionIndex + 1)
                    }else{
                        Toast.makeText(context,"Please submit the current question before moving on.",Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp)
                    .weight(1f),
                colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.pink))
            ) {
                val btn: String = if (currentQuestionIndex < 15) {
                    "Next"
                } else {
                    "Finish"
                }
                Text(text = btn, color = Color.Black)
            }
        }
    }
}
