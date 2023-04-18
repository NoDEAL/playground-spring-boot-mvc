package studio.hcmc.egov.spring.boot.mvc.controller.user;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import studio.hcmc.egov.spring.boot.mvc.vo.user.UserVO;

@Controller
public class UserController {
    /**
     * 로그인 View
     */
    @RequestMapping(
            value = "/user/signIn.do",
            method = RequestMethod.GET
    )
    public String signInView(
            Model model,
            HttpSession session
    ) {
        final var userVO = (UserVO) session.getAttribute("userVO");
        if (userVO != null) {
            // 사용자 정보가 세션에 존재: 이미 로그인함
            return "redirect:/home.do";
        }

        model.addAttribute("userVO", new UserVO());

        return "/user/signIn";
    }

    /**
     * 로그인
     */
    @RequestMapping(
            value = "/user/signIn.do",
            method = RequestMethod.POST
    )
    public String signIn(
            Model model,
            UserVO userVO,
            HttpSession session
    ) {
        final var email = userVO.getEmail();
        if (email == null) {
            // TODO validate: email
            throw new AssertionError("email is null");
        }

        final var password = userVO.getPassword();
        if (password == null) {
            // TODO validate: password
            throw new AssertionError("password is null");
        }

        // TODO database: implementation
        session.setAttribute("userVO", userVO);

        return "redirect:/home.do";
    }
}
