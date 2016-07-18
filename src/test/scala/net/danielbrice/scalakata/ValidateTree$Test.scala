package net.danielbrice.scalakata

import net.danielbrice.scalakata.ValidateTree._
import org.scalatest.{FlatSpec, Matchers}

class ValidateTree$Test extends FlatSpec with Matchers {

  "validateTree" should "validate empty trees" in {
    // given: an empty tree
    lazy val t = Leaf

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (true)
  }

  "validateTree" should "validate a one-node tree" in {
    // given: a one-node tree
    lazy val t = Branch[Int](1, Leaf, Leaf)

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (true)
  }

  "validateTree" should "invalidate this awful tree" in {
    // given: a horrible, invalid tree
    lazy val t = Branch[Int](1, b, Leaf)
    lazy val b = Branch[Int](2, Leaf, Leaf)

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: false should be returned
    result should be (false)
  }
}
