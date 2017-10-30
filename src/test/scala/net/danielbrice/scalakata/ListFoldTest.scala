package net.danielbrice.scalakata

import org.scalatest.{FlatSpec, Matchers}

class ListFoldTest extends FlatSpec with Matchers {

  import ListFold._

  "listFold" should "return the second argument if the list is empty" in {
    val n = scala.util.Random.nextInt
    listFold(Nil, n)((_: Int) + (_: Int)) shouldBe n
  }

  "listFold" should "not always return the second argument" in {
    listFold(List(1, 2, 3), 0)((_: Int) + (_: Int)) shouldBe 6
  }

  "listFold" should "preserve the order of the list" in {
    listFold(List("Hello", " there", " pardner!"), "")(_ + _) shouldBe
      "Hello there pardner!"
  }
}
