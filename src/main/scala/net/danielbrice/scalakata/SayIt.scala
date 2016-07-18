package net.danielbrice.scalakata

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
