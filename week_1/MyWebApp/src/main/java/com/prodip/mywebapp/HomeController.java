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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("home")
    //@ResponseBody // এটি দিলে কোনো JSP বা ভিউ ফাইল খুঁজবে না
    public String home() {
        System.out.println("Hi");
        return "home"; // সরাসরি ব্রাউজারে এই টেক্সট/HTML শো করবে
    }
}