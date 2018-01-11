package com.wgh.tools.email;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
* @author 孟国庆 e-mail:mengguoqing@mail01.huawei.com
* @version 创建时间：2017年11月15日 下午4:51:54
* 类说明
*/
public class DevelperSetData {
	
	static{
		new DevelperSetData().getContent();
	}
	private DevelperSetData() {
		
	}
	public static String sendemailaccount;
	public static String shouquanma;
	public static String content;
	
	private void getProperties(){
		
	}
	
	private void getContent(){
		try {
			Properties pro=new Properties();
			//打成夹包时路劲要改  
			InputStream in = this.getClass().getResourceAsStream("/developSet.properties");
			//FileInputStream  in= new FileInputStream("developer/developSet.properties");//TODO
			
			pro.load(in);
			in.close();
			Iterator<String> it=pro.stringPropertyNames().iterator();
	        while(it.hasNext()){
                String key=it.next();
                if (key.equals("sendEmailEccount")) {
					this.sendemailaccount= pro.getProperty(key);
				}
                else if(key.equals("shouquanma")){
                	
                	this.shouquanma= pro.getProperty(key);
                }
	        }
	        
	        InputStream inputStream = this.getClass().getResourceAsStream("txt/centext.txt");//打成夹包时路劲要改  
            BufferedReader bf= new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
	        //BufferedReader bf= new BufferedReader(new FileReader("D:\\Myeclipse\\21\\txt\\centext.txt"));//TODO
            StringBuffer buffer=new StringBuffer();
            String readLine = null;
            while((readLine=bf.readLine())!=null){
                buffer.append(readLine);
            }
            bf.close();
            this.content=buffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
	} 

}
