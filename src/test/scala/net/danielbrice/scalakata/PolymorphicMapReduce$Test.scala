package net.danielbrice.scalakata

import net.danielbrice.scalakata.PolymorphicMapReduce._
import org.scalatest.{FlatSpec, Matchers}

class PolymorphicMapReduce$Test extends FlatSpec with Matchers {

  "mapReduce" should "return z when called on List()" in {
    // given: some f, g, and zs
    lazy val fStub = (x : Any) => x
    lazy val gStub = (x : Any) => (y : Any) => y

    val z1 : Unit = ()
    lazy val z2 : Int = 0
    lazy val z3 : Char = 'a'

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
    lazy val result1 = mapReduce((x : Int) => x)(g1)(z1)(l1)
    lazy val result2 = mapReduce((x : String) => x)(g2)(z2)(l2)
    lazy val result3 = mapReduce((x : Int) => x)(g3)(z3)(l3)

    // then: the results are not the zs
    result1 should be (3)
    result2 should be ("ba")
    result3 should be ("1a")
  }

  "mapReduce" should "apply f" in {
    // given: some f, g, z, and l
    lazy val f = (x : Int) => x * x
    lazy val g = (x : Int) => (y : Int) => x + y
    lazy val z = 0
    lazy val l = List(1,2,3)

    // when: mapReduce is called
    lazy val result = mapReduce(f)(g)(z)(l)

    // then: the result should be 14
    result should be (14)
  }

  "mapReduce" should "preserve order" in {
    // given: some f, g, z, and l
    lazy val f = (x : Int) => x.toString.head
    lazy val g = (x : Char) => (y : String) => x + y
    lazy val z = ""
    lazy val l = List(1,2,3)

    // when: mapReduce is called
    lazy val result = mapReduce(f)(g)(z)(l)

    // then: the result should be "123"
    result should be ("123")
  }
}
