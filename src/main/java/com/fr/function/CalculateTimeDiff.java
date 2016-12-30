package com.fr.function;

import com.fr.script.AbstractFunction;
/**
* 自定义函数：计算传入的两个时间格式值相差的分钟数，返回整型分钟数
 * 参数1、参数2代表参与计算的时间格式的数值hh：mm，参数3是否修约到5（1是0否）
 * 例如：凝结时间加水时间11：12，初凝时间13：11
 * return ｛-2参数个数不对;-3：异常；>=0正常值｝
 */
public class CalculateTimeDiff extends AbstractFunction {
	private static final long serialVersionUID = 1L;

	public Object run(Object[] args) {
		int len =0;
		int result =-3;
		len = args.length;
		
		if(len!=3){
			result = -2;
		}
        try {
        	String time1 = (String)args[0];
        	String time2 = (String)args[1];
        	String digit = (String)args[2];
        	String timearray1[] = time1.split(":");
        	String timearray2[] = time2.split(":");
        	int timemin1 = 60*Integer.parseInt(timearray1[0]) +  Integer.parseInt(timearray1[1]);
        	int timemin2 = 60*Integer.parseInt(timearray2[0]) +  Integer.parseInt(timearray2[1]);
        	result = Math.abs(timemin2-timemin1);
		    //如果需要修约到5
        	if(digit=="1"){
		    	result = (int)(Math.round(result*0.2)/0.2);
		    }
        } catch (Exception e) {
			result =-3;
			return result;
		}
        return result;     
    } 

}
