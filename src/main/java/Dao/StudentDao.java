package Dao;

import org.apache.ibatis.annotations.*;
import po.Student;

import java.util.List;

public interface StudentDao {
    @Select("select * from student")
    @Results(id="studentResult",value = {
            @Result(id=true, property="id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Student> selectAll();
    /**
     * 根据id查询
     */
    @Select("select * from student where id=#{id}")
    @ResultMap("studentResult")
    Student selectOne(int id);
    /**
     * 添加
     */

    @Insert("insert into student(name) values(#{name})")
    int insert(Student student);
    /**
     * 删除
     */

    @Delete("delete from student where id=#{id}")
    int delete(int id);
    /**
     * 修改
     */
    @Update("update student set name=#{name} where id=#{id}")
    int update(Student student);

}
