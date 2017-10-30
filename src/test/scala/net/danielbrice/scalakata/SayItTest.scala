package net.danielbrice.scalakata

import net.danielbrice.scalakata.SayIt._
import org.scalatest.{FlatSpec, Matchers}

class SayItTest extends FlatSpec with Matchers {

  "sayIt" should "return a function" in {
    sayIt("foo") shouldBe a[Function[_,_]]
  }

  "sayIt" should "be chainable" in {
    val res1 = sayIt("foo")
    res1 shouldBe a[Function[String,_]]

    val res2 = res1.asInstanceOf[Function1[String,_]]("bar")
    res2 shouldBe a[Function[String,_]]
  }

  "sayIt" should "return a function that take no arguments" in {
    sayIt("foo") shouldBe a[Function0[_]]
  }

  "sayIt" should "model state" in {
    sayIt("Hello")
      .asInstanceOf[Function[String,_]](" there")
      .asInstanceOf[Function[String,_]](" pardner!")
      .asInstanceOf[Function0[String]]() shouldBe "Hello there pardner!"
  }
}
