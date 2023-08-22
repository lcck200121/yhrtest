package com.yhr.Util;



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.regex.Pattern;

public class ToolUtil {
	
	/**
	 * 判断对象是否为空
	 * @param o 需要判断的对象
	 * @return 为空返回true,不为空返回false
	 */
	@SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object o) {
        if (o == null) {
            return true;
        }
        if (o instanceof String) {
            if (o.toString().trim().equals("")) {
                return true;
            }
            if(o.toString().trim().equals("undefined")){
            	return true;
            }
        } else if (o instanceof List) {
            if (((List) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Set) {
            if (((Set) o).size() == 0) {
                return true;
            }
        } else if (o instanceof Object[]) {
            if (((Object[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof int[]) {
            if (((int[]) o).length == 0) {
                return true;
            }
        } else if (o instanceof long[]) {
            if (((long[]) o).length == 0) {
                return true;
            }
        }
        return false;
    }
	
	/**
	 * 
	 * 方法描述：string转int
	 * @author 李国文
	 * @date 日期：2017年6月18日  时间：下午4:10:37
	 * @version 1.0
	 * @param str
	 * @return
	 */
    public static int stringToInt(String str) {
        if(ToolUtil.isEmpty(str)){
            return 0;
        }else{
        	try {
        		 return Integer.parseInt(str);
			} catch (Exception e) {
				return 0;
			}
        }
    }
    
    /**
	 * 
	 * 方法描述：string转long
	 * @author 李国文
	 * @date 日期：2017年6月18日  时间：下午4:10:37
	 * @version 1.0
	 * @param str
	 * @return
	 */
    public static Long stringToLong(String str) {
        if(ToolUtil.isEmpty(str)){
            return 0l;
        }else{
        	try {
        		 return Long.parseLong(str);
			} catch (Exception e) {
				return 0l;
			}
        }
    }
    
    /**
     * 正则表达式：验证手机号
     */
    public static final String REGEX_MOBILE = "^1[3-9][0-9]{9}$";
	
    
    /**
     * 清除手机号格式
     * 
     * @param mobile
     * @return 清除手机号格式(\n,\r,空格)
     */
    public static String replaceMobile(String mobile) {
    	String phone = mobile;
    	//清除格式的操作
    	phone = phone.replaceAll("\n", "");
		phone = phone.replaceAll("\r", "");
		phone = phone.trim();
    	//返回
        return phone;
    }
    
    /**
     * 校验手机号
     * 
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }

	/**
	 * 方法描述：获取随机数
	 * 
	 * @author 李国文
	 * @date 日期：2017年7月3日 时间：下午12:10:51
	 * @version 1.0
	 * @param num
	 *            随机数位数
	 * @return
	 */
	public static String generateRandomStr(int num) {
		String[] vec = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		num = num <= 0 ? 1 : num;
		StringBuffer str = new StringBuffer(10);
		for (int i = 0; i < num; i++) {
			int r1 = Long.valueOf(Math.round(Math.random() * (vec.length - 1))).intValue();
			str.append(vec[r1]);
		}
		return str.toString();
	}

	/**
	 * 方法描述：判断通道类型
	 * 
	 * @author 李国文
	 * @date 日期：2016-9-27 时间：下午3:24:37
	 * @version 1.0
	 * @param channelid
	 * @param channel_id
	 * @return
	 */
	public static boolean getChannel(String channelid, String channel_id) {
		channelid = channelid.replace("，", ",");
		String[] id = channelid.split(",");
		if (id.length > 1) {
			boolean flag = false;
			for (String str : id) {
				if (channel_id.equals(str)) {
					flag = true;
				}
			}
			if (flag) {
				return true;
			}
		} else {
			if (channel_id.equals(channelid)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 方法描述：MD5加密
	 * 
	 * @author 李国文
	 * @date 日期：2017年6月5日 时间：下午3:06:58
	 * @version 1.0
	 * @param src
	 *            需要加密的内容
	 * @return MD5加密后的内容
	 */
	public static String getMD5(String src) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(src.getBytes());
			byte[] s = m.digest();

			return bintoascii(s);
		} catch (NoSuchAlgorithmException ex) {
			return null;
		}
	}
	
	/**
	 * md5解密
	 * @author chenliang
	 * @date  2018年4月8日 下午2:57:59
	 * @param inStr
	 * @return
	 */
	public static String JM(String inStr) {
		char[] a = inStr.toCharArray();   
		for (int i = 0; i < a.length; i++) {   
			a[i] = (char) (a[i] ^ 't');   
		}   
		String k = new String(a);
		return k;   
	 }   

	public static String bintoascii(byte[] bySourceByte) {
		int len, i;
		byte tb;
		char high, tmp, low;
		String result = new String();
		len = bySourceByte.length;
		for (i = 0; i < len; i++) {
			tb = bySourceByte[i];

			tmp = (char) ((tb >>> 4) & 0x000f);
			if (tmp >= 10) {
				high = (char) ('a' + tmp - 10);
			} else {
				high = (char) ('0' + tmp);
			}
			result += high;
			tmp = (char) (tb & 0x000f);
			if (tmp >= 10) {
				low = (char) ('a' + tmp - 10);
			} else {
				low = (char) ('0' + tmp);
			}

			result += low;
		}
		return result;
	}

	/**
	 * 传入文本内容，返回 SHA-256 串
	 * 
	 * @param strText
	 * @return
	 */
	public static String SHA256(final String strText) {
		return SHA(strText, "SHA-256");
	}

	/**
	 * 传入文本内容，返回 SHA-512 串
	 * 
	 * @param strText
	 * @return
	 */
	public static String SHA512(final String strText) {
		return SHA(strText, "SHA-512");
	}

	/**
	 * 字符串 SHA 加密
	 * 
	 * @param
	 * @return
	 */
	private static String SHA(final String strText, final String strType) {
		// 返回值
		String strResult = null;

		// 是否是有效字符串
		if (strText != null && strText.length() > 0) {
			try {
				// SHA 加密开始
				// 创建加密对象 并傳入加密類型
				MessageDigest messageDigest = MessageDigest.getInstance(strType);
				// 传入要加密的字符串
				messageDigest.update(strText.getBytes());
				// 得到 byte 類型结果
				byte byteBuffer[] = messageDigest.digest();

				// 將 byte 轉換爲 string
				StringBuffer strHexString = new StringBuffer();
				// 遍歷 byte buffer
				for (int i = 0; i < byteBuffer.length; i++) {
					String hex = Integer.toHexString(0xff & byteBuffer[i]);
					if (hex.length() == 1) {
						strHexString.append('0');
					}
					strHexString.append(hex);
				}
				// 得到返回結果
				strResult = strHexString.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}

		return strResult;
	}

	/**
	 * 方法描述：保留2位小数4舍五入
	 * @author 李国文
	 * @date 日期：2017年8月31日  时间：下午6:17:58
	 * @version 1.0
	 * @param number
	 * @return
	 */
	public static String formatDouble2(String number) {
		if (ToolUtil.isEmpty(number))
			return null;
		double d = Double.valueOf(number);
		BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.HALF_UP);
		if(bg.doubleValue() < 0.01){
			return "0.01";
		}
		return bg.toString();
	}
	
	/**
	 * 方法描述：根据1024K进制展示流量,不考虑小数点（M、G、T）
	 * @author 青霜
	 * @date 日期：2017年11月9日  时间：上午11:31:26
	 * @version 1.0
	 * @param flow
	 * @return
	 */
	public static String flowFormat2(String flow) {
		if (ToolUtil.isEmpty(flow)) {
			return null;
		}
		Long a = Long.valueOf(flow);
		long b = 1024 * 1024;
		long c = 1024 * 1024 * 1024;
		long temp = 0L;
		String flow_temp = "";
		if (a >= c) {
			temp = (long)(a / c);
			flow_temp = temp + "G";
		} else if (a >= b) {
			temp = (long)(a / b);
			;
			flow_temp = temp + "M";
		}else if(a>=1024) {
			temp = (long)(a / 1024);
			flow_temp = temp + "k";
		}
		return flow_temp;
	}
	
	/**
	 * 默认给截止时间为24:00
	 * @author chenliang
	 * @date  2018年4月2日 上午9:52:47
	 * @param endTime
	 * @return
	 */
	public static String setEndTime(String endTime) {
		if (ToolUtil.isEmpty(endTime)) {
			return null;
		}
		return endTime+" 24:00:00";
	}
	
	/**
	 * 
	 * 方法描述：判断string是不是Decimal类型
	 * @author 李国文
	 * @date 日期：2019年6月18日  时间：下午1:33:32
	 * @version 1.0
	 * @param str
	 * @return
	 */
	public static String stringToDecimalStr(String str) {
		try {
			//构造以字符串内容为值的BigDecimal类型的变量bd 
			BigDecimal bd=new BigDecimal(str);
			//设置小数位数，第一个变量是小数位数，第二个变量是取舍方法(四舍五入) 
			bd=bd.setScale(2, BigDecimal.ROUND_HALF_UP);
			//转化为字符串输出 
			str=bd.toString();
		} catch (Exception e) {
			str=null;
		}
		return str;
	}
	
	
	/**
	 * 
	 * 方法描述：计算两个时间相差小时
	 * @author 李国文
	 * @date 日期：2019年7月3日  时间：下午8:31:45
	 * @version 1.0
	 * @param starTime
	 * @param endTime
	 * @return
	 */
	public static Long timeDiffHour(Date starTime, Date endTime) {
		try {
			long nd = 1000 * 24 * 60 * 60;
			 long nh = 1000 * 60 * 60;
			 long nm = 1000 * 60;
		     // long ns = 1000;
		     // 获得两个时间的毫秒时间差异
		     long diff = endTime.getTime() - starTime.getTime();
		     // 计算差多少小时
		     long hour = diff % nd / nh;
		     // 计算差多少分钟
		     long min = diff % nd % nh / nm;
		     if (min>0) {
				return hour+1;
		     }else {
				return hour;
			}
		} catch (Exception e) {
			return 0l;
		}
		 
	}
	
	/**
	 * 
	 * 方法描述：获取订单id(年份＋模块（1-8）+0+订单ID；如19 1 0 176)
	 * @author 李国文
	 * @date 日期：2019年7月15日  时间：下午1:02:49
	 * @version 1.0
	 * @param id
	 * @param type
	 * @return
	 */
	public static String getOrdersNo(String id, String type){
		if (ToolUtil.isEmpty(id)) {
			return null;
		}
		String orderId=getSysYear()+type+"0"+id;
		return orderId;
	}
	/**
	 * 
	 * 方法描述：获取商城订单id年份＋模块（1-8）+0+订单ID；如19 1 0 176
	 * @author 李国文
	 * @date 日期：2019年8月30日  时间：下午2:16:18
	 * @version 1.0
	 * @param id
	 * @param
	 * @return
	 */
	public static String getOrdersNo(String id){
		String type=generateRandomStr(1);
		return getOrdersNo(id,type);
	}
	
	public static Date strToDate(String strDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		ParsePosition pos = new ParsePosition(0);
		Date strtodate = formatter.parse(strDate, pos);
		return strtodate;
	}
	
	public static String getSysYear(){
		Calendar date = Calendar.getInstance();
	    String year = String.valueOf(date.get(Calendar.YEAR)).substring(2);
        return year;
	}
	
	


	public static void main(String[] args){
		List<String> list = new ArrayList<>();
		for(int i= 0;i <=63333;i++){
			list.add("test"+i);
		}

		Long start = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool(4);
		MultiTask task = new MultiTask(list);
		MultiTask.THRESHOLD = list.size() / 4;
		Long result = pool.invoke(task);

		System.out.println("result="+result);
		Long end = System.currentTimeMillis();
		System.out.println("消耗时间:"+(end - start));
	}

	static class MultiTask extends RecursiveTask<Long> {

		private static  int THRESHOLD = 1000;
		private  int start;
		private  int end;

		private List<String> list;

		public MultiTask(List<String> list ) {
			this.list = list;
			this.start = 1;
			this.end = list.size();
		}

		@Override
		protected Long compute() {
			long length = end - start;

			if(length < THRESHOLD){
				long num = 0;
				for (int i = start; i < end; i++) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e) {
						throw new RuntimeException(e);
					}
					num++;
				}
				return num;
			}else{
				int middle = (start + end) / 2;
				MultiTask left = new MultiTask(list.subList(start-1,middle));
				left.fork();
				MultiTask right = new MultiTask(list.subList(middle,end));
				right.fork();
				return left.join() +right.join();
			}
		}
	}
}
