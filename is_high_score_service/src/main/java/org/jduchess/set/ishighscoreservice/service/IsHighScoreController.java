package org.jduchess.set.ishighscoreservice.service;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/highscore")
public class IsHighScoreController {
    private static final String COOKIE_NAME = "HighScoreForSet";

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/isHigh", produces = "application/json; charset=UTF-8")
    public Boolean isHighScore(HttpServletRequest request, @RequestParam("highScore") Integer highScore) {
        Cookie cookie = getHighScoreCookie(request);
        if (cookie == null) {
            return true;
        }
        return cookie.getValue() == null || Integer.valueOf(cookie.getValue()) < highScore;
    }

    private Cookie getHighScoreCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies).filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst().orElse(null);
        }
        return null;
    }

}
