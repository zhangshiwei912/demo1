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

			System.out.println("1.��ѯ����            2.�˳�");
			String s = sc.next();
			if (s.equals("1")) {
				System.out.println("");
				System.out.println("���������");
				year = sc.nextInt();
				System.out.println("�������·�");
				month = sc.nextInt();

				islearyear = isLeapYear(year);
				days = getMonthDay(month);
				isweekday = isweekday();
				System.out.println("��\tһ\t��\t��\t��\t��\t��");
				// ���еı�־
				int sigln = 0;
				// ��ӡ�ո�
				for (int j = 0; j < isweekday; j++) {
					if (isweekday == 7)
						return;
					System.out.print("\t");
					sigln++;

				}
				// ��ӡ����
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
				System.out.println("ѡ����");
				break;
			}

		}
	}

	// ���ÿ�µ�1�������ڼ�
	public int isweekday() {

		// ����1.���Ѿ���װ�õ�calendar����ÿ�µĵ�һ�����ܼ�
		Calendar aa = Calendar.getInstance();
		aa.set(year, month - 1, 1);
		return aa.get(Calendar.DAY_OF_WEEK) - 1;
		// ����2.���������ϵ�һ�����㹫ʽ�õ���ÿ���µĵ�һ�����ܼ�
		// int sum = 0, count = 0;
		// for (int i = 1900; i < year; i++) {
		// if (isLeapYear(i))
		// count++;
		// }
		// for (int i = 0; i < month; i++)
		// sum += getMonthDay(i);
		// return ((sum + count + (year - 1900) * 365 - 1) % 7+2);

	}

	public boolean isLeapYear(int year1) // �ж��Ƿ�������
	{
		return ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0));
	}

	public int getMonthDay(int m) // ��ȡÿ���µ�����
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
