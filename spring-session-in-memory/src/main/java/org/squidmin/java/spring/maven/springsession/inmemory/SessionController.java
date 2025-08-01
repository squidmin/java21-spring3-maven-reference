package org.squidmin.java.spring.maven.springsession.inmemory;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {

    @GetMapping("/increment")
    public String incrementCounter(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        count = (count == null) ? 1 : count + 1;
        session.setAttribute("count", count);
        return "Session count is " + count;
    }

    @GetMapping("/clear")
    public String clear(HttpSession session) {
        session.invalidate();
        return "Session invalidated";
    }

}
