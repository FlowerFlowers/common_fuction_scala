package utils
import org.apache.spark.sql.SparkSession

object SparkBuild {

  def getSparkSession(): SparkSession = {
    val spark =SparkSession.builder()
      .appName("action_log")
      .enableHiveSupport()
      .config("hive.exec.dynamic.partition", "true")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
      .getOrCreate()
    spark
  }

  val spark =getSparkSession()

}
