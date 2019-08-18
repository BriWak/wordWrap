import org.scalatest.{MustMatchers, WordSpec}

class WrapperSpec extends WordSpec with MustMatchers {

  "wrap" must {
    "return an empty string when given an empty string and a column number of 1" in {
      Wrapper.wrap("", 1) mustEqual ""
    }

    "return the full string if it is shorter than the column length" in {
      Wrapper.wrap("word", 10) mustEqual "word"
    }

    "return a word split at the column length when there are no spaces" in {
      Wrapper.wrap("word", 2) mustEqual "wo\nrd"
    }

    "return a word split 3 times when it is long enough without spaces and the column length is 3" in {
      Wrapper.wrap("longwords", 3) mustEqual "lon\ngwo\nrds"
  }

    "return two words wrapped at the space when there is a space at the column limit" in {
      Wrapper.wrap("word word", 5) mustEqual "word\nword"
    }

    "return two words wrapped at the space when there is a space after the column limit" in {
      Wrapper.wrap("word word", 6) mustEqual "word\nword"
    }

    "return two words wrapped correctly when the column limit is smaller than the words" in {
      Wrapper.wrap("word word", 3) mustEqual "wor\nd\nwor\nd"
    }

    "return two words wrapped at the space when there is a space immediately after the column limit" in {
      Wrapper.wrap("word word", 4) mustEqual "word\nword"
    }

    "return a correctly wrapped sentence of varying word lengths with a column limit of 10" in {
      val result = Wrapper.wrap("This is a test sentence to see if it can be wrapped correctly.", 10)

      result mustEqual "This is a\ntest\nsentence\nto see if\nit can be\nwrapped\ncorrectly."
    }
  }
}
