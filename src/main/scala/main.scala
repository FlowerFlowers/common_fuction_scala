import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar

object main {
  def main(args: Array[String]): Unit ={
    //test DateAndTime
    val datetime = new DateAndTime()
    println(datetime.tranFormatTimeToStamp("2019-04-12 23:37:00"))
    val time_stamp = "1555083420861"
    println(datetime.tranTimeStampToFormatTime(time_stamp))


  }
}
