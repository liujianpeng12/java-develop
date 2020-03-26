package com.vince.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLDemo {

	/**
	 * @param args
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		List<Teacher> teachers=new ArrayList<Teacher>();
		Teacher t=null;
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Person.xml");
		Document doc = db.parse(is);
		NodeList nodeList = doc.getElementsByTagName("teacher");
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			t=new Teacher();
			
			Node node=nodeList.item(i);
			String id=node.getAttributes().getNamedItem("id").getNodeValue();
			t.setId(Integer.parseInt(id));
			
			NodeList childNodes =node.getChildNodes();
			for (int j = 0; j < childNodes.getLength(); j++) {
				Node childNode=childNodes.item(j);
				String nodeName=childNode.getNodeName();
				if(nodeName.equals("name")){
					t.setName(childNode.getFirstChild().getNodeValue());
				}else if(nodeName.equals("age")){
					t.setAge(Integer.parseInt(childNode.getFirstChild().getNodeValue()));
				}
			}
			
			teachers.add(t);
		}
		
		for(Teacher th: teachers){
			System.out.println(th);
		}
	}

}
class Teacher{
	private int id;
	private String name;
	private int age;
	public Teacher(){}
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







