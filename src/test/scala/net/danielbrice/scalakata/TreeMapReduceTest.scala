package net.danielbrice.scalakata

import net.danielbrice.scalakata.TreeMapReduce._
import org.scalatest.{FlatSpec, Matchers}

class TreeMapReduceTest extends FlatSpec with Matchers {

  "treeMapReduce" should "return z when passed Leaf" in {
    // given: some stubs
    val f = (x : Any) => x
    val g = (x: Any, y : Any) => y
    val z = 0

    // when: treeMapReduce is called on Leaf
    lazy val result = treeMapReduce(f)(g)(z)(Leaf)

    // then: result should be z
    result should be (z)
  }

  "treeMapReduce" should "apply g" in {
    // given: some stubs
    lazy val f = (x : Int) => x
    lazy val g = (x: Int, y : Int) => x + y
    lazy val z = 0
    lazy val b1 = Branch(1, b2, Leaf)
    lazy val b2 = Branch(2, Leaf, Leaf)

    // when: treeMapReduce is called
    lazy val result = treeMapReduce(f)(g)(z)(b1)

    // then: result should be z
    result should be (3)
  }

  "treeMapReduce" should "apply f" in {
    // given: some stubs
    lazy val f = (x : Char) => x.asDigit
    lazy val g = (x: Int, y : Int) => x + y
    lazy val z = 0
    lazy val b1 = Branch('1', b2, Leaf)
    lazy val b2 = Branch('2', Leaf, Leaf)

    // when: treeMapReduce is called
    lazy val result = treeMapReduce(f)(g)(z)(b1)

    // then: result should be z
    result should be (3)
  }

  "treeMapReduce" should "preserve order" in {
    // given: some stubs
    lazy val f = (x : Char) => x.toString
    lazy val g = (x: String, y : String) => x + y
    lazy val z = ""
    lazy val b1 = Branch('3', b2, b4)
    lazy val b2 = Branch('2', b3, Leaf)
    lazy val b3 = Branch('1', Leaf, Leaf)
    lazy val b4 = Branch('4', Leaf, Leaf)

    // when: treeMapReduce is called
    lazy val result = treeMapReduce(f)(g)(z)(b1)

    // then: result should be z
    result should be ("1234")
  }
}
