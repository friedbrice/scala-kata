package net.danielbrice.scalakata

import org.scalatest.{FlatSpec, Matchers}

class TreeFoldTest extends FlatSpec with Matchers {

  import TreeFold._

  "treeFold" should "preserve the order of the tree" in {
    // given
    val tree = Branch(Branch(Leaf("a"), Leaf("b")), Branch(Leaf("c"), Leaf("d")))

    // when
    val res = treeFold(tree, identity[String], (l: String, r: String) => s"$l$r")

    // then
    res shouldBe "abcd"
  }
}
