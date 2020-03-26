package com.vince.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

/**
 * XML与对象的转换
 * @author Administrator
 *
 */
public class XMLDemo5 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		File file=new File("person.xml");
		Teacher teacher=new Teacher(10,"teacher黄",30);
		objectToXML(file,teacher);
		System.out.println("objectToXML success.");
		
		xmlToObject(file);
		
	}
	
	private static void objectToXML(File file,Teacher teacher) throws IOException{
		FileOutputStream out=new FileOutputStream(file);
		BufferedOutputStream bos=new BufferedOutputStream(out);
		XMLEncoder encoder=new XMLEncoder(bos);
		encoder.writeObject(teacher);
		
		encoder.close();
		bos.close();
		out.close();
	}
	
	private static void xmlToObject(File file) throws IOException{
		FileInputStream in=new FileInputStream(file);
		BufferedInputStream bis=new BufferedInputStream(in);
		XMLDecoder decoder=new XMLDecoder(bis);
		Teacher t=(Teacher)decoder.readObject();
		
		decoder.close();
		bis.close();
		in.close();
		
		System.out.println("-------------------");
		System.out.println("xmlToObject success.");
		System.out.println(t);
	}

}


