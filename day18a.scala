def getLines: Array[Array[String]] =
  fromFile("src/main/scala/in.txt").getLines()
    .toArray
    .map(x => x.split(",| "))

def isAdjacent(a: Array[String], b: Array[String]): Int =
  return if Math.abs(a(0).toInt - b(0).toInt) +
    Math.abs(a(1).toInt - b(1).toInt) +
    Math.abs(a(2).toInt - b(2).toInt) == 1 then 1 else 0

def countAdjacent(lines: Array[Array[String]]): Int =
  (for ( x <- lines; y <- lines ) yield isAdjacent(x, y)).sum

@main
def main(): Unit =
  val lines = getLines
  val lineCnt = lines.length
  val ans = 6 * lineCnt - countAdjacent(lines)
  println("try this: " + ans)
