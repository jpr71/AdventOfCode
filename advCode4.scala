import scala.io.Source
import java.security.MessageDigest

// Santa needs help mining some AdventCoins (very similar to bitcoins) to use 
// as gifts for all the economically forward-thinking little girls and boys.

// To do this, he needs to find MD5 hashes which, in hexadecimal, start with 
// at least five zeroes. The input to the MD5 hash is some secret key (your 
// puzzle input, given below) followed by a number in decimal. To mine 
// AdventCoins, you must find Santa the lowest positive number (no leading
 // zeroes: 1, 2, 3, ...) that produces such a hash.

val digest = MessageDigest.getInstance("MD5")

val secretKey = "ckczppom"
var newString = ""

//Brute force solution
for( i <- 1 to 100000000) {
	newString = secretKey + i.toString
	val result = digest.digest(newString.getBytes).map("%02x".format(_)).mkString
	result.substring(0,5) == "00000" match {
		case true => println(i) 
		case false => None 
	}
	 
}
println("Not found")