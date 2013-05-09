<%@ tag language="java" pageEncoding="UTF-8" import="org.joda.time.*"%>
<%@ attribute name="value" type="org.joda.time.DateTime" required="true"%>
<%
	DateTime now = DateTime.now();
	int seconds = Seconds.secondsBetween(value, now).getSeconds();
	int minutes = Minutes.minutesBetween(value, now).getMinutes();
	int hours = Hours.hoursBetween(value, now).getHours();
	int days = Days.daysBetween(value, now).getDays();
	int months = Months.monthsBetween(value, now).getMonths();
	int years = Years.yearsBetween(value, now).getYears();

	if (minutes < 1) {
		out.print(seconds + "秒钟前");
	} else if (hours < 1) {
		out.print(minutes + "分钟前");
	} else if (days < 1) {
		out.print(hours + "小时前");
	} else if (months < 1) {
		out.print(days + "天前");
	} else if (years < 1) {
		out.print(months + "个月前");
	} else {
		out.print(years + "年前");
	}
%>