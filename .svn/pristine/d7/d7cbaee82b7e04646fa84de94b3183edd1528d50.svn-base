package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.shtoone.qms.util.Smssender;


public class Test {
	public static void main(String[] args) {
		/*try {
			FileOutputStream os = new FileOutputStream("r:\\test");
			FileInputStream inputStream = new FileInputStream("r:\\consign.xml");
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader bufferReader = new BufferedReader(inputReader);
             
            // 读取一行
            String line = null;
            StringBuffer strBuffer = new StringBuffer();
                 
            while ((line = bufferReader.readLine()) != null)
            {
                strBuffer.append(line);
            } 
			os.write(com.shtoone.qms.util.StringUtil.compressData(strBuffer.toString()));
			os.close();
			inputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */
		Smssender.SendSms("13390935538", "通道正常了", "123");
	}
	
}
