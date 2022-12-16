def getLines: Array[Array[String]] =
  fromFile("src/main/scala/in.txt").getLines()
    .toArray
    .map(x => x.split(" "))

def process(acc: List[(Int, Int)], item: Array[String]): List[(Int, Int)] =
  val cycleCnt = acc.last._1
  val registerX = acc.last._2
  item(0) match
    case "noop" => acc :+ (cycleCnt + 1, registerX)
    case _ => acc :+ (cycleCnt + 1, registerX) :+ (cycleCnt + 2, registerX + item(1).toInt)

def getSpritePositions: List[(Int, Int)] =
  getLines.foldLeft(List[(Int, Int)]((1, 1)))(process)

def row1(spritePositions: List[(Int, Int)]): String =
  spritePositions.foldLeft("")((acc, y) => if (((y._1 - 1) % 40) - y._2).abs <= 1 then acc ++ "#" else acc ++ "-")

@main
def main(): Unit =
  val spritePositions = getSpritePositions
  spritePositions.foreach(println)

  val crt = row1(spritePositions)
  println(crt)
  println()
  println(crt.substring(0,40))
  println(crt.substring(40,80))
  println(crt.substring(80,120))
  println(crt.substring(120,160))
  println(crt.substring(160, 200))
  println(crt.substring(200,240))
