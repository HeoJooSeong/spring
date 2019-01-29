package koreatech.cse.controller;

import koreatech.cse.domain.Board;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.inject.Inject;
import java.util.Date;

@Controller
@RequestMapping("/board")
public class BoardController {

    @RequestMapping("/write")
    public String write(Model model){
        Board board = new Board();
        model.addAttribute("board",board);
        return "write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(Model model,@ModelAttribute Board board){
        System.out.println(board.toString());
        board.setDateTime(new Date());
        board.setHits(1);
        model.addAttribute("board",board);

        return "index";
    }
}
