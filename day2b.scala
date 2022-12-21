import scala.io.StdIn.readLine
import scala.io.Source._

// second parameter is my choice, same order as input
def play(a: String, b: String): Int = 
  if a == "paper" && b == "lose" then 0 + 1
  else if a == "scissors" && b == "lose" then 0 + 2
  else if a == "rock" && b == "lose" then 0 + 3
  else if a == "rock" && b == "draw" then 3 + 1
  else if a == "scissors" && b == "draw" then 3 + 3
  else if a == "paper" && b == "draw" then 3 + 2
  else if a == "rock" && b == "win" then 6 + 2
  else if a == "paper" && b == "win" then 6 + 3
  else 6 + 1

@main
def main(): Unit = 
  val lines = fromFile("src/main/scala/in.txt").getLines()
  val predictionToValue = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
  val predictionTranslate = Map("A" -> "rock", "B" -> "paper", "C" -> "scissors")
  val suggestionTranslate = Map("X" -> "lose", "Y" -> "draw", "Z" -> "win")
  var total: Int = 0
  for x <- lines do 
    println(x)
    val oneLine: Array[String] = x.split(" ")
    total += play(predictionTranslate(oneLine(0)), suggestionTranslate(oneLine(1)))
  println("total: " + total.toString)
