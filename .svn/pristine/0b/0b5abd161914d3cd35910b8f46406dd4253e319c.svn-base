package com.fr.function;

import java.util.Arrays;

import com.fr.script.AbstractFunction;
/**
* 自定义函数：根据传递数组判断是否返回中值or平均值or返回空
 * 数组长度为4，前3位是需要判断的数组值，
 * 最后一位为判断标准百分比
 * 例如：混凝土强度，[强度1，强度2，强度3,0.15]
 * return ｛-1：结果无效；-2：传入参数个数不对；-3函数异常；>=0正常值｝
 */
public class JudgeArrayMiddleValue extends AbstractFunction {
	private static final long serialVersionUID = 1L;

	public Object run(Object[] args) {
		int len =0;
		Float judgevalue = new Float(0);
        float  result = 0;
        try {
        	   len = args.length;
        	   if(len!=4){
        		    result =-2;
     	       }else{
           		   judgevalue = Float.valueOf(args[len-1].toString());
        	       float[] value =new float[3];
        	       for(int i =0 ;i<3;i++){
        	    	   value[i] = Float.parseFloat(args[i].toString());
        	       }
        	       Arrays.sort(value);
        	       if(Math.abs((value[0]-value[1]))>value[1]*judgevalue&&Math.abs((value[2]-value[1]))>value[1]*judgevalue){
        	    	   result =-1; 
        	       }else if(Math.abs((value[0]-value[1]))>value[1]*judgevalue||Math.abs((value[2]-value[1]))>value[1]*judgevalue){
        	    	   result = value[1];
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
