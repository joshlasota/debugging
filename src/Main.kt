import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun main(args: Array<String>) {

    // Get today's date
    val today = LocalDate.now() // to get current date / time

    // Set date format
    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")

    // Display today's date formatted
    val textToday = today.format(formatter)
    println("Today's date is: $textToday")

    /*
     * Get user's birth month and day
     */

    println("What month were you born in? (Enter as number: January = 1)")
    val myMonth = readLine()!!.toInt()
    println("What day were you born? ")
    val myDay = readLine()!!.toInt()

    // Get current year and month
    val myYear = today.year // assign year to current year
    val thisMonth = today.monthValue

    // Assign information to variable birthday
    var birthday = LocalDate.of(myYear, myMonth, myDay)

    /*
     * If birthday already happened this year, add one to year
     */

    // Check if the birthday has already passed this year
    if (birthday.isBefore(today) || (birthday.monthValue == today.monthValue && birthday.dayOfMonth < today.dayOfMonth)) {
        birthday = birthday.plusYears(1) // Add one year if birthday has passed
    }

    // Format the next birthday
    val nextBirthday = birthday.format(formatter)

    // Calculate days till next birthday
    val daysToBirthday = today.until(birthday, ChronoUnit.DAYS)

    /*
     * Check if today is the user's birthday
     */

    if (myMonth == thisMonth && myDay == today.dayOfMonth) {
        println("Happy Birthday!")
    } else {
        println("Your next birthday is: $nextBirthday")
        println("There are $daysToBirthday days till your next birthday!")
    }
}
