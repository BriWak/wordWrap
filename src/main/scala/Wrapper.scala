
object Wrapper {

  def wrap(textToWrap: String, col: Int): String = {
    val (first, second) = textToWrap.splitAt(col)
    val spaceLocation: Int = first.lastIndexOf(' ')

    val (colOne, colTwo) = if (first.contains(' ')) {
        textToWrap.splitAt(spaceLocation)
      } else {
      (first, second)
    }

    if (textToWrap.length <= col) {
      textToWrap
    } else {
      s"${colOne.trim}\n${wrap(colTwo.trim, col)}"
    }
  }


}
