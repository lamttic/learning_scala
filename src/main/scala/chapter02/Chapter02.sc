// 1
val x = 22.5
val mulNine = x * 9
val divideFive = mulNine / 5
val plusThirtyTwo = divideFive + 32

// 2
val cToF: Int = 22.5.toInt * 9 / 5 + 32

// 3
val input = 2.7255
val output = "You owe $" + f"${input}%.2f."

// 4
val flag: Boolean = false
val result: Boolean = !flag

// 5
val intValue = 128
val charValue = intValue.toChar
val stringValue = intValue.toString
val doubleValue = intValue.toDouble

charValue.toInt
stringValue.toInt
doubleValue.toInt

// 6
val phoneBook = "Frank,123 Main,925-555-1943,95122"
val pattern = """.*([\d]{3}-[\d]{3}-[\d]{4}).*""".r
val pattern(phoneNumber) = phoneBook
val splitPhoneNumber = phoneNumber.split("-").map(_.toInt)
val tuplePhoneNumber = (splitPhoneNumber(0), splitPhoneNumber(1), splitPhoneNumber(2))

