import java.util.Date
import java.text.SimpleDateFormat
import java.util.Calendar


class DateAndTime {
    val now = new Date()
    //now和now2的结果是一致的，都是获得当前时间的字符串，eg:Thu Apr 25 18:33:53 CST 2019
    //Calendar.getInstance()返回的是一个实例，eg:java.util.GregorianCalendar[time=1556188672748,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Shanghai",offset=28800000,dstSavings=0,useDaylight=false,transitions=19,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2019,MONTH=3,WEEK_OF_YEAR=17,WEEK_OF_MONTH=4,DAY_OF_MONTH=25,DAY_OF_YEAR=115,DAY_OF_WEEK=5,DAY_OF_WEEK_IN_MONTH=4,AM_PM=1,HOUR=6,HOUR_OF_DAY=18,MINUTE=37,SECOND=52,MILLISECOND=748,ZONE_OFFSET=28800000,DST_OFFSET=0]
    val now2 = Calendar.getInstance().getTime()
    //getTime是把时间字符串转化为时间戳，从1970-01-01-08：00开始计算，单位是毫秒,eg:1556188672023
    val timeStamp = now.getTime


  //两个函数效果一致，一个是通过时间戳的加减得到24小时之前的时间戳，一个是通过更改cal实例的值后获得时间戳
  //输出eg:1556103138662
  def getYesterdayStamp():Long ={
    val nowTimeStamp = now.getTime
    val yesterdayTimeStamp = nowTimeStamp - (1000*60*60*24)
    yesterdayTimeStamp
  }
  def getYesterdayStamp2():Long ={
    val cal = Calendar.getInstance()
    cal.add(Calendar.DAY_OF_MONTH,-1)
    cal.getTime.getTime()
  }

  //格式化时间 转化为 时间戳，时间格式yyyy-MM-dd HH:mm:ss
  def tranFormatTimeToStamp(tm:String) :Long={
    val fm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    //dt = Fri Apr 12 23:37:00 CST 2019
    val dt = fm.parse(tm)
    //stamp = 1555083420000
    val stamp: Long = dt.getTime()
    stamp
  }

  //时间戳 转化为 格式化时间
  def tranTimeStampToFormatTime(time_stamp:String):String={
    val time_string = new Date(time_stamp.toLong)
    val dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss")
    val format_time = dateFormat.format( time_string )
    format_time
  }


  def getNowWeekStart()={
    val cal:Calendar =Calendar.getInstance();
    val df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
    //获取本周一的日期
    //periodFormat=2019-04-22
    val periodFormat=df.format(cal.getTime())
    //periodString=Mon Apr 22 00:00:00 CST 2019
    val periodString = df.parse(periodFormat)

    periodString
  }

/*
Calendar的字段
val ERA: Int = 0
val YEAR: Int = 1
val MONTH: Int = 2
val WEEK_OF_YEAR: Int = 3
val WEEK_OF_MONTH: Int = 4
val DATE: Int = 5
val DAY_OF_MONTH: Int = 5
val DAY_OF_YEAR: Int = 6
val DAY_OF_WEEK: Int = 7
val DAY_OF_WEEK_IN_MONTH: Int = 8
val AM_PM: Int = 9
val HOUR: Int = 10
val HOUR_OF_DAY: Int = 11
val MINUTE: Int = 12
val SECOND: Int = 13
val MILLISECOND: Int = 14
val ZONE_OFFSET: Int = 15
val DST_OFFSET: Int = 16
 */

  //获取当前日期的字段
  //Calendar中，月份从0开始计数，星期天是一周的第一天.....
  def getCalendar() ={
    val calenda = Calendar.getInstance()
    println(calenda.get(Calendar.MONTH))
    println(calenda.get(Calendar.DAY_OF_YEAR))
  }

  def setCalendar()={
    val calendar = Calendar.getInstance()
    //共有两种方式修改日期，一种是设置对应的字段，一种是按照固定格式设置
    calendar.set(2019,8,3,13,50)
    calendar.set(Calendar.DAY_OF_WEEK,4)
    calendar.getTime()
  }

  //对calnedar的相应字段进行运算，正数就是+，负数就是减
  def addCalendar() ={
    val calendar = Calendar.getInstance()
    //Fri Apr 26 11:36:54 CST 2019
    println(calendar.getTime())
    calendar.add(Calendar.DATE,10)
    //Mon May 06 11:36:54 CST 2019
    println(calendar.getTime())
  }

  //roll和add的区别是add加减后会自动进位，比如日进位到月
  def rollCalendar()={
    val calendar = Calendar.getInstance()
    //Fri Apr 26 11:39:06 CST 2019
    println(calendar.getTime())
    calendar.roll(Calendar.DATE,10)
    //Sat Apr 06 11:39:06 CST 2019
    println(calendar.getTime())
  }
}
