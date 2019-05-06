#!/usr/bin/env bash
source ./conf/conf.sh
max=1
for (( i=1; i <= $max; ++i ))
do
    echo "$i"
    day=`date -d"$i days ago" +%Y%m%d`
    pathout=$path_pre"data/test"$day
    spark_submit "15G" "10G" 20 10 "url_feature $day 2"

    $hadoop_bin fs -getmerge $pathout ./data/dataframe.$day
done
