package util.string;

import java.util.ArrayList;

class MyString {

	final private char[] value;

	public MyString(String str) {
		value = str.toCharArray();
	}

	public int indexOf(String str) {
		return indexOf(str, 0);
	}

	public int indexOf(String str, int from) {
		char[] a = str.toCharArray();
		for (int i = from; i <= value.length - a.length; i++) {

			if (value[i] == a[0]) {
				boolean flag = true;
				for (int j = 0; j < a.length; j++) {
					if (value[i + j] != a[j]) {
						flag = false;
						break;
					}
				}
				if (flag)
					return i;
			}
		}
		return -1;
	}

	public String subString(int start, int end) {
		char[] a = new char[end - start];
		if (value.length < end || start < 0) {
			return null;
		}
		for (int i = start; i < end; i++) {
			a[i - start] = value[i];
		}
		return String.valueOf(a);
	}

	public String[] split(String str) {
		char[] a = str.toCharArray();
		ArrayList<String> list = new ArrayList<>();
		int next, off = 0;
		while ((next = indexOf(str, off)) != -1) {
			list.add(subString(off, next));
			off = next + a.length;
		}
		if(off!=value.length)
			list.add(subString(off,value.length));

		String [] result = new String[list.size()];
		for(int i = 0;i<result.length;i++){
			result[i] = list.get(i);
		}
		return list.subList(0, result.length).toArray(result);
	}

}
