/**
	 * 将阿拉伯数字金额转换成汉字数字金额（仅限人民币）
	 * 
	 * @param amt
	 *            输入金额
	 * @return String 输出汉字大写金额
	 */
	public static String convAmtToChinese(String amt) {
		if (amt == null) {
			return "";
		}
		String s1 = "零壹贰叁肆伍陆柒捌玖";
		byte[] b1 = s1.getBytes();
		String s4 = "分角整元拾佰仟万拾佰仟亿拾佰仟";
		String temp = amt.trim();
		byte[] b2 = s4.getBytes();
		double d = 0.0;
		try {
			d = Double.parseDouble(temp);
			DecimalFormat format = new DecimalFormat("0.##");
			format.setDecimalSeparatorAlwaysShown(false);
			temp = format.format(d);
			// System.out.println(temp);
		} catch (Exception e) {
			// throw new Exception("转换大写金额失败："+temp+"不是数字类型,"+e.getMessage());
			return amt;
		}

		int len = 0;
		if (temp.indexOf(".") == -1) {
			len = temp.length();
		} else {
			len = temp.indexOf(".");
		}
		// System.out.println(len);
		// System.out.println(s4.length());
		// len是金额的整数位，金额单位超过千亿就会转换失败
		if (len > s4.length() - 3) {
			// throw new Exception("转换大写金额失败,长度错误,");
			return amt;
		}

		String result = "";
		int n1 = 0;
		String num = "";
		String unit = "";
		boolean first = false;
		// 是否需要打出“元” 如果为0.02则不需要
		boolean yuan = false;

		for (int i = 0; i < temp.length(); i++) {
			num = "";
			unit = "";

			// 打出的最小单位是分
			if (i > len + 2) {
				break;
			}
			if (i == len) {
				continue;
			}
			n1 = Integer.parseInt(String.valueOf(temp.charAt(i)));
			// System.out.println("当前字符:[" + n1 + "]");

			// 如果不为0
			if (n1 != 0) {
				if (first) {
					if (!yuan) {
						num = new String(new byte[] { b1[n1 * 3],
								b1[n1 * 3 + 1], b1[n1 * 3 + 2] });
					} else {
						num = "零"
								+ new String(new byte[] { b1[n1 * 3],
										b1[n1 * 3 + 1], b1[n1 * 3 + 2] });
					}

				} else {
					num = new String(new byte[] { b1[n1 * 3], b1[n1 * 3 + 1],
							b1[n1 * 3 + 2] });
					yuan = true;
				}

				// 设置0标志为false
				first = false;
			}

			if (n1 == 0) {
				first = true;
			}

			int n2 = n1;
			n1 = len - i + 2;

			// 当前面数字不为0， 或者到了"元"的时候
			if (n2 != 0 || n1 == 3) {
				if (n1 == 3 && num.length() == 0 && result.trim().length() == 0) {
					unit = "";
					first = false;
					yuan = false;
				} else {
					unit = new String(new byte[] { b2[n1 * 3], b2[n1 * 3 + 1],
							b2[n1 * 3 + 2] });
				}
			}

			result = result.concat(num).concat(unit);
			if (n2 == 0) {
				if (n1 == 7) {
					if (len < 9) {
						result = result.concat("万");
					} else {
						if (!"0000".equals(temp.substring(Math.abs(8 - len),
								Math.abs(8 - len) + 4))) {
							result = result.concat("万");
						}
					}
				}
				if (n1 == 11) {
					result = result.concat("亿");
				}
			}

			if (n1 == 3 || n1 == 7 || n1 == 11) {
				first = false;
			}
		}
		if ((len == temp.length()) || (len == temp.length() - 1)) {
			result = result.concat("整");
		}

		return result;
	}