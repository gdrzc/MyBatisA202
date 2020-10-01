import Dao.StudentDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import po.Student;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test2 {
    private InputStream is;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private StudentDao sd;

    @Before
    public void before() throws IOException {
        is = Resources.getResourceAsStream("mybatis-config.xml");
        //2.创建sqlSessionFactory工厂
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //3.产生SqlSession  数据库会话对象
        sqlSession = sqlSessionFactory.openSession(true);
        sd = sqlSession.getMapper(StudentDao.class);
    }

    @org.junit.Test
    public void test() {
        Student student = sd.selectOne(1);
        System.out.println(student);
        List<Student> students = sd.selectAll();
        for (Student student1 : students) {
            System.out.println(student1);
        }
        Student student1=new Student();
        student1.setName("王五");
        int insert = sd.insert(student1);
        System.out.println(insert);
        student1.setName("赵六");
        int update = sd.update(student);
        System.out.println(update);
        int delete = sd.delete(6);
        System.out.println(delete);
    }

    @After
    public void after() {
        System.out.println("Test2.after");
    }
}
