package dao;


import org.ymh.entity.Student;
import org.ymh.util.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 数据访问对象
public class StudentDao {

    // 查询所有
    public List<Student> findAll() {
        try (Connection conn = JdbcUtils.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("select * from student1")) {
                ResultSet rs = stmt.executeQuery();
                List<Student> list = new ArrayList<>();
                while (rs.next()) {
                    Student stu = new Student();
                    stu.setSid(rs.getInt("s_id"));
                    stu.setSname(rs.getString("s_name"));
                    stu.setBirthday(rs.getDate("s_age"));
                    stu.setSex(rs.getString("s_sex"));
                    list.add(stu);
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // 添加学生
    public int insert(Student student) {
        try(Connection conn = JdbcUtils.getConnection()) {
            try(PreparedStatement pstm = conn.prepareStatement("insert into student1(s_name,s_age,s_sex) values(?,?,?);")){
                pstm.setString(1,student.getSname());
                pstm.setDate(2,new Date(student.getBirthday().getTime()));
                pstm.setString(3,student.getSex());
                int rows = pstm.executeUpdate();
                return rows;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 根据 id 查询
    public Student findById(int sid) {
        Student stu = new Student();
        try (Connection conn = JdbcUtils.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("select * from student1 where s_id = ?")) {
                stmt.setInt(1, sid);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                stu.setSid(rs.getInt("s_id"));
                stu.setSname(rs.getString("s_name"));
                stu.setBirthday(rs.getDate("s_age"));
                stu.setSex(rs.getString("s_sex"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stu;
    }

    // 修改学生
    public int update(Student student) {
        try(Connection conn = JdbcUtils.getConnection()){
            try(PreparedStatement pstm = conn.prepareStatement("update student1 set s_name=?,s_age=?,s_sex=? where s_id=?")){
                pstm.setString(1,student.getSname());
                pstm.setDate(2,new Date(student.getBirthday().getTime()));
                pstm.setString(3,student.getSex());
                pstm.setInt(4,student.getSid());
                int rows = pstm.executeUpdate();
                return rows;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // 删除学生
    public int delete(int sid) {
        try (Connection conn = JdbcUtils.getConnection()) {
            try (PreparedStatement stmt = conn.prepareStatement("delete from student1 where s_id = ?")) {
                stmt.setInt(1,sid);
                int rows = stmt.executeUpdate();
                return rows;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
