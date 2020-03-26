package com.vince.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

/**
 * 使用第三方类库jdom 实现读取XML
 * 
 * @author Administrator
 * 
 */
public class XMLDemo {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JDOMException
	 */
	public static void main(String[] args) throws JDOMException, IOException {
		
		List<Teacher> teachers=new ArrayList<Teacher>();

		SAXBuilder sax = new SAXBuilder();
		InputStream is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("Person.xml");
		Document doc = sax.build(is);
		Element rootElement = doc.getRootElement();
		List<Element> childs = rootElement.getChildren();
		for (int i = 0; i < childs.size(); i++) {
			Teacher t=new Teacher();
			
			Element child = childs.get(i);
			String id = child.getAttributeValue("id");
			t.setId(Integer.parseInt(id));
			t.setName(child.getChildText("name"));
			t.setAge(Integer.parseInt(child.getChildText("age")));
			
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
