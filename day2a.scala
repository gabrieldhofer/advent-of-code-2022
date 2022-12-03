import scala.io.StdIn.readLine
import scala.io.Source._

// second parameter is my choice, same order as input
def play(a: String, b: String): Int = {
  if a == "paper" && b == "rock" then 1 + 0
  else if a == "scissors" && b == "rock" then 1 + 6
  else if a == "rock" && b == "rock" then 1 + 3
  else if a == "rock" && b == "paper" then 2 + 6
  else if a == "scissors" && b == "paper" then 2 + 0
  else if a == "paper" && b == "paper" then 2 + 3
  else if a == "rock" && b == "scissors" then 3 + 0
  else if a == "paper" && b == "scissors" then 3 + 6
  else 3 + 3
}

@main
def main(): Unit = {
  val lines = fromFile("src/main/scala/in.txt").getLines()

  // A -> Rock, B -> Paper, C -> Scissors
  // X -> Rock, Y -> Paper, Z -> Scissors
  // ------------------------------------
  val predictionToValue = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
  val predictionTranslate = Map("A" -> "rock", "B" -> "paper", "C" -> "scissors")
  val suggestionTranslate = Map("X" -> "rock", "Y" -> "paper", "Z" -> "scissors")
  var total: Int = 0

  for x <- lines do {
    println(x)
    val oneLine: Array[String] = x.split(" ")
    total += play(predictionTranslate(oneLine(0)), suggestionTranslate(oneLine(1)))
  }
  println("total: " + total.toString)
}
