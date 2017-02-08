package com.nikolavp.warmup;

import java.util.Scanner;

/**
 * @author Nikola Petrov nikola.petrov@ontotext.com
 */
public class TimeConversion {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String time = scanner.next();
		boolean isPM = time.endsWith("PM");
		time = time.substring(0, time.length() - 2);
		int first = Integer.parseInt(String.valueOf(time.charAt(0)));
		int second = Integer.parseInt(String.valueOf(time.charAt(1)));
		if (isPM) {
			if (first != 1 || second != 2) {
				first++;
				second += 2;
			}
		} else {
			if (first > 0 && second > 1) {
				first--;
				second -= 2;
			}
		}
		System.out.println(new StringBuilder()
				.append(first)
				.append(second)
				.append(time.substring(2))
		);
	}
}
