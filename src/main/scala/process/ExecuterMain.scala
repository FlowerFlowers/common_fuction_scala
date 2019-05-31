package process
import utils.SparkBuild._
import spark.implicits._



object ExecuterMain {
  def main(args: Array[String]): Unit ={

    val cmd = args(0)
    val arg1 = args(1)
    val arg2 = args(2)

    cmd match {
      case "date_and_time" =>
        val date_and_time = new DateAndTime()
        date_and_time.run()
      case "pivot_and_unpivot" =>
        val pivot_and_unpivot = new  PivotAndUnpivot()
        pivot_and_unpivot .run()

    }

  }


}
