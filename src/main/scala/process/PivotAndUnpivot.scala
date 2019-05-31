package process
import org.apache.spark.sql.types._
import org.apache.spark.sql._
import utils.SparkBuild._
import org.apache.spark.sql.functions._

class PivotAndUnpivot {
  def createDF()={
    val schema = StructType(List(
      StructField("年月", StringType, nullable = false),
      StructField("项目", StringType, nullable = true),
      StructField("收入", IntegerType, nullable = true)
    ))
    val rdd = spark.sparkContext.parallelize(Seq(
      Row("2018-01","项目1",100),
      Row("2018-01","项目2",200),
      Row("2018-01","项目3",300),
      Row("2018-02","项目1",1000),
      Row("2018-02","项目2",2000),
      Row("2018-02","项目1",1),
      Row("2018-03","项目x",999)
    ))
    val df = spark.createDataFrame(rdd, schema)
    df
  }

  def pivotDF()={
    val df = createDF()
    val df_pivot = df.groupBy("年月").pivot("项目").agg(sum("收入")).na.fill(0)
    df_pivot
  }

  def unpivotDF(df:DataFrame)={
    //selectExpr 是select的拓展，中间的列可以使用sql表达式
    //stack(n, expr1, ..., exprk)  是把后续的东西分割成n行
    val df_stack = df.selectExpr("`年月`","stack(4, '项目1', `项目1`,'项目2', `项目2`, '项目3', `项目3`, '项目x', `项目x`) as (`项目`,`收入`)")
      .filter("`收入` > 0 ")
    df_stack
  }

  def run()={
    val df = createDF()
    print("原始的dataframe如下：")
    df.show()
    val df_pivot = pivotDF()
    print("按照'年月'分组，对'项目'透视，对'收入'求和的结果如下：")
    df_pivot.show()


  }
}
