package net.danielbrice.scalakata

import net.danielbrice.scalakata.SmallestTwo._
import org.scalatest.{FlatSpec, Matchers}

class SmallestTwoTest extends FlatSpec with Matchers {

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
}
