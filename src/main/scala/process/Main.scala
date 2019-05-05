package process
import utils.SparkBuild._
import spark.implicits._



object Main {
  def main(args: Array[String]): Unit ={
    //test DateAndTime
    val datetime = new DateAndTime()
    println(datetime.tranFormatTimeToStamp("2019-04-12 23:37:00"))
    val time_stamp = "1555083420861"
    println(datetime.tranTimeStampToFormatTime(time_stamp))
    testWindowFunction().show()

  }

  def testWindowFunction()={
    val orders = Seq(
      ("1", "s1", "2017-05-01", 100),
      ("2", "s1", "2017-05-02", 200),
      ("3", "s1", "2017-05-02", 200),
      ("4", "s2", "2017-05-01", 300),
      ("5", "s2", "2017-05-01", 100),
      ("6", "s3", "2017-05-01", 100),
      ("6", "s3", "2017-05-02", 50)
    ).toDF("order_id", "seller_id", "order_date", "price")
    val windowtest = new WindowFunction()
    windowtest.getIncreaseIndex(orders)
  }


}
