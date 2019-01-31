package koreatech.cse.controller;

import koreatech.cse.domain.Searchable;
import koreatech.cse.domain.User;
import koreatech.cse.repository.UserMapper;
import koreatech.cse.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;

@Controller
@RequestMapping("/user")
public class UserController {
    @Inject
    private UserMapper userMapper;
    @Inject
    private UserService userService;


    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "signup";
    }

    @Transactional
    @RequestMapping(value="/signup", method= RequestMethod.POST)
    public String signup(@ModelAttribute User user) {
        userService.signup(user);
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        return "redirect:/user/list";
//        return "list";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model,
                       @RequestParam(required=false) String name,
                       @RequestParam(required=false) String email,
                       @RequestParam(required=false) String order) {
        Searchable searchable = new Searchable();
        searchable.setName(name);
        searchable.setEmail(email);
        searchable.setOrderParam(order);
        model.addAttribute("users", userMapper.findByProvider(searchable));
//        model.addAttribute("users", userMapper.findByScript(searchable));
        return "list";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("user", userMapper.findOne(id));
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute User user) {
        System.out.println("user = " + user);
        userMapper.update(user);

        return "redirect:/user/list";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id) {
        userMapper.delete(id);
        return "redirect:/user/list";
    }


    @RequestMapping("/signin")
    public String signin() {
        return "signin";
    }

    @RequestMapping(value="/signinSuccess")
    public String signinSuccess(Model model) {
        System.out.println("signin Success");
        model.addAttribute("msg","성공했습니다.");
        return "redirect:/";
    }

    @RequestMapping(value="/signinFailed")
    public String signinFailed(Model model) {
        model.addAttribute("msg","실패했습니다.");
        System.out.println("signin Failed");
        return "redirect:/";
    }

    @RequestMapping(value = "/onlyUserByXml", method = RequestMethod.GET)
    public String test() {
        System.out.println("dd");
        return "redirect:/";
    }

}
