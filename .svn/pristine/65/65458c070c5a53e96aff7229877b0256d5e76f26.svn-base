package com.shtoone.qms.util;

import java.beans.PropertyDescriptor;

import org.apache.commons.beanutils.PropertyUtils;
import org.jeecgframework.core.util.StringUtil;

import com.shtoone.qms.entity.bhz.XiangxixxEntity;

public class PropertyDescriptorUtil {
	public static void main(String[] args) {
		//测试JavaBean的反射机制
		XiangxixxEntity xiangxixx=new XiangxixxEntity();
		//xiangxixx.setBaocunshijian("2013-12-09");
		xiangxixx.setFeimeihui4Lilunzhi("123.34456");
		Object obj=xiangxixx;
		PropertyDescriptor origDescriptors[] = PropertyUtils.getPropertyDescriptors(obj);
		String aliasName, name, type;
		for (int i = 0; i < origDescriptors.length; i++) {
			try{
			//这里通过三元运算符
			aliasName = ("".equals("") ? "" : "" + ".")+ origDescriptors[i].getName();
//			System.out.println("字段名:"+origDescriptors[i].getName()+"\t字段类型:"+origDescriptors[i].getPropertyType().toString()+"\t"+aliasName);
			
			//判断JavaBean中属性值是否为只读的，即没有get方法
//			System.out.println(PropertyUtils.isReadable(obj, origDescriptors[i].getName()));
			
			//
			if(StringUtil.isNotEmpty(PropertyUtils.getSimpleProperty(obj, origDescriptors[i].getName()))){
				if(origDescriptors[i].getPropertyType().toString().contains("class java.lang") ||
				   origDescriptors[i].getPropertyType().toString().contains("class java.math")){
					System.out.println("value:"+String.format("%1$.2f", Double.parseDouble(PropertyUtils.getSimpleProperty(obj, origDescriptors[i].getName()).toString())));
				}
			}
				
//				System.out.println("---------");
//				System.out.println("value22:"+PropertyUtils.getProperty(obj, origDescriptors[i].getName()));
			}catch(Exception ex){}
		}
		
		
	}
}
