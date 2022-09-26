package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.model.BkService;

@WebServlet("/check")
public class IdCheck extends HttpServlet {
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
	   //인코딩
      req.setCharacterEncoding("utf-8");
      
      
      //로그인 jsp 의 ID PW 정보를 받음
      String usId = req.getParameter("usId");
      String usPw = req.getParameter("usPw");
      
      //set ,get Attribute 전달 테스트 확인 했고 일단 지금은 받는 쪽은 헤더에 있음 이걸로도 전달 가능하다는거 알고나 있자
      req.setAttribute("usId", usId);
      
      //서비스로 전달 테스트
      BkService.test(usId, usPw);
      
      //로그인 후 main으로 페이지 이동
      req.getRequestDispatcher("main.jsp").forward(req, resp);
      
      
   }

}