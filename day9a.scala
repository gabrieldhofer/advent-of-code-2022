
def getLines: Array[Array[String]] =
  fromFile("src/main/scala/in.txt").getLines()
    .toArray
    .map(x => x.split(" "))

def nextPosition(h: Int, t: Int): Int = t + ((h-t)/2)

def op(arr: Array[(Int, Int)], move: Array[String]): Array[(Int, Int)] =
  val x = arr.last._1
  val y = arr.last._2
  val delta = move(1).toInt
  move(0) match
    case "D" => arr :+ (x - delta, y)
    case "U" => arr :+ (x + delta, y)
    case "R" => arr :+ (x, y + delta)
    case _   => arr :+ (x, y - delta)

def op2(arr: Array[(Int, Int)], headPos: (Int, Int)): Array[(Int, Int)] =
  val headX = headPos._1
  val headY = headPos._2
  val tailX= arr.last._1
  val tailY = arr.last._2
  if headX == tailX || headY == tailY || (Math.abs(headX - tailX) + Math.abs(headY - tailY)) == 2 then
    val nextTailX = nextPosition(headX, tailX)
    val nextTailY = nextPosition(headY, tailY)
    arr :+ (nextTailX, nextTailY)
  else
    val nextTailX = tailX + (if (headX - tailX) > 0 then 1 else -1)
    val nextTailY = tailY + (if (headY - tailY) > 0 then 1 else -1)
    arr :+ (nextTailX, nextTailY)

def solve(lines: Array[Array[String]]): Int =
  val headPositions: Array[(Int, Int)] = lines.foldLeft(Array((0, 0)))(op)
  val tailPositions: Array[(Int, Int)]  = headPositions.drop(1).foldLeft(Array((0, 0)))(op2)
  tailPositions.distinct.length

def createSteps(acc: Array[Array[String]], line: Array[String]): Array[Array[String]] =
  acc ++ (for x <- 1 to line(1).toInt yield Array(line(0), "1")).toArray

@main
def main(): Unit =
  val lines = getLines.foldLeft(Array[Array[String]]())(createSteps)
  val ans = solve(lines)
  println("try this: " + ans)
