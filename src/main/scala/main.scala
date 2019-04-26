import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

object main {
  def main(args: Array[String]): Unit ={
    val datetime = new DateAndTime()
    println(datetime.tranFomatTimeToStamp("2019-04-12 23:37:00"))
    println(datetime.getTime())
  }
}
