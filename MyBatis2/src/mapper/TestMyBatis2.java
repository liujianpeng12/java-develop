package mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * ¶þ¼¶»º´æ
 * @author Administrator
 *
 */
public class TestMyBatis2 {

	public static void main(String[] args) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		
		Emp emp0 = empMapper.getEmp(1);
		System.out.println(emp0.toString());
		
		Emp emp1 = empMapper.getEmp(1);
		System.out.println(emp1.toString());
		
		SqlSession session1 = factory.openSession();
		EmpMapper empMapper1 = session1.getMapper(EmpMapper.class);
		
		Emp emp2 = empMapper1.getEmp(1);
		System.out.println(emp2.toString());
		
		Emp emp3 = empMapper1.getEmp(1);
		System.out.println(emp3.toString());
		
		session.close();
		session1.close();
	}
}
