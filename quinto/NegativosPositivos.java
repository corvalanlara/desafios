package quinto;

public class NegativosPositivos {

	public static void main(String[] args) {
		int pos = 0;
		int neg = 0;
		int zero = 0;
		for (String el: args) {
			int num = Integer.parseInt(el);
			if (num > 0) {
				pos++;
			} else if (num < 0) {
				neg++;
			} else {
				zero++;
			}
		}
		System.out.printf("%d\n%d\n%d", pos, neg, zero);
	}

}
