package com.vince.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class XMLDemo {

	/**
	 * @param args
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory pf=SAXParserFactory.newInstance();
		SAXParser parser=pf.newSAXParser();
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("Person.xml");
		
		MyDefaultHandler myDefaultHandler=new MyDefaultHandler();
		parser.parse(is, myDefaultHandler);
		List<Teacher> teachers = myDefaultHandler.getTeachers();
		for(Teacher t: teachers){
			System.out.println(t);
		}
	}
}

class MyDefaultHandler extends DefaultHandler {

	List<Teacher> teachers = null;
	Teacher t = null;
	String tag = "";
	
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	@Override
	public void startDocument() {
		teachers = new ArrayList<Teacher>();
	}

	@Override
	public void endDocument() {

	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) {
		if ("teacher".equals(qName)) {
			t = new Teacher();
			t.setId(Integer.parseInt(attributes.getValue("id")));
		}
		tag = qName;
	}

	public void endElement(String uri, String localName, String qName) {
		if ("teacher".equals(qName)) {
			teachers.add(t);
		}
		tag=null;
	}

	public void characters(char[] ch, int start, int length) {
		if ("name".equals(tag)) {
			t.setName(new String(ch, start, length));
		} else if ("age".equals(tag)) {
			t.setAge(Integer.parseInt(new String(ch, start, length)));
		}
	}
}

class Teacher {
	private int id;
	private String name;
	private int age;

	public Teacher() {
	}

	public Teacher(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}