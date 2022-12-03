import scala.io.StdIn.readLine
import scala.io.Source._

@main
def main(): Unit = {
  val lines = fromFile("src/main/scala/in.txt").getLines()
  var elfIdx = 1
  var maxSum: Int = 0
  var sum: Int = 0
  var maxElfIdx: Int = 0
  var second: Int = 0
  var third: Int = 0
  for x <- lines do {
    println(x)
    if !x.nonEmpty then
      if sum > maxSum && sum < 66601 then
        maxSum = sum
        maxElfIdx = elfIdx
      sum = 0
      elfIdx += 1
    else
      sum += x.toInt
  }
}
