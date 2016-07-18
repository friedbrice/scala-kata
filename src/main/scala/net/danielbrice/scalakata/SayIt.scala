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

  sealed trait Sayable {
    def apply(optStr : Option[String]) : Sayable
  }

  class SayableUnit(u : Unit) extends Sayable {
    val unit : Unit = u

    def apply(optStr : Option[String]) : Sayable = {
      new SayableUnit(u)
    }
  }

  class SayableFunction(f : Option[String] => Sayable) extends Sayable {
    val function : Option[String] => Sayable = f

    def apply(optStr : Option[String]) : Sayable = {
      this.function(optStr)
    }
  }

  def sayIt[T]
    : Option[String] => Sayable
    = optStr    => ???
}
