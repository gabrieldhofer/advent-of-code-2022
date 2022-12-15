def getLines: Array[Array[String]] =
  fromFile("src/main/scala/in.txt").getLines()
    .toArray
    .map(x => x.split(" "))

def process(acc: List[(Int, Int)], item: Array[String]): List[(Int, Int)] =
  val cycleCnt = acc.last._1
  val registerX = acc.last._2
  item(0) match
    case "noop" => acc :+ (cycleCnt + 1, registerX)
    case _ => acc :+ (cycleCnt + 2, registerX + item(1).toInt)

def solve(): List[(Int, Int)] =
  getLines.foldLeft(List[(Int, Int)]((1, 1)))(process)

@main
def main(): Unit =
  solve().foreach(println)
  println("try this: " + (
      20*21 +
      60*21 +
      100*40 +
      140*21 +
      180*21 +
      220*21
    ))
