

class datetime {
/*
  //时间转化为时间戳，时间格式yyyy-MM-dd HH:mm:ss
  def tranTimeToStamp(tm:String) :Long={
    val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dt = fm.parse(tm)
    val aa = fm.format(dt)
    val stamp: Long = dt.getTime()
    stamp
  }

  //获取当前日期yyyyMMdd
  def getNowTime():String={
    val now:Date = new Date()
    val dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyyMMdd")
    val nowDate = dateFormat.format( now )
    nowDate
  }

 */
def getCurrentStamp(): Long = {
  val now = new Date()
  val timeStamp = now.getTime
  timeStamp
}

def getYesterdayStamp():Long ={
  val now = new Date()
  val nowTimeStamp = now.getTime
  val yesterdayTimeStamp = nowTimeStamp - (1000*60*60*24)
  yesterdayTimeStamp
}

}
