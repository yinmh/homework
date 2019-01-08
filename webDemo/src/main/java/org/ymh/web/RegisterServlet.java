package org.ymh.web;

import org.ymh.dao.RegisterDao;
import sun.net.httpserver.HttpsServerImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/resgist")
public class RegisterServlet extends HttpServlet {
    RegisterDao registerDao =new RegisterDao();
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String sex = req.getParameter("sex");
        String nickname = req.getParameter("nickname");
        try {
            int rows = registerDao.regist(username, password, sex, nickname);
            if(rows>0){
                res.getOutputStream().print("<br><h1>注册成功</h1>");
            }else {
                res.getOutputStream().print("<br><h1>注册失败</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
