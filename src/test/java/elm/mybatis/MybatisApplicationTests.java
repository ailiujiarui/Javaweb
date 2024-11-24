package elm.mybatis;

import elm.mybatis.mapper.EmpMapper;
import elm.mybatis.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class MybatisApplicationTests {

    @Autowired
    EmpMapper empMapper;

    //根据id删除员工信息
    @Test
   public void testDeleteEmp(){
        empMapper.deleteEmp(17);
    }
    @Test
    public void testAddEmp(){
        Emp emp = new Emp();
        emp.setUsername("admin2");
        emp.setName("管理员2");
        emp.setGender((short)1);
        emp.setImage("2.jpg");
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.now());
        emp.setDeptId(1);
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.addEmp(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testUpdateEmp(){
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("admin1-1");
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateEmp(emp);
    }


    @Test
    public void testGetEmpById(){
        Emp emp = empMapper.getEmpById(1);
        System.out.println(emp);
    }
    @Test
    public void testListEmp(){
        List<Emp> list = empMapper.listEmps("张",(short)1,null,null);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void testDeleteEmps(){
        empMapper.deleteEmps(List.of(19,20));
    }
    @Test
    public void testUpdateEmp2(){
        Emp emp = new Emp();
        emp.setId(18);
        emp.setUsername("admin1-1");
        empMapper.updateEmp2(emp);
    }
}
