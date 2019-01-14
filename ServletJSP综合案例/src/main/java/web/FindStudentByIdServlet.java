package web;



import org.ymh.dao.StudentDao;
import org.ymh.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/findstudentbyid")
public class FindStudentByIdServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao(); // 只有一个对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student stu = studentDao.findById(Integer.parseInt(req.getParameter("sid")));
        req.setAttribute("stu", stu);
        req.getRequestDispatcher("findStudentById.jsp").forward(req, resp);
    }
}
