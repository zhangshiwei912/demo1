package test;

import java.util.Calendar;
import java.util.Scanner;

public class MyDate {
	static Scanner sc = new Scanner(System.in);
	int year;
	int month;
	boolean islearyear;
	int days;
	int isweekday;
	boolean start = true;

	public static void main(String[] args) {
		new MyDate().run();
	}

	public void run() {
		while (start) {

			System.out.println("1.查询日历            2.退出");
			String s = sc.next();
			if (s.equals("1")) {
				System.out.println("");
				System.out.println("请输入年份");
				year = sc.nextInt();
				System.out.println("请输入月份");
				month = sc.nextInt();

				islearyear = isLeapYear(year);
				days = getMonthDay(month);
				isweekday = isweekday();
				System.out.println("日\t一\t二\t三\t四\t五\t六");
				// 换行的标志
				int sigln = 0;
				// 打印空格
				for (int j = 0; j < isweekday; j++) {
					if (isweekday == 7)
						return;
					System.out.print("\t");
					sigln++;

				}
				// 打印日期
				for (int i = 1; i <= days; i++) {

					if (sigln == 7) {
						System.out.println("");
						sigln = 0;
					}
					System.out.print(i + "\t");
					sigln++;

				}
				System.out.println();

			} else if (s.equals("2")) {
				start = false;
				System.out.println("over!!!");
				break;
			} else {
				System.out.println("选错了");
				break;
			}

		}
	}

	// 获得每月的1号是星期几
	public int isweekday() {

		// 方法1.用已经封装好的calendar类获得每月的第一天是周几
		Calendar aa = Calendar.getInstance();
		aa.set(year, month - 1, 1);
		return aa.get(Calendar.DAY_OF_WEEK) - 1;
		// 方法2.我用了网上的一个计算公式得到了每个月的第一天是周几
		// int sum = 0, count = 0;
		// for (int i = 1900; i < year; i++) {
		// if (isLeapYear(i))
		// count++;
		// }
		// for (int i = 0; i < month; i++)
		// sum += getMonthDay(i);
		// return ((sum + count + (year - 1900) * 365 - 1) % 7+2);

	}

	public boolean isLeapYear(int year1) // 判断是否是闰年
	{
		return ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0));
	}

	public int getMonthDay(int m) // 获取每个月的天数
	{
		switch (m) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (isLeapYear(year))
				return 29;
			else
				return 28;
		default:
			return 0;
		}
	}

}
