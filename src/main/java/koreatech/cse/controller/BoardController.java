package koreatech.cse.controller;

import koreatech.cse.domain.Board;
import koreatech.cse.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.inject.Inject;
import java.util.Date;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Inject
    private BoardMapper boardMapper;

    @RequestMapping("/write")
    public String write(Model model){
        Board board = new Board();
        model.addAttribute("board",board);
        return "write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(Model model,@ModelAttribute Board board){
        boardMapper.insert(board);
        return "redirect:/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id) {
        boardMapper.delete(id);
        return "redirect:/index";
    }
}
