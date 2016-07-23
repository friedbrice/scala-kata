package net.danielbrice.scalakata

object MapReduce {

  /**
   * VII. MapReduce
   *
   * Implement a function with type signature
   * `(A => B) => ((B, B) => B) => B => List[A] => B`.
   *
   * The only requirements are that it must be possible for the return value to
   * be different from the third argument and that it "preserves" the order of
   * the passed list (whatever that means).
   */

  def mapReduce[A,B]
    : (A => B) => ((B, B) => B) => B => List[A] => B
    = f        => g             => z => l       => ???
}
