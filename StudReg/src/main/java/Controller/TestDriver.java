package Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import business.TestBo;

@Controller
@RequestMapping("/test")
public class TestDriver {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	TestBo tst=(TestBo) context.getBean("bot");
	HttpServletRequest req;
	
	int count=0;
	@RequestMapping("/validate")
	public String validate(HttpServletRequest req) {
		HttpSession session=req.getSession();
//		String cls=req.getParameter("cls");
//		String res=req.getParameter("res");
		if(count==0) {
			session.setAttribute("count", count);
			count++;
		}
		else {
			count++;
			count=(Integer) session.getAttribute("count");
			
		}
		String qst=tst.getQst(count);
		session.setAttribute("qst", qst);
		
		return "Test";
		
	}
	

}
