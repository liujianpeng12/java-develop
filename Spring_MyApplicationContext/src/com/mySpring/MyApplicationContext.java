package com.mySpring;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyApplicationContext {

	private List<Bean> beans = new ArrayList<Bean>();
	private Map<String, Object> map = new HashMap<String, Object>();

	public MyApplicationContext(String fileName) {
		parseXML(fileName);
		createInstance();
		injectionProperty();
	}
	
	public Object getBean(String name){
		return map.get(name);
	}
	
	/**
	 * 给bean的property赋值
	 */
	private void injectionProperty(){
		for (Bean bean : beans) {
			List<Property> properties=bean.getProperties();
			if(properties.size()>0){
				for (Property property : properties) {
					for (Bean inBean : beans) {
						if(inBean.getId().equals(property.getRef())){
							//要注入的对象
							Object obj=map.get(inBean.getId());
							//被注入的对象
							Class c=map.get(bean.getId()).getClass();
							try {
								BeanInfo beanInfo= Introspector.getBeanInfo(c);
								PropertyDescriptor[] pds= beanInfo.getPropertyDescriptors();
								for (PropertyDescriptor propertyDescriptor : pds) {
									if(propertyDescriptor.getName().equals(property.getName())){
										//获取属性的setter方法
										Method method = propertyDescriptor.getWriteMethod();
										//调用setter方法
										method.invoke(map.get(bean.getId()), obj);
									}
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * 创建Bean实例
	 */
	private void createInstance(){
		for (Bean bean : beans) {
			try {
				Object obj=Class.forName(bean.getClassName()).newInstance();
				map.put(bean.getId(), obj);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * 解析XML文件
	 * 
	 * @param fileName
	 */
	private void parseXML(String fileName) {
		InputStream is = this.getClass().getClassLoader()
				.getResourceAsStream(fileName);
		// 创建解析器
		SAXReader reader = new SAXReader();
		try {
			Document doc = reader.read(is);
			Iterator<Element> beanIterator = doc.getRootElement()
					.elementIterator();
			while (beanIterator.hasNext()) {
				Element eleBean = beanIterator.next();
				Bean bean = new Bean(eleBean.attributeValue("id"),
						eleBean.attributeValue("class"));
				Iterator<Element> propIterator = eleBean.elementIterator();
				while (propIterator.hasNext()) {
					Element eleProp = propIterator.next();
					Property prop = new Property(
							eleProp.attributeValue("name"),
							eleProp.attributeValue("ref"));
					bean.getProperties().add(prop);
				}
				beans.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
