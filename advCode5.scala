import scala.io.Source


def dir(x: Any): Unit = println(x.getClass.getMethods.map(_.getName).distinct.sorted.mkString(" "))

def vowels(str: String): Boolean = {
	val countA = str.count(_ == 'a') + str.count(_ == 'A')
	val countE = str.count(_ == 'e') + str.count(_ == 'E')
	val countI = str.count(_ == 'i') + str.count(_ == 'I')
	val count0 = str.count(_ == 'o') + str.count(_ == 'O')
	val countU = str.count(_ == 'u') + str.count(_ == 'U')
	val total = countA + countE + countI + count0 + countU

	val sums = List(countA,countE,countI,count0,countU,total)

	return sums.exists(_ >= 3)

}

def twoInARow(str: String): Boolean = {
	for( i <- 0 to str.length-2) {
		if (str(i) == str(i+1)) {
			return true
		}
	}
	return false
}

def prohibited(str: String, set: Set[String]): Boolean = {
	for( i <- 0 to str.length-2) {
		if (set contains str(i).toString+str(i+1).toString) {
			return true
		}
	}
	return false
}

val filename = "input5.txt"
val set = Set("ab","cd","pq","xy")
var count = 0

for (line <- Source.fromFile(filename).getLines) {
	(vowels(line) && twoInARow(line) && !prohibited(line,set)) match {
		case true => count +=1
		case false => println(line) 
	}
}
println(count)



