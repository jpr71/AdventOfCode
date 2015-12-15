import scala.io.Source


def dir(x: Any): Unit = println(x.getClass.getMethods.map(_.getName).distinct.sorted.mkString(" "))

var filename = "input.txt"
var total = 0
for (line <- Source.fromFile(filename).getLines) {
	var result = line.split('x')
	var multiplication = 0
	var edges = List[Int]()
	var temp = 0
	var temp_sum = 0
	for (r<-result) {
		temp = r.toInt
		edges = edges:+temp
		temp_sum = edges.length match {
			case 2 => (2*edges(0)*edges(1))
			case 3 => (2*edges(0)*edges(2) + 2*edges(1)*edges(2))
			case _ => 0
		}
		multiplication += temp_sum
	}
	val min =  edges.filter(_ != edges.max)
	println(min.length)
	temp_sum = min.length match {
			case 2 => min(0)*min(1)
			case 1 => min(0)*edges.max
			case 0 => edges(0)*edges(1)
		}
	multiplication += temp_sum
	total += multiplication
	println(s"Line $total")
}