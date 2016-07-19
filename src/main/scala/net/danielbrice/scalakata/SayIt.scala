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

  // a Sayable is a function : Option[String] => Sayable
  sealed trait Sayable extends Function1[Option[String], Sayable]

  // the SayableTerminate returns itself, regardless of argument
  case object SayableTerminate extends Sayable {
    def apply(optStr : Option[String]) : Sayable = SayableTerminate
  }

  // a Sayable Accumulate is given a function at construction
  // it simply applies the function it was given
  case class SayableAccumulate(f: Option[String] => Sayable) extends Sayable {
    def apply(optStr : Option[String]): Sayable = f(optStr)
  }

  // sayIt should take an Option[String] and return a Sayable
  // If the argument is Some(str), then we need to somehow store str
  // If the argument is None, then we need to println
  def sayIt
    : Option[String] => Sayable
    = optStr         => {

      ???

    }
}
