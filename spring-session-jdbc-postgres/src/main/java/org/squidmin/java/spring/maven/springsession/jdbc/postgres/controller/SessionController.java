package org.squidmin.java.spring.maven.springsession.jdbc.postgres.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {

    /**
     * Endpoint to increment a session counter.
     * If the session does not have a "count" attribute, it initializes it to 1.
     * Otherwise, it increments the existing count by 1.
     *
     * @param session the HTTP session
     * @return a message indicating the current session count
     */
    @GetMapping("/increment")
    public String incrementCounter(HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        count = (count == null) ? 1 : count + 1;
        session.setAttribute("count", count);
        return "Session count is " + count;
    }

    /**
     * Endpoint to clear the session by invalidating it.
     * This will remove all attributes and invalidate the session.
     *
     * @param session the HTTP session
     * @return a message indicating that the session has been invalidated
     */
    @GetMapping("/clear")
    public String clear(HttpSession session) {
        session.invalidate();
        return "Session invalidated";
    }

    /**
     * Endpoint to retrieve session information.
     * It returns the session ID, visit count, creation time, last accessed time,
     * user information (if available), and max inactive interval.
     *
     * @param session   the HTTP session
     * @param principal the authenticated user's principal
     * @return a map containing session information
     */
    @GetMapping("/info")
    public Map<String, Object> sessionInfo(HttpSession session, Principal principal) {
        Integer visits = (Integer) session.getAttribute("VISIT_COUNT");
        visits = (visits == null) ? 1 : visits + 1;
        session.setAttribute("VISIT_COUNT", visits);

        Map<String, Object> data = new HashMap<>();
        data.put("sessionId", session.getId());
        data.put("visitCount", visits);
        data.put("creationTime", new Date(session.getCreationTime()));
        data.put("lastAccessedTime", new Date(session.getLastAccessedTime()));

        if (principal != null) {
            data.put("user", principal.getName());
        } else {
            data.put("user", "anonymous");
        }

        data.put("maxInactiveInterval", session.getMaxInactiveInterval());

        return data;
    }

}
