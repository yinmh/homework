package web;


import dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/delete")
public class deleteStudent extends HttpServlet {

    StudentDao studentDao = new StudentDao(); // 只有一个对象

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int rows = studentDao.delete(Integer.parseInt(req.getParameter("sid")));
        if(rows>0){
            req.setAttribute("msg","删除成功");
        }else{
            req.setAttribute("msg","删除失败");
        }
        req.getRequestDispatcher("delete.jsp").forward(req, resp);
    }
}
