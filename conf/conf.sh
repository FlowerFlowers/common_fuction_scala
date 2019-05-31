#!/usr/bin/env bash
#设置hdfs上的路径
path_pre="/user/vc/users/wyj/test/"

# 公共的配置文件
kinit -k -t /home/vc/client-vc.keytab vc/vc@guoyu.com

export SPARK_HOME=/data/guoyu/spark/
spark_home="$SPARK_HOME"

HADOOP_HOME=/data/guoyu/hadoop/
hadoop_bin="$HADOOP_HOME/bin/hadoop"
jar_file="target/common_function_scala-1.1.0-SNAPSHOT-jar-with-dependencies.jar"
#spark_submit是spark部署工具
function spark_submit {
    executor_memory=$1
    driver_memory=$2
    num_executors=$3
    executor_cores=$4
    job=$5
    $spark_home/bin/spark-submit \
      --class process.ExecuterMain \
      --master yarn \
      --master yarn \
      --executor-memory $executor_memory \
      --driver-memory   $driver_memory \
      --num-executors $num_executors \
      --executor-cores $executor_cores \
      --queue root.offline.vc \
      --conf 'spark.executor.memoryOverhead=2G' \
      --conf "spark.default.parallelism=600" \
      $jar_file $job
}
