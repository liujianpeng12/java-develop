package com.vince.xml;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用第三方类库dom4j 实现读取XML,性能优异,优先使用
 * 
 * @author Administrator
 * 
 */
public class XMLDemo {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		
		List<Teacher> teachers=new ArrayList<Teacher>();
		
		SAXReader reader=new SAXReader();
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("Person.xml");
		Document doc=reader.read(is);
		Element root=doc.getRootElement();
		Iterator<Element> iters=root.elementIterator();
		while(iters.hasNext()){
			Teacher t=new Teacher();
			Element e=iters.next();
			t.setId(Integer.parseInt(e.attributeValue("id")));
			t.setName(e.elementText("name"));
			t.setAge(Integer.parseInt(e.elementText("age")));
			teachers.add(t);
		}
		
		for(Teacher t:teachers){
			System.out.println(t);
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