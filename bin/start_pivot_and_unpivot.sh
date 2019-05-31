#!/usr/bin/env bash
#!/usr/bin/env bash
source ./conf/conf.sh
spark_submit "15G" "10G" 20 10 "pivot_and_unpivot 1 2"

