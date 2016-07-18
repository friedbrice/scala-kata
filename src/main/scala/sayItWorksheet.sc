sealed trait Sayable {
  def apply(optStr : Option[String]) : Sayable
}

case class SayableUnit(u : Unit) extends Sayable {
  val unit : Unit = u

  def apply(optStr : Option[String]) : Sayable = {
    new SayableUnit(u)
  }
}

case class SayableFunction(f : Option[String] => Sayable) extends Sayable {
  val function : Option[String] => Sayable = f

  def apply(optStr : Option[String]) : Sayable = {
    this.function(optStr)
  }
}

def sayIt[T]
: Option[String] => Sayable
= optStr    => ???
