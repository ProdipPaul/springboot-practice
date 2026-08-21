/*

package com.prodip.mywebapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("home")
    public String home()
    {
        System.out.println("Hi");
        return "home.jsp";
    }

}

 */
package com.prodip.mywebapp;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {


    @RequestMapping("home")
    //@ResponseBody // এটি দিলে কোনো JSP বা ভিউ ফাইল খুঁজবে না
    public String home(HttpServletRequest req, HttpServletResponse res)
    {
        HttpSession session = req.getSession();
        String name = req.getParameter("name");

        System.out.println("Hi " + name);
        session.setAttribute("name", name);
        return "home";
    }
}