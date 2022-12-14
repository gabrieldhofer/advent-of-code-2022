
def left(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Int =
  for i <- y-1 to 0 by -1 do
    if lines(x)(y).toInt <= lines(x)(i).toInt then return y - i
  y

def right(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Int =
  // !(for i <- y+1 until w yield lines(x)(y).toInt <= lines(x)(i).toInt).contains(true)
  for i <- y+1 until w do
    if lines(x)(y).toInt <= lines(x)(i).toInt then return i - y
  w - y - 1

def up(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Int =
  //!(for i <- 0 until x yield lines(x)(y).toInt <= lines(i)(y).toInt).contains(true)
  for i <- x-1 to 0 by -1 do
    if lines(x)(y).toInt <= lines(i)(y).toInt then return x - i
  x

def down(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Int =
  //!(for i <- x+1 until h yield lines(x)(y).toInt <= lines(i)(y).toInt).contains(true)
  for i <- x+1 until h do
    if lines(x)(y).toInt <= lines(i)(y).toInt then return i - x
  h - x - 1

def isVisible(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Int =
  left(lines, x, y, h, w) * right(lines, x, y, h, w) * up(lines, x, y, h, w) * down(lines, x, y, h, w)

def solve(lines: Array[String], h: Int, w: Int): IndexedSeq[Int] =
  for {
    i <- 1 until (h-1)
    j <- 1 until (w-1)
  } yield isVisible(lines, i, j, h, w)

@main
def main(): Unit =
  val lines = fromFile("src/main/scala/in.txt").getLines().toArray
  val h = lines.length
  val w = lines(0).length
  val part2 = solve(lines, h, w)
  println(part2)
  val part3 = part2.max
  println("part 3: " + part3)
