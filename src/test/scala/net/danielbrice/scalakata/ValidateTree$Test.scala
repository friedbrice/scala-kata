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

  "validateTree" should "???" in {
    // given: ???

    // when: ???

    // then: ???
  }
}
