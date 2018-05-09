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
	assert( 1 == 1,  "expression not asserted")
  }

}