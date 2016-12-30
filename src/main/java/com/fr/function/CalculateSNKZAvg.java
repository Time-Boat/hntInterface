package com.fr.function;

import java.util.Arrays;

import com.fr.script.AbstractFunction;
/**
* 自定义函数：计算水泥抗折强度平均值
 * 数组长度为3，参数1-参数3强度值，
 * 例如：水泥抗折强度，[强度1，强度2，强度3]
 * return ｛-1：结果无效；-2：传入参数个数不对；-3函数异常；>=0正常值｝
 */
public class CalculateSNKZAvg extends AbstractFunction {
	private static final long serialVersionUID = 1L;

	public Object run(Object[] args) {
		int len =0;
		Float judgevalue = new Float(0);
        float  result = 0;
        try {
        	   len = args.length;
        	   if(len!=3){
        		    result =-2;
     	       }else{
           		   judgevalue = Float.valueOf(args[len-1].toString());
        	       float[] value =new float[3];
        	       for(int i =0 ;i<3;i++){
        	    	   value[i] = Float.parseFloat(args[i].toString());
        	       }
        	       Arrays.sort(value);
        	       float avg = 0f; 
        	       avg = (value[0]+value[1]+value[2])/3;
        	       //单值跟平均值的相差值
        	       float a = Math.abs(value[0]-avg);
        	       float b = Math.abs(value[2]-avg);
        	       //判断如果有值超过10%则剔除掉
        	       if(a>avg*0.1&&a>b){
        	    	   result = (value[1]+value[2])/2;
        	       }else  if(b>avg*0.1&&b>a){
        	    	   result = (value[1]+value[0])/2;
        	       }else{
        	    	   result = (value[0]+value[1]+value[2])/3;
        	       }
     	      }  
		} catch (Exception e) {
			result =-3;
			return result;
		}
        return result;     
    } 
	
}
