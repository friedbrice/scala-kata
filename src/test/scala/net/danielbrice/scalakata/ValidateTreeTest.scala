package net.danielbrice.scalakata

import net.danielbrice.scalakata.ValidateTree._
import org.scalatest.{FlatSpec, Matchers}

class ValidateTreeTest extends FlatSpec with Matchers {

  "validateTree" should "validate single-leaf trees" in {
    // given: an empty tree
    lazy val t = Leaf(5)

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (true)
  }

  "validateTree" should "validate a correct one-branch tree" in {
    // given: a one-node tree
    lazy val t = Branch(Leaf(1), Leaf(2))

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (true)
  }

  "validateTree" should "invalidate an incorrect one-branch tree" in {
    // given: a one-node tree
    lazy val t = Branch(Leaf(2), Leaf(1))

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (false)
  }

  "validateTree" should "invalidate this awful tree" in {
    // given: a horrible, invalid tree
    lazy val t = Branch(Branch(Leaf(1), Leaf(3)), Leaf(2))

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: false should be returned
    result should be (false)
  }

  "validateTree" should "validate this wonderful tree" in {
    // given: a delightful, valid tree
    lazy val t = Branch(Branch(Leaf(1), Leaf(2)), Leaf(3))

    // when: validateTree is called
    lazy val result = validateTree(t)

    // then: true should be returned
    result should be (true)
  }
}
