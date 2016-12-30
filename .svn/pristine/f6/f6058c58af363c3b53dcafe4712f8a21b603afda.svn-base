package com.fr.function;

import java.util.Arrays;

import com.fr.script.AbstractFunction;
/**
* 自定义函数：计算水泥抗折强度平均值
 * 数组长度为6，参数1-参数6强度值，
 * 例如：水泥抗压强度，[强度1，强度2，强度3，强度4，强度5，强度6]
 * return ｛-1：结果无效；-2：传入参数个数不对；-3函数异常；>=0正常值｝
 */
public class CalculateSNKYAvg extends AbstractFunction {
	private static final long serialVersionUID = 1L;

	public Object run(Object[] args) {
		int len =0;
		Float judgevalue = new Float(0);
        float  result = 0;
        try {
        	   len = args.length;
        	   if(len!=6){
        		    result =-2;
     	       }else{
           		   judgevalue = Float.valueOf(args[len-1].toString());
        	       float[] value =new float[6];
        	       for(int i =0 ;i<6;i++){
        	    	   value[i] = Float.parseFloat(args[i].toString());
        	       }
        	       Arrays.sort(value);
        	       float avg1 = 0f; 
        	       avg1 = (value[0]+value[1]+value[2]+value[3]+value[4]+value[5])/6;
        	       //单值跟平均值的相差值
        	       float diff[] =new float[6];
        	      //记录相差最大值和下标
        	       float maxvalue1 = 0f; 
        	       int index1 = 0;
        	       for(int i=0 ; i<6;i++){
        	    	   diff[i] = Math.abs(value[i] - avg1);
        	    	   if(diff[i]>maxvalue1){
        	    		   maxvalue1 = diff[i];
        	    		   index1 =i;
        	    	   }
        	       }
        	       //判断超差值是否大于平均值的10%
        	       if(maxvalue1>avg1*0.1){
        	    	   float[] value2 =new float[5];
        	    	   int m = 0;
        	    	   //剔除超差最大值
        	    	   for(int k=0;k<6;k++){
        	    		   if(k!=index1){
        	    			   value2[m] = value[k];
        	    			   m++;
        	    		   }
        	    	   }
        	    	 //剔除超差最大值后再计算平均值
        	    	   float avg2 = 0f; 
            	       avg2 = (value2[0]+value2[1]+value2[2]+value2[3]+value2[4])/5; 
            	       //记录5个值相差最大值和下标
            	     //5个值中单值跟平均值的相差值
            	       float diff2[] =new float[5];
            	      //记录相差最大值和下标
            	       float maxvalue2 = 0f; 
            	       int index2 = 0;
            	       for(int j=0 ; j<5;j++){
            	    	   diff[j] = Math.abs(value[j] - avg2);
            	    	   if(diff[j]>maxvalue2){
            	    		   maxvalue2 = diff[j];
            	    		   index2=j;
            	    	   }
            	       }
            	       if(maxvalue2>avg2*0.1){
            	    	   result = -1;
            	       }else{
            	    	   result =avg2;
            	       }
        	       }else{
        	    	   result = avg1;
        	       }
     	       }
		} catch (Exception e) {
			result =-3;
			return result;
		}
        return result;     
    } 
}
