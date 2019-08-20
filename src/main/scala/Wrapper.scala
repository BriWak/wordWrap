import scala.annotation.tailrec

object Wrapper {

  def wrap(textToWrap: String, col: Int): String = {
    @tailrec
    def wrapHelper(textToWrap: String, col: Int, acc: List[String]): List[String] = {
      val (firstPart, secondPart) = textToWrap.splitAt(col)
      val spaceLocation: Int = firstPart.lastIndexOf(' ')
      val (colOne, colTwo) = if (firstPart.contains(' ')) textToWrap.splitAt(spaceLocation) else (firstPart, secondPart)

      if (textToWrap.length <= col)
        acc :+ textToWrap
      else
        wrapHelper(colTwo.trim, col, acc :+ colOne.trim)
    }

    wrapHelper(textToWrap, col, Nil).mkString("\n")
  }

}
