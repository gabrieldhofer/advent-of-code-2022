def left(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Boolean =
  !(for i <- 0 until y yield lines(x)(y).toInt <= lines(x)(i).toInt).contains(true)

def right(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Boolean =
  !(for i <- y+1 until w yield lines(x)(y).toInt <= lines(x)(i).toInt).contains(true)

def up(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Boolean =
  !(for i <- 0 until x yield lines(x)(y).toInt <= lines(i)(y).toInt).contains(true)

def down(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Boolean =
  !(for i <- x+1 until h yield lines(x)(y).toInt <= lines(i)(y).toInt).contains(true)

def isVisible(lines: Array[String], x: Int, y: Int, h: Int, w: Int): Boolean =
  left(lines, x, y, h, w) || right(lines, x, y, h, w) || up(lines, x, y, h, w) || down(lines, x, y, h, w)

def solve(lines: Array[String], h: Int, w: Int): IndexedSeq[(Int, Int, Int)] =
  for {
    i <- 1 until (h-1)
    j <- 1 until (w-1)
  } yield (if isVisible(lines, i, j, h, w) then (i, j, 1) else (i, j, 0))

@main
def main(): Unit =
  val lines = fromFile("src/main/scala/in.txt").getLines().toArray
  val h = lines.length
  val w = lines(0).length
  val part1 = 2*w + 2*h - 4
  val part2 = solve(lines, h, w)
  println(part2)
  val part3 = part2.map(x => x._3).sum
  //println("Answer: " + (part1.toInt + part3.toInt))

  println("h: " + h + " w: " + w)
  println("border: " + (2*h + 2*w - 4))
  println("---------------------------------------------")
  val a = 35
  val b = 35
  println("left:  " + left(lines, a, b, h, w))
  println("right: " + right(lines, a, b, h, w))
  println("up:    " + up(lines, a, b, h, w))
  println("down:  " + down(lines, a, b, h, w))
  println("---------------------------------------------")
  println("part1: " + part1)
  println("part2: " + part2)
  println("total: " + (part1 + part3))
