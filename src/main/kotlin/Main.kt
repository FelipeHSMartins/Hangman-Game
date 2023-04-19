val words = listOf(
    "Comida", "Arroz", "Cadeira", "Escola", "Colégio", "Pecado", "Igreja", "Deus", "Mouse", "Oito", "Quadrado",
    "Lixeiro", "Macaco", "Abelha", "Coelho", "Tigre", "Mesa", "Pandeiro", "Futebol", "Arma", "Espada", "Samurai"
)
var word = ""
val guesses = arrayListOf<Char>()
var remainingGuesses = 6
var mistakes = 0

fun main(args: Array<String>) {
    setupGame()
}

fun setupGame() {
    word = words.random().uppercase()
    for (i in word.indices)
        guesses.add('_')



    var gameOver = false

    do {
        printGameStatus()
        println("Please enter a letter:")
        val input = readLine()?:""
        if (input.isEmpty()) {
            println("That's not a valid input. Please try again.")
        } else {
            val letter: Char = input[0].uppercaseChar()
            if (word.contains(letter)) {
                for (i in word.indices) {
                    if(word[i] == letter)
                        guesses[i] = letter
                }
                if (!guesses.contains('_'))
                    gameOver = true
            } else {
                println("Sorry, that's not part of the word.")
                remainingGuesses--
                mistakes++
                if (mistakes == 6) {
                    gameOver = true
                }
            }
        }

    } while (!gameOver)

    if (mistakes == 6) {
        printGameStatus()
        println("Sorry, you lost!")
        println("The word was $word!")
    } else {
        println("\nCongratulations! You won!")
        println("The word was $word!")
    }
}

fun printGameStatus() {
    when (mistakes) {
        0 -> print0Mistakes()
        1 -> print1Mistakes()
        2 -> print2Mistakes()
        3 -> print3Mistakes()
        4 -> print4Mistakes()
        5 -> print5Mistakes()
        else -> print6Mistakes()
    }

    print("Word: ")
    for (element in guesses)
        print("$element ")

    println("You have $remainingGuesses guess(es) left.")
}



fun print0Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print1Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |        ")
    println("  |        ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print2Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |      | ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}


fun print3Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /| ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print4Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |        ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print5Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     /  ")
    println(" /|\\      ")
    println("/ | \\     ")
}

fun print6Mistakes() {
    println("  |------|-")
    println("  |      | ")
    println("  |      O ")
    println("  |     /|\\ ")
    println("  |      | ")
    println("  |     / \\")
    println(" /|\\      ")
    println("/ | \\     ")
}