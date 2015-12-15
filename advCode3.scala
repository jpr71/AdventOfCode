import scala.io.Source


def dir(x: Any): Unit = println(x.getClass.getMethods.map(_.getName).distinct.sorted.mkString(" "))

def direction(moveTo: Char, location: (Int,Int)): (Int,Int) = {
	val new_location = moveTo match {
		case '^' => location.copy(_2 = location._2 + 1)
		case 'v' => location.copy(_2 = location._2 - 1)
		case '>' => location.copy(_1 = location._1 + 1)
		case '<' => location.copy(_1 = location._1 - 1)
	}
	new_location
}

val filename = "input3.txt"
var location = (0,0)
val visited = collection.mutable.Set(location)
for (line <- Source.fromFile(filename).getLines) {
	for (moveTo <- line) {
		location = direction(moveTo, location)
		visited contains location match {
			case false => visited += location
			case _ => println(location) 
		}
	}
}
println(visited.size)