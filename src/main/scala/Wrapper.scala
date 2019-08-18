
object Wrapper {

  def wrap(textToWrap: String, col: Int): String = {
    val (firstPart, secondPart) = textToWrap.splitAt(col)
    val spaceLocation: Int = firstPart.lastIndexOf(' ')
    val (colOne, colTwo) = if (firstPart.contains(' ')) textToWrap.splitAt(spaceLocation) else (firstPart, secondPart)

    if (textToWrap.length <= col)
      textToWrap
    else
      s"${colOne.trim}\n${wrap(colTwo.trim, col)}"
  }

}
