package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.Session;

import business.SchoolBo;
import business.TestBo;
import model.School;

@Controller
@RequestMapping("/school")
public class StudentDriver {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	SchoolBo skl=(SchoolBo) context.getBean("bos");
	TestBo tst=(TestBo) context.getBean("bot");
	int count=0,actualClass=0;
	
//****ADDING/ REGISTERING  A STUDENT ****
@RequestMapping("/register")
public String register(HttpServletRequest req,HttpServletResponse res,HttpSession session) throws IOException {
	String frstName=req.getParameter("fn"),lstName=req.getParameter("ln"),father=req.getParameter("fsn"),mother=req.getParameter("msn"),gender=req.getParameter("gen"),phone=req.getParameter("phone"),dob=req.getParameter("dob"),pwd="";
	//int cls=(int)Integer.parseInt(req.getParameter("cls")),res=(int)Integer.parseInt(req.getParameter("res")),id=0;
	int id=0,cls=0,result=0;
	if(frstName.equals("")||lstName.equals("")||father.equals("")||mother.equals("")||gender.equals("")||phone.equals("")|| dob.equals(""))
		res.sendRedirect("/StudReg/register.jsp");
	else
		System.out.println(skl.insert(new School(frstName,lstName,father,mother,gender,phone,dob,pwd,id,cls,result)));
	if(session.getAttribute("aname")==null)
			return "Studs";
	return "redirect:/Admin/School";
}
 

//****TAKING A TEST FOR STUDENT ****
@RequestMapping("/test")
public String test(HttpServletRequest req,HttpServletResponse res) {
	//Integer cls=Integer.parseInt(req.getParameter("cls"));
	HttpSession session=req.getSession();
	if(count==10) {
		return "redirect:/school/updateClass";
	}
	count+=1;
	session.setAttribute("count", count);
	String qst=tst.getQst(count);
	session.setAttribute("qst", qst);
	System.out.println(count);
	
	return "Test";
	
}

//****VALIDATING A STUDENT INPUT ANSWER FROM TEST.JSP****
@RequestMapping("/validate")
public String valid(HttpServletRequest req) throws SQLException {
	String ans=req.getParameter("ansr");
	System.out.println(ans);
	HttpSession session=req.getSession();
	if(session.getAttribute("unrl")==null)
		actualClass=0;
	 if(tst.getAns(count, ans) ) {
		 actualClass+=1;
		 session.setAttribute("result",actualClass);
	 }
	 
	return "Test";
}

//****LOGING IN A REGISTERED STUDENT ****
@RequestMapping("/login")
public String login(HttpServletRequest req,HttpServletResponse res) throws IOException {
	
	HttpSession session=req.getSession();
	session.setAttribute("result",0);
	String unrl=req.getParameter("unrl"),pwd=req.getParameter("pwd");
	session.setAttribute("unrl", unrl);
	session.setAttribute("pwd",pwd);
//	System.out.println(unrl+"  "+pwd);
	if(unrl.equals(""))
			res.sendRedirect("/StudReg/login.jsp");
	else if(Character.isDigit(unrl.charAt(0))) {
		if(skl.authenticateByRoll(Integer.parseInt(unrl), pwd)) {
			session.setAttribute("id", unrl);
			return "syllabus";
		}
		else
			return "err";
	}
	else {
		
	String name[]=unrl.split(" ");
//	System.out.println(name[0]+" "+name[1]);
	if(skl.authenticateByName(name[0],name[1], pwd)) {
		
		return "syllabus";
	}
	}
	return "err";
	
}

//****LOGOUT A STUDENT  FROM THE SITE ****

@RequestMapping("/logout")
public String logout(HttpServletRequest req,HttpServletResponse res) throws IOException {
	
	HttpSession session=req.getSession();
	session.removeAttribute("unrl");
	session.removeAttribute("pwd");
	res.sendRedirect("/StudReg/index.jsp");
	session.removeAttribute("result");
	session.removeAttribute("count");
	return null;
	
}


//****MATH SYLLABUS****
@RequestMapping("/math")
public String math(HttpServletRequest req,HttpServletResponse res) throws IOException {
	return "math";
}
//****UPDATE CLASS OF STUDENT BASED ON EXAM RESULT ****
@RequestMapping("/updateClass")
public String updateClass(HttpSession session) {
	System.out.println("in updateclass  "+session.getAttribute("unrl")+"   "+ session.getAttribute("result"));
	int id=Integer.parseInt(""+session.getAttribute("unrl")),cls=Integer.parseInt(""+ session.getAttribute("result"));
	skl.updateClass(id,cls);
	return "syllabus";
	
}
	
}
