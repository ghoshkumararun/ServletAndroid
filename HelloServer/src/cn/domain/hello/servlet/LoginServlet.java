package cn.domain.hello.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;
import cn.domain.hello.bean.UserBean;
import cn.domain.hello.dao.UserDao;

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		String reqMessage, respMessage;
		JSONArray reqObject = null;
		JSONArray respObject = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			reqMessage = sb.toString();
			System.out.println("请求报文:" + reqMessage);
			
			reqObject = new JSONArray(reqMessage);
			UserDao userDao = new UserDao();
			UserBean ub = userDao.getUserByName(reqObject.getJSONObject(0)
					.getString("username"));
			if (ub.getPassword() != null
					&& ub.getPassword().equals(
							reqObject.getJSONObject(0).getString("password"))) {
				respObject = new JSONArray().put(new JSONObject().put("userId",
						ub.getId()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			respMessage = respObject == null ? "" : respObject.toString();
			System.out.println("返回报文:" + respMessage);
			PrintWriter pw = response.getWriter();
			pw.write(respMessage);
			pw.flush();
			pw.close();
		}
	}

}
