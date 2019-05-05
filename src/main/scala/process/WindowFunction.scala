package process

import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._


class WindowFunction {

  //给dataframe添加索引,索引是单调递增的，但是不保证是连续是，因为是分布式分区处理
  def getIncreaseIndex(dataFrame: DataFrame) ={
    val index_data = dataFrame.withColumn("id", monotonically_increasing_id())
    index_data
  }

}
