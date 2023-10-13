package com.solution.appsolute.board.controller;


import com.solution.appsolute.board.dao.BoardCommentRepository;
import com.solution.appsolute.board.dao.BoardRepository;
import com.solution.appsolute.board.dao.EmployeeRepository;
import com.solution.appsolute.board.dto.BoardCommentDto;
import com.solution.appsolute.board.dto.BoardDto;
import com.solution.appsolute.board.dto.BoardEditDto;
import com.solution.appsolute.board.service.BoardCommentService;
import com.solution.appsolute.board.service.BoardService;
import com.solution.appsolute.entity.Board;
import com.solution.appsolute.entity.BoardComment;
import com.solution.appsolute.entity.Employee;
import com.solution.appsolute.login.dto.AuthInfo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/board")
public class BoardController {


    @Autowired
    private final BoardService boardService;
    @Autowired
    private final BoardRepository boardRepository;
    @Autowired
    private final BoardCommentService boardCommentService;
    @Autowired
    private final BoardCommentRepository boardCommentRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;

    @GetMapping("/boardForm")
    public String addBoard() {
        return "/board/boardForm";
    }

    //
    @PostMapping("/boardForm")
    public String createBoard(@ModelAttribute BoardDto boardDto, Model model
            , HttpSession session) {

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

        if (authInfo != null) {
            String createdBy = authInfo.getEmp_name();

            LocalDate currentDateTime = LocalDate.now();

        boardDto.setCreatedBy(createdBy);
        boardDto.setCountVisit(0L);
        boardDto.setCreatedDate(currentDateTime);

        boardService.saveBoard(boardDto);

//            if (!attachment.isEmpty()) {
//
//                String fileName = attachment.getOriginalFilename();
//                String fileExtension = fileName.substring(fileName.lastIndexOf("."));
//                String newFileName = UUID.randomUUID() + fileExtension;
//
//                // 파일을 저장할 경로 설정
//                String uploadDir = "uploads/";
//
//                try {
//                    byte[] bytes = attachment.getBytes();
//                    Path path = Paths.get(uploadDir + newFileName);
//                    Files.write(path, bytes);
//
//
//                    boardDto.setAttachmentPath(uploadDir + newFileName);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//
//                }
//            }

        return "redirect:/board/boardList";

        } else {

            return "redirect:/login";
        }
    }


    @GetMapping("/boardList")
    public String boardList(Model model, @PageableDefault(size = 10) Pageable pageable,
                            @RequestParam(required = false, defaultValue = "") String searchText) {

        Page<Board> boards = boardRepository.findByTitleContaining(searchText, pageable);
        int startPage = Math.max(1, boards.getPageable().getPageNumber() - 1);
        int endPage = Math.min(boards.getTotalPages(), boards.getPageable().getPageNumber() + 3);


        model.addAttribute("boards", boards);
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        return "board/boardList";
    }

    @GetMapping("/boardContent/{id}")
    public String boardContent(@PathVariable("id") Long id, Model model) {
        Board board = boardRepository.findById(id).get();
        List<BoardComment> comments = boardCommentRepository.findCommentsBoardId(id);

        BoardDto boardDto = BoardDto.builder()
                .countVisit(board.getCountVisit()+1)
                .build();

        boardService.updateVisit(board.getId(), boardDto);

        boardService.countVisitLogic(id);

        model.addAttribute(board);
        model.addAttribute("comments", comments);

        return "/board/boardContent";
    }




    @PostMapping("/boardContent/{id}")
    public String addComment(@PathVariable("id") Long id, @ModelAttribute BoardCommentDto boardCommentDto, Model model, HttpSession session, String empName) {

        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");

        if (authInfo != null) {
            String createdBy = authInfo.getEmp_name();
        Board board = boardRepository.findById(id).get();

        Employee employee = employeeRepository.findByEmpName(empName);

        LocalDate now = LocalDate.now();

        BoardCommentDto boardCommentDtoSet = BoardCommentDto.builder()
                .content(boardCommentDto.getContent())
                .created_by(empName)
                .createdDate(now)
                .delete_check('N')
                .employee(employee)
                .board(board)
                .build();



        boardCommentService.saveBoardComment(boardCommentDto);

        List<BoardComment> comments = boardCommentRepository.findCommentsBoardId(id);

        model.addAttribute("comments", comments);
        model.addAttribute(board);
        return "redirect:/board/boardContent/" + id;

        } else {

            return "redirect:/login";
        }
    }


    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model){
        BoardDto boardDto = boardService.getBoard(id);
        model.addAttribute("dto", boardDto);
        return "board/boardEdit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute BoardDto dto, @RequestParam("id") Long id){

        dto.setId(id);
        boardService.update(dto);
        return "redirect:/board/boardContent/"+id;
    }


    @PostMapping("/delete")
    public String boardDelete(Long id) {
        boardService.deleteBoard(id);

        return "redirect:/board/boardList";
    }
}
