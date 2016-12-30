package com.fr.function;
import com.fr.script.AbstractFunction;

public class CreateGuid extends AbstractFunction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1641825135355289432L;

	public Object run(Object[] args) {
		String s = ""; 
		if (args.length==4) {
			s =  args[0].toString()+args[1].toString()+args[2].toString()+args[3].toString();
		} else {
			java.util.Calendar c=java.util.Calendar.getInstance();    
	        java.text.SimpleDateFormat f=new java.text.SimpleDateFormat("yyyy-MM-dd hh");    
	        s = f.format(c.getTime());   
		}
		//return SecurityMD5.encode(s,"");
	    	   try
	    	   {
	    	      java.security.MessageDigest md = java.security.MessageDigest.getInstance( "MD5" );
	    	      md.update(s.getBytes());
	    	     StringBuilder sb = new StringBuilder();
	    	     for (byte b : md.digest()) {
	    	        sb.append(String.format("%02X", b));
	    	     }
	    	     return sb.toString();
	    	    
	    	   }catch( Exception e )
	    	   {
	    	     return s;
	    	   }
	}
}
