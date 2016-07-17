import PolymorphicMapReduce._
import org.scalatest.FlatSpec

object PolymorphicMapReduce {

  /*
   * VII. PolymorphicMapReduce
   *
   * Implement a function with type signature
   * `(T => S) => (S => R => R) => R => List[T] => R`.
   *
   * The only requirement is that it must be possible for the return value to be
   * different from the third argument.
   */

  def mapReduce[T,S,R]
  : (T => S) => (S => R => R) => R => List[T] => R
  = f        => g             => z => l       => {

    ???

  }
}

object PolymorphicMapReduceTests {

  "mapReduce" should "return z when called on List()" in {
    // given: some f, g, and zs
    lazy val fStub = (x : Any) => x
    lazy val gStub = (x : Any) => (y : Any) => y

    lazy val z1 = ()
    lazy val z2 = 0
    lazy val z3 = 'a'

    // when: mapReduce is called with f, g, and zs, on List()
    lazy val result1 = mapReduce(fStub)(gStub)(z1)(List())
    lazy val result2 = mapReduce(fStub)(gStub)(z2)(List())
    lazy val result3 = mapReduce(fStub)(gStub)(z3)(List())

    // then: the results are the zs
    result1 should be (z1)
    result2 should be (z2)
    result3 should be (z3)
  }

  "mapReduce" should "apply g" in {
    // given: some gs, zs, and ls
    lazy val fStub = (x : Any) => x

    lazy val g1 = (x : Int) => (y : Int) => x + y
    lazy val z1 = 1
    lazy val l1 = List(2)

    lazy val g2 = (x : String) => (y : String) => x + y
    lazy val z2 = "a"
    lazy val l2 = List("b")

    lazy val g3 = (x : Int) => (y : String) => x + y
    lazy val z3 = "a"
    lazy val l3 = List(1)

    // when: mapReduce is called
    lazy val result1 = mapReduce(fStub)(g1)(z1)(l1)
    lazy val result2 = mapReduce(fStub)(g2)(z2)(l2)
    lazy val result3 = mapReduce(fStub)(g3)(z3)(l3)

    // then: the results are not the zs
    result1 should be (3)
    result2 should be ("ba")
    result3 should be ("1a")
  }

  "mapReduce" should "apply f" in {
    // given: some fs, gs, and zs
    lazy val f1 = (x : Int) => x * x
    lazy val g1 = (x : Int) => (y : Int) => x + y
    lazy val z1 = 0

    lazy val f2 = (x : Int) => x.toChar
    lazy val g2 = (x : Char) => (y : String) => x + y
    lazy val z2 = ""

    // when: mapReduce is called
    lazy val result1 = mapReduce(f1)(g1)(z1)(List(1,2,3))
    lazy val result2 = mapReduce(f2)(g2)(z2)(List(1,2,3))

    // then: the results are not the zs
    result1 should be (14)
    result2 should be ("123")
  }
}
