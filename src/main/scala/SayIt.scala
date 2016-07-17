import SayIt._
import org.scalatest.FlatSpec

object SayIt {

  /**
   * II. SayIt
   *
   * Given: your function might be called with a string or with no argument,
   *
   * When: your function is called with a string or without an argument,
   *
   * Then: if your function was called with a string, then that string is appended
   * to a closure accumulator, if your function was called with nothing, then the
   * accumulator is printed to the console.
   *
   * Special Requirement: This is trivial to implement using classes/object. The
   * purpose of this example is to capture the same behavior of encapsulated state
   * in a closure.
   */

  def sayIt
    : Option[String] => Unit
    = maybeString    => ???
    // TODO: The type signature here is wrong. I'd like it to automatically coerce to Optional[String]
}

class SayItTests extends FlatSpec {

  "sayIt" should "do nothing if argument is null" in {
    // given: nothing

    // when: sayIt is called with no argument
    sayIt()

    // then: nothing should be printed
    // TODO: how to check that IO happened/didn't happen?
  }

  "sayIt" should "be chainable" in {
    // given: nothing

    // when: sayIt is called with a string and a null
    val temp = sayIt("hi")

    // then: temp should be a function
    // TODO: how to assert something's type?
  }

  "sayIt" should "do nothing when the last argument is not null" in {
    // given: nothing

    // when: sayIt is chained with two strings
    sayIt("hi")(" there")

    // then: nothing should be printed
    // TODO: how to check that IO happened/didn't happen?
  }

  "sayIt" should "model state" in {
    // given: nothing

    // when: sayIt is chained with multiple arguments, the last being null
    sayIt("hi")(" there")(" you")()

    // then: "hi there you" should be printed
    // TODO: how to check that IO happened/didn't happen?
  }
}
