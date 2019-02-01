package koreatech.cse.controller;

import koreatech.cse.domain.Board;
import koreatech.cse.domain.User;
import koreatech.cse.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Inject
    private BoardMapper boardMapper;

    @Value("${env.username}")
    private String username;


    @RequestMapping("/write")
    public String write(Model model){
        Board board = new Board();
        model.addAttribute("board",board);
        return "write";
    }

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public String write(Model model,@ModelAttribute Board board) throws IOException{

        boardMapper.insert(board);

        String saveName = uploadFile(board.getFile().getOriginalFilename(), board.getFile().getBytes());

        return "redirect:/index";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam int id) {
        boardMapper.delete(id);
        return "redirect:/index";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("board", boardMapper.findOne(id));
        return "writeEdit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute Board board) {
        boardMapper.update(board);

        return "redirect:/index";
    }



    @Resource(name = "uploadPath")
    private String uploadPath;


    //업로드된 파일을 저장하는 함수
    private String uploadFile(String originalName, byte[] fileDate) throws IOException {

        UUID uid = UUID.randomUUID();
        String savedName = uid.toString() + "_" + originalName;
        File target = new File(uploadPath, savedName);

        //org.springframework.util 패키지의 FileCopyUtils는 파일 데이터를 파일로 처리하거나, 복사하는 등의 기능이 있다.
        FileCopyUtils.copy(fileDate, target);

        return savedName;

    }



}
