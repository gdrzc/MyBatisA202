import Dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import po.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {
    @org.junit.Test
    public void test() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.产生SqlSession  数据库会话对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        List<Student> students = mapper.selectAll();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
