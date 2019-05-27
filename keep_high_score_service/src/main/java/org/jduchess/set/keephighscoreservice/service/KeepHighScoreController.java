package org.jduchess.set.keephighscoreservice.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

@RestController
@RequestMapping("/highscore")
public class KeepHighScoreController {
    private static final String COOKIE_NAME = "HighScoreForSet";

    @RequestMapping(method = RequestMethod.PUT, value="/set")
    public void setHighScore(HttpServletRequest request,
                             HttpServletResponse response, @RequestParam("highScore") Integer highScore) {
        Cookie cookie = getHighScoreCookie(request);
        if (cookie == null) {
            cookie = new Cookie(COOKIE_NAME, highScore.toString());
        } else {
            cookie.setValue(highScore.toString());
        }
        response.addCookie(cookie);
    }

    private Cookie getHighScoreCookie(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            return Arrays.stream(cookies).filter(cookie -> COOKIE_NAME.equals(cookie.getName())).findFirst().orElse(null);
        }
        return null;
    }
}
