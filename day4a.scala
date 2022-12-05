import scala.io.StdIn.readLine
import scala.io.Source._
import scala.collection.mutable

def solve(lines: List[String]): Int = {
  val result = for x <- lines yield {
    val str = x.split(",")
    val r1: Array[Int] = str(0).split("-").map(x => x.toInt)
    val r2: Array[Int] = str(1).split("-").map(x => x.toInt)

    if ((r1(0) to r1(1)) intersect (r2(0) to r2(1))) == (r1(0) to r1(1)) then 1
    else if ((r1(0) to r1(1)) intersect (r2(0) to r2(1))) == (r2(0) to r2(1)) then 1
    else 0
  }
  result.foldLeft(0)(_ + _)
}

@main
def main(): Unit = {
  val lines = fromFile("src/main/scala/in.txt").getLines().toList
  println(solve(lines))
}
