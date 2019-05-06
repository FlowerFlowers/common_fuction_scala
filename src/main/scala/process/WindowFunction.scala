package process

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._
import utils.SparkBuild._
import spark.implicits._


class WindowFunction {

  //给dataframe添加索引,索引是单调递增的，但是不保证是连续是，因为是分布式分区处理
  def getIncreaseIndex(dataFrame: DataFrame) ={
    val index_data = dataFrame.withColumn("id", monotonically_increasing_id())
    index_data
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

  }

}

