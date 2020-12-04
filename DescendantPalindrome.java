package com.collection;

public class DescendantPalindrome {

	public static boolean palindromeDescendant(int num) {
		String numStr = String.valueOf(num);
		while (numStr.length() > 1) {
			if (isPalindrome(numStr)) {
				return true;
			} else {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < numStr.length(); i = i + 2) {
					int n = Character.getNumericValue(numStr.charAt(i))
							+ Character.getNumericValue(numStr.charAt(i + 1));
					sb.append(n);
				}
				return palindromeDescendant(Integer.valueOf(sb.toString()));
			}
		}
		return false;
	}

	private static boolean isPalindrome(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(palindromeDescendant(13001120));
		System.out.println(palindromeDescendant(11211230));
		System.out.println(palindromeDescendant(123312));
	}

}
