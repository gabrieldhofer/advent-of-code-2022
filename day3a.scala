@main
def main(): Unit = {
  val lines = fromFile("src/main/scala/in.txt").getLines()
  val result = for x <- lines yield {
    val n: Int = x.length / 2
    val one: String = x.substring(0,n)
    val two: String = x.substring(n)
    var common: Char = '-'
    for y <- one do
      if two contains y then common = y
    for y <- two do
      if one contains y then common = y
    println("common: " + common)

    val lowercase = 'a' to 'z'
    val uppercase = 'A' to 'Z'
    val combined = lowercase ++ uppercase

    val myRange = 1 to 52
    val prioritiesList = combined zip myRange
    var prioritiesMap = scala.collection.mutable.Map[Char, Int]()
    for y <- prioritiesList do
      prioritiesMap(y._1) = y._2
    //prioritiesMap.foreach(println)
    prioritiesMap(common)
  }
  val ans = result.foldLeft(0)(_ + _)
  println(ans)
}
