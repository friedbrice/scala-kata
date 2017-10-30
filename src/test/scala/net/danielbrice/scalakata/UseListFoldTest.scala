package net.danielbrice.scalakata

import org.scalatest.{FlatSpec, Matchers}

class UseListFoldTest extends FlatSpec with Matchers {

  import UseListFold._

  "smallestTwo" should "work" in {
    smallestTwo(scala.util.Random.shuffle(3 to 30).toList) shouldBe (3, 4)
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
