import com.example.quizapp.Question
import com.example.quizapp.R

object Constants {
    const val USER_NAME="user_name"
    const val CORRECT_QUESTION="correct_question"
    const val TOTAL_QUESTION="total_question"
    const val INCORRECT_ANSWER="incorrect_answer"
    val questions: List<Question> = listOf(
        Question(
            id = 1,
            question = "Thor’s hammer Mjolnir is made of metal from the heart of a dying what?",
            drawable = R.drawable.mjolnir,
            optionOne = "Star",
            optionTwo = "Comet",
            optionThree = "Planet",
            optionFourth = "Asteroid",
            correctAnswer = 1
        ),
        Question(
            id = 2,
            question = "What is the name of the villain in Marvel Studios’ Ant-Man?",
            drawable = R.drawable.antman,
            optionOne = "The Wasp",
            optionTwo = "Hornet",
            optionThree = "Yellow Jacket",
            optionFourth = "ghost",
            correctAnswer = 3
        ),
        Question(
            id = 3,
            question = "What is the name of the set of documents that regulate the activities of enhanced persons?",
            drawable = R.drawable.sokovia_accords,
            optionOne = "Stark Accords",
            optionTwo = "Paris Accords",
            optionThree = "S.H.I.E.L.D Accords",
            optionFourth = "Sokovia Accords",
            correctAnswer = 4
        ),
        Question(
            id = 4,
            question = "What are the names of the batteries that the Guardians have to protect at the beginning of Marvel Studios’ Guardians of the Galaxy Vol. 2?",
            drawable = R.drawable.batteries,
            optionOne = "Harbulary Batteries",
            optionTwo = "Anulax Batteries",
            optionThree = "Vibranium Batteries",
            optionFourth = "Galaxy Batteries",
            correctAnswer = 2
        ),
        Question(
            id = 5,
            question = "Which of the following is not on Captain America’s to-do list in Marvel Studios’ Captain America: The Winter Soldier?",
            drawable = R.drawable.to_do_list,
            optionOne = "Thai Food",
            optionTwo = "Nirvana",
            optionThree = "Star Wars",
            optionFourth = "Frozen Yogurt",
            correctAnswer = 4
        ),
        Question(
            id = 6,
            question = "In the post-credits scene of Marvel Studios’ The Avengers, what type of restaurant are the Avengers shown eating at?",
            drawable = R.drawable.avengers,
            optionOne = "Pizza",
            optionTwo = "Shawarma",
            optionThree = "Sushi",
            optionFourth = "Fried Chicken",
            correctAnswer = 2
        ),
        Question(
            id = 7,
            question = "Rocket has been called all of the following names except ______?",
            drawable = R.drawable.rocket_raccon,
            optionOne = "Whishker",
            optionTwo = "Triangled-Faced Monkey",
            optionThree = "Sweet Rabbit",
            optionFourth = "Trash Panda",
            correctAnswer = 1
        ),
        Question(
            id = 8,
            question = "What is the Wi-Fi password Karl Modo hands to Doctor Strange?",
            drawable = R.drawable.wifi_pass,
            optionOne = "Dormammu",
            optionTwo = "Kamar-Taj",
            optionThree = "Shamballa",
            optionFourth = "Agamotto",
            correctAnswer = 3
        ),
        Question(
            id = 9,
            question = "In Marvel Studios’ Thor: Ragnarok, Thor reunited with the Hulk on this planet.",
            drawable = R.drawable.sakaar,
            optionOne = "Asgard",
            optionTwo = "Sakaar",
            optionThree = "Xandar",
            optionFourth = "Berhert",
            correctAnswer = 2
        ),
        Question(
            id = 10,
            question = "What does the “E” in S.H.I.E.L.D. stand for?",
            drawable = R.drawable.shield,
            optionOne = "Enforcement",
            optionTwo = "Extraterrestrial",
            optionThree = "Extermination",
            optionFourth = "Expansion",
            correctAnswer = 1
        ),
        Question(
            id = 11,
            question = "Where did Thanos find the Soul Stone?",
            drawable = R.drawable.thanos,
            optionOne = "Vormir",
            optionTwo = "Knowhere",
            optionThree = "Earth",
            optionFourth = "Nidavellir",
            correctAnswer = 1
        ),
        Question(
            id = 12,
            question = "Who of the following is not part of the Black Order in Marvel Studios’ Avengers: Infinity War?",
            drawable = R.drawable.black_order,
            optionOne = "Proxima Midnight",
            optionTwo = "Ebony Maw",
            optionThree = "Cull Obsidian",
            optionFourth = "Ulysses klaue",
            correctAnswer = 4
        ),
        Question(
            id = 13,
            question = "Thor has a new weapon in Marvel Studios’ Avengers: Infinity War. What is it called and where was it forged?",
            drawable = R.drawable.storm_breaker,
            optionOne = "Mjolnir, Vormir",
            optionTwo = "Stormbreaker, Nidavelljr",
            optionThree = "Stormbringer, Knowhere",
            optionFourth = "Tesserect, Vormir",
            correctAnswer = 2
        ),
        Question(
            id = 14,
            question = "Which movie was Captain America’s shield last seen?",
            drawable = R.drawable.civil_war,
            optionOne = "Marvel Studios' Avengers: Infinity War",
            optionTwo = "Marvel Studios' Avengers: Endgame",
            optionThree = "Marvel Studios' Captain America: Civil War",
            optionFourth = "Marvel Studios' Avengers: Age Of Ultron",
            correctAnswer = 2
        ),
        Question(
            id = 15,
            question = "What is the collective name of the female warriors that protect the king of Wakanda?",
            drawable = R.drawable.dora_milaje,
            optionOne = "Dora Milaje",
            optionTwo = "Jabari",
            optionThree = "Kimoyo",
            optionFourth = "Hatut Zeraze",
            correctAnswer = 1
        ),
        Question(
            id = 16,
            question = "Finally, how many movies are there in the Marvel Cinematic Universe so far, including Marvel Studios’ Avengers: Endgame?",
            drawable = R.drawable.endgame,
            optionOne = "15",
            optionTwo = "18",
            optionThree = "20",
            optionFourth = "30",
            correctAnswer = 4
        ),
        // Add other questions here...
    )
}
