package net.danielbrice.scalakata

import net.danielbrice.scalakata.UsePolymorphicMapReduce._
import org.scalatest.{FlatSpec, Matchers}

class UsePolymorphicMapReduce$Test extends FlatSpec with Matchers {

  "smallestTwo" should "work for a two element list with smaller first" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(1,2)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,2)
    result should be ((1,2))
  }

  "smallestTwo" should "work for a two element list with smaller last" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(2,1)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,2)
    result should be ((1,2))
  }

  "smallestTwo" should "work for a three element list" in {
    // given: a list with two elements, the smaller coming first
    lazy val ints = List(5,1,7)

    // when: smallestTwo is called
    lazy val result = smallestTwo(ints)

    // then: result should be (1,5)
    result should be ((1,5))
  }

  "sumsProds" should "return (0,0,1,1) for empty list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List()

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (0,0,1,1)
    result should be ((0.0,0.0,1.0,1.0))
  }

  "sumsProds" should "duplicate the head of a singleton list" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((3.0,4.0))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (3,4,3,4)
    result should be ((3.0,4.0,3.0,4.0))
  }

  "sumsProds" should "work" in {
    // given: a list with two elements, the smaller coming first
    lazy val pairs = List((1.0,2.0),(3.0,4.0),(5.0,6.0))

    // when: smallestTwo is called
    lazy val result = sumsProds(pairs)

    // then: result should be (9,12,15,48)
    result should be ((9.0,12.0,15.0,48.0))
  }
}
