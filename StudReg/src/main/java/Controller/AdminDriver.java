package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import business.AdminBo;
import business.SchoolBo;
import model.School;

@Controller
@RequestMapping("/Admin")
public class AdminDriver {
	ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
	SchoolBo skl=(SchoolBo) context.getBean("bos");
	AdminBo abo=(AdminBo) context.getBean("boa");
	
	//FOR DISPLAYING STUDENTS 
	@RequestMapping("/School")
	public String display(Model model) {
		List<School> lis=skl.display();
		//System.out.println(lis.size());
		model.addAttribute("list", lis);
		return "StudentView";
	}
	
	
	//****FOR FINDING STUDENT BY ID AND FOR MODEL ATTRIBUTE FOR AUTO POPULATING IN JSP PAGE ****
	@RequestMapping("/find")
	public String find(@ModelAttribute("school") School school,@RequestParam("sid") int id,Model model,HttpServletResponse res) throws IOException {
		/*
		 * School student=new School(); student=skl.findById(id);
		 */
		School student= skl.findById(id);
		
		model.addAttribute("student",student);
		model.addAttribute("firstName", student.getFirstName());
		model.addAttribute("lastNAME", student.getLastNAME());
		model.addAttribute("faterName", student.getFaterName());
		model.addAttribute("motherName", student.getMotherName());
		model.addAttribute("gender", student.getGender());
		model.addAttribute("mobile", student.getMobile());
		model.addAttribute("dob", student.getDob());
		//model.addAttribute("", student.);
		
		//res.sendRedirect("/StudReg/AddStud.jsp");
		return "AddStud";
	}
	
	//****ADDING A SUDENT TO SCHOOL ****
	@RequestMapping("/addStudent")
	public String addStud() {
		return "AddStud";
	}
	//****UPDATING DETAILS OF STUDENT****
	@RequestMapping("/update")
	public String update(School student) {
		System.out.println(student.getId());
		skl.update(student);
		return "redirect:/Admin/School";
	}
	//****LOGIN FOR ADMIN ****
	@RequestMapping("/login")
	public String login(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String uname=req.getParameter("uname");
		String pwd=req.getParameter("pwd");
		HttpSession session=req.getSession();
		session.setAttribute("aname", uname);
		session.setAttribute("apwd",pwd);
		if(uname.equals(""))
				res.sendRedirect("/StudReg/Admin.jsp");
		else if(abo.findByName(uname,pwd))
			return "success";
		return "Studs";
	}
	//****DELETING A STUDENT and DISPLAYING STUDENT****
	@RequestMapping("/delete")
	public String delete(@RequestParam("sid") int id,@ModelAttribute("school") School school) {
		System.out.println("HI"+id);
		skl.del(id);
		return "redirect:/Admin/School";	
	}
	
	//****LOGOUT A ADMIN FROM SITE****
	@ResponseBody
	@RequestMapping("/logout")
	public String delete(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session=req.getSession();
		session.removeAttribute("uname");
		session.removeAttribute("pwd");
		
		res.sendRedirect("/StudReg/index.jsp");
		return "SUCCESFULLY LOGGED OUT";
	}
}
