package elm.mybatis.mapper;


import elm.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;


@Mapper
public interface EmpMapper {
    @Delete("delete from emp where id=#{id}")
    public void deleteEmp(Integer id);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime})")
    public void addEmp(Emp emp);


    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void updateEmp(Emp emp);

    @Select("select * from emp where id=#{id}")
    public Emp getEmpById(Integer id);

    //不安全而且可能会出现数值绑定错误的问题
    /*@Select("select * from emp where name like '%${arg0}%' and gender = #{arg1} and entrydate between #{arg2} and #{arg3} order by update_time desc")
    public List<Emp> listEmps( String name , Short gender, LocalDate begin, LocalDate end);*/
    /*@Select("select * from emp where name like concat('%',#{arg0},'%')  and gender = #{arg1} and entrydate between #{arg2} and #{arg3} order by update_time desc")
    public List<Emp> listEmps( String name , Short gender, LocalDate begin, LocalDate end);*/
    public List<Emp> listEmps( String name , Short gender, LocalDate begin, LocalDate end);

    void deleteEmps(List<Integer> ids);

    void updateEmp2(Emp emp);
}
