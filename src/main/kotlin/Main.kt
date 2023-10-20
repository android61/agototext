val timeSeconds = 10
val minutes = timeSeconds / 60
val hours = minutes / 60

fun main() {

    println(agoToText(timeSeconds))
}

fun agoToText(timeSeconds: Int) = when {
    timeSeconds > 3 * 24 * 60 * 60 -> "был(а) давно"
    timeSeconds > 2 * 24 * 60 * 60 -> "был(а) позавчера"
    timeSeconds > 24 * 60 * 60 -> "был(а) вчера"
    timeSeconds > 60 * 60 -> "был(а) в сети $hours час${timeHours(hours)} назад"
    timeSeconds > 60 -> "был(а) в сети $minutes минут${timeMinutes(minutes)} назад"
    else -> "был(а) только что"
}

fun timeMinutes(minutes: Int) = when {
    minutes % 10 == 1 && minutes % 100 != 11 -> "у"
    minutes % 10 in 2..4 && minutes % 100 !in 12..14 -> "ы"
    else -> ""
}

fun timeHours(hours: Int) = when {
    hours == 1 || hours % 100 == 21 -> ""
    hours in 2..4 || hours % 100 > 21 -> "а"
    else -> "ов"
}
