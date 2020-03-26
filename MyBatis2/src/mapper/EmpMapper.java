package mapper;

import java.util.List;

public interface EmpMapper {

	List<Emp> selectList();
	
	Emp getEmp(int id);
	
	void addEmp(Emp emp);
	
	void updateEmp(Emp emp);
	
	void deleteEmp(int id);
}
