package scalatour

import org.scalatest._
class Scalatour{

  def hello: String = "hello from package"

  def s1Basics: Unit = {

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
      y * x
    } // this is ugly but functions can be multilined

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

    //objects
    object IdFactory {
      private var counter = 0
      def create(): Int = {
        counter += 1
        counter
      }
    }
    println(IdFactory.create()) //1
    println(IdFactory.create()) //2

    //traits
    trait Greeter3 {
      def greet(name: String): Unit
    }

    trait Greeter4 {
      def greet(name: String): Unit =
        println("Hello, " + name + "!")
    }

    class DefaultGreeter extends Greeter4

    class CustomizableGreeter(prefix: String, postfix: String) extends Greeter4 {
      override def greet(name: String): Unit = {
        println(prefix + name + postfix)
      }
    }
    val greeter1 = new DefaultGreeter()
    greeter1.greet("Scala developer") // Hello, Scala developer!

    val customGreeter = new CustomizableGreeter("How are you, ", "?")
    customGreeter.greet("Scala developer") // How are you, Scala developer?   

  }
  def s2_unifiedtypes = {
    val list: List[Any] = List(
      "a string",
      732,  // an integer
      'c',  // a character
      true, // a boolean value
      () => "an anonymous function returning a string"
    )
    list.foreach(element => println(element))

    val x: Long = 987654321
    val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)

    val face: Char = '☺'
    val number: Int = face  // 9786

    val a: Long = 987654321
    val b: Float = a  // 9.8765434E8
    //val c: Long = b  // Does not conform
  }
}