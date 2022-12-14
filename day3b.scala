import scala.io.StdIn.readLine
import scala.io.Source._
import scala.collection.mutable

def solve(lines: List[String], prioritiesMap: scala.collection.mutable.Map[Char, Int]): Int = 
  (for i <- 0 until lines.length by 3 yield {
    val one: String = lines(i)
    val two: String = lines(i+1)
    val three: String = lines(i+2)
    val four: String = (one intersect two).toString()
    val five: String = (two intersect three).toString()
    prioritiesMap(common(four, five).toString().charAt(0))
  }).foldLeft(0)(_ + _)

@main
def main(): Unit = 
  val prioritiesList = (('a' to 'z') ++ ('A' to 'Z')) zip (1 to 52)
  var prioritiesMap = scala.collection.mutable.Map[Char, Int]()
  for y <- prioritiesList do
    prioritiesMap(y._1) = y._2
  val lines = fromFile("src/main/scala/in.txt").getLines().toList
  println("lines length: " + lines.length)
  println("Answer: " + solve(lines, prioritiesMap))
