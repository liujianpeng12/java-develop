package demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestMyBatis {

	public static void main(String[] args) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		Emp emp0 = session.selectOne("getEmp", 2);
		System.out.println(emp0.toString());
		
		Emp emp1 = new Emp("Ð¡¸Õ", 22, "ÄÐ", 120000.0d);
		session.insert("addEmp", emp1);
		
		Emp emp2 = new Emp();
		emp2.setId(12);
		emp2.setName("»Æ×Ü");
		session.update("updateEmp", emp2);
		
		Emp emp3 = new Emp();
		emp3.setId(8);
		session.delete("deleteEmp", emp3);
		
		List<Emp> emps = session.selectList("selectList");
		for (Emp emp : emps) {
			System.out.println(emp.toString());
		}
		
		session.commit();
		session.close();
	}
}
