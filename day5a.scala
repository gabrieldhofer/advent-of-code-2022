import scala.io.StdIn.readLine
import scala.io.Source._
import scala.collection.mutable

def solve(lines: List[String]): Unit = {
  var arr = scala.collection.mutable.ArrayBuffer(
    "GDVZJSB",
    "ZSMGVP",
    "CLBSWTQF",
    "HJGWMRVQ",
    "CLSNFMD",
    "RGCD",
    "HGTRJDSQ",
    "PFV",
    "DRSTJ"
  )
  for x <- lines do {
    val move = x.split(" ")
    val amt = move(1).toInt
    val src = move(3).toInt - 1
    val dst = move(5).toInt - 1
    arr(dst) = arr(dst) ++ arr(src).substring(arr(src).length - amt).reverse
    arr(src) = arr(src).substring(0, arr(src).length - amt)
    arr.foreach(println)
  //WCZTHTMPS
  }
}

@main
def main(): Unit = {
  val lines = fromFile("src/main/scala/in.txt").getLines().toList
  println(solve(lines))
}
