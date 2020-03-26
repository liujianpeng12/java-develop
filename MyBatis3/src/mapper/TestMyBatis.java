package mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 注解与缓存
 * @author Administrator
 *
 */
public class TestMyBatis {

	public static void main(String[] args) throws IOException{
		String resource = "mybatis-config.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		
		EmpMapper empMapper = session.getMapper(EmpMapper.class);
		
		//一级查询缓存
		//一级查询存在于每一个 SqlSession 类的实例对象中，当第一次查询某一个数据时，SqlSession 类的实例对象会将该数据存入一级缓存区域，
		//在没有收到改变该数据的请求之前，用户再次查询该数据，都会从缓存中获取该数据，而不是再次连接数据库进行查询。
		Emp emp0 = empMapper.getEmp(1);
		System.out.println(emp0.toString());
		
		Emp emp1 = empMapper.getEmp(1);
		System.out.println(emp1.toString());
		
		
		SqlSession session1 = factory.openSession();
		EmpMapper empMapper1 = session1.getMapper(EmpMapper.class);
		Emp emp2 = empMapper1.getEmp(1);
		System.out.println(emp2.toString());
		
//		Emp emp1 = new Emp("小刚", 22, "男", 120000.0d);
//		empMapper.addEmp(emp1);
//		
//		Emp emp2 = new Emp();
//		emp2.setId(12);
//		emp2.setName("黄总");
//		empMapper.updateEmp(emp2);
//		
//		empMapper.deleteEmp(9);
//		
//		List<Emp> emps = empMapper.selectList();
//		for (Emp emp : emps) {
//			System.out.println(emp.toString());
//		}
//		
//		session.commit();
		session.close();
	}
}
