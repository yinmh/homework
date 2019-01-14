package web;

import org.ymh.dao.StudentDao;
import org.ymh.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@WebServlet(urlPatterns = "/insert")
public class InsertStudentServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao(); // 只有一个对象

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        Student student = new Student();
        student.setSname(req.getParameter("nickname"));
        String birthday = req.getParameter("birthday");
        java.util.Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        student.setBirthday(date);
        student.setSex(req.getParameter("sex"));
        int rows = studentDao.insert(student);
            if(rows>0){
                req.setAttribute("msg","增加学生成功");
            }else{
                req.setAttribute("msg","增加学生失败");
            }
            req.getRequestDispatcher("delete.jsp").forward(req, resp);
    }
}
