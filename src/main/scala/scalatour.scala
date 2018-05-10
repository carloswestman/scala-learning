package scalatour

import org.scalatest._
class scalatour{

  def hello = "hello from package"

  def s1_basics = {

  	//expresions
    println(1) // 1
	  println(1 + 1) // 2
	  println("Hello!") // Hello!
	  println("Hello," + " world!") // Hello, world!

	  //values and variables
	  val x = 5
	  val y : Int = 2
	  // x = 3 x is inmutable, this generates a compile error
	  var w = 4
	  var z : Int =  5
	  z = 6

	  //blocks return the result of last expression
	  assert({
      val x = 1 + 1
      x + 1
    } == 3)

    //functions
    //(x: Int) => x + 1 // anonymous function alone stops code?
    var inc = (x: Int) => x + 1
    println(inc(1))
    val add = (x: Int, y: Int) => x + y
    println(add(1, 2)) // 3 
    val getTheAnswer = () => 42 // no parameter function
    println(getTheAnswer()) // 42 
    val multilineFunction = (x: Int) => { 
    	val y = x + 1
    	y * x } // this is ugly but functions can be multilined

    //methods
    def add2(x: Int, y: Int): Int = x + y // define output type and can be multilined
    def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
    println(addThenMultiply(1, 2)(3)) // 9, can have several parameter lists and are multilined

    //classes
    class Greeter(prefix: String, suffix: String) {
    def greet(name: String): Unit =
    println(prefix + name + suffix)
    }
    val greeter = new Greeter("Hello, ", "!")
    var greeter2 = new Greeter("Hola, ", "!!")
    greeter.greet("Scala developer") // Hello, Scala developer!
    greeter2.greet("Lenie")

    //case classes
    case class Point(x: Int, y: Int)
    val point = Point(1, 2) // by default values
    var point2 = Point(1, 2)
    assert(point == point2) // inmutable and comparable by value


  }

}