package com.springboot.webapp.firstSpringWebApplication.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


//this @Controller tells spring that this is spring bean
//if it is not added  , url will say page not found
@Controller
public class SayHelloController {

	//"say-hello" => "Hello ! What are you learning?"
	@RequestMapping("/say-hello")
	@ResponseBody
	public  String sayHello() {

		//only returning string will not work , there is requirement to create a view
		//thats why @ResponseBody annotation is used
		return "Hello ! What are you learning?";
	}


	@RequestMapping("/say-hello-html")
	@ResponseBody
	public  String sayHelloHtml() {
		//here we are trying to hardcode html in code
		// it is not that efficient but let's implement

		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append( " <head>");
		sb.append ("<title>Spring project first title page</title>");
		sb.append(" </head>");
		sb.append("<body>");
		sb.append("  <h1 class=\"title\">My first html page of spring project !</h1>");
		sb.append("</body>");
		sb.append("</html>");


		return sb.toString();
	}

	//jsp files are created at path
	//src/main/resources/META-INF/resources/WEB-INF/JSP/sayHello1.jsp
	//src/main/resources/META-INF/resources/WEB-INF/JSP/sayHello2.jsp
	//src/main/resources/META-INF/resources/WEB-INF/JSP/sayHello3.jsp
	// HERE YOU CAN SEE AT EACH TIME WE HAVE TO GO FOR PATH ,
	//TO REDUCE THIS UNNECESSARY WORK WE WILL USE prefix AND suffix

	//say-hello-jsp
	@RequestMapping("/say-hello-jsp")
	public  String sayHelloJSP() {

		//only returning string will not work , there is requirement to create a view
		//thats why @ResponseBody annotation is used
		return"sayHello";
	}



}