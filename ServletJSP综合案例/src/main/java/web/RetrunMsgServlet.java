package web;

import org.ymh.dao.StudentDao;
import org.ymh.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/rmsg")
public class RetrunMsgServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao(); // 只有一个对象

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        Student stu = studentDao.findById(sid);
        req.setAttribute("student",stu);
        req.getRequestDispatcher("u_studentmessage.jsp").forward(req, resp);
    }
}
