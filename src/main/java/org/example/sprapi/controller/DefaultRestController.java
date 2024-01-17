package org.example.sprapi.controller;

import org.example.sprapi.dto.TbboardDto;
import org.example.sprapi.service.TbboardService;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "1. Name",
        description = "description")
@RequestMapping("/api")
@RestController //페이지를 보여주는 것이 아니라, Rest 방식을 사용할때!!
public class DefaultRestController {

    @Operation(summary = "요약제목",
        description = "~~을 위한 컨트롤러 (~~만 접근 가능) <br />"
                + "@param Tb~~Dto tb~~Dto <br />"
                + "@return HttpStatus.CREATED(201) ResponseEntity\\<Tb~~Dto\\> <br />"
                + "@exception 중복 <br />"
    )
    @PostMapping("/btest")
    public int btest(
            @RequestBody TbboardDto.TbboardCreateDto params
            //@RequestBody Map<String, Object> param
    ){
        System.out.println("2! params : " + params.getTitle());
        System.out.println("1! params : " + params.getContent());
        //int result_int = 0;
        int result_int = tbboardService.create1(params);
        //result_int = tbboardService.create(param);
        return result_int;
    }


    private final TbboardService tbboardService;
    public DefaultRestController(TbboardService tbboardService) {
        this.tbboardService = tbboardService;
    }
    //오토와이어드 쓸수도 있지만, 이렇게 주입하는 방식을 선호!!

    @GetMapping({"/paramTest"})
    public Map<String, Object> paramTest(
            @RequestParam String aaa
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }
    @GetMapping({"/test"})
    public Map<String, Object> getTest() {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("name", "sprapi!!");
        a_map.put("phone", "010!!");
        return a_map;
    }

    @GetMapping({"/create"})
    public int createTbboard(
            @RequestParam(value = "aaa", required = true) String aaa
            /*
            @RequestParam(value = "title", required = true) String title
            ,@RequestParam(value = "content", required = true) String content
    */
    ) {
        System.out.println("aaa//" + aaa);
        String title = "122334";
        String content = "2244555";
        System.out.println(title + "//" + content);
        //등록하기
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("title", title);
        a_map.put("content", content);

        int result_int = tbboardService.create(a_map);
        /*
        Tbboard tbboard = Tbboard.of("제목 예시", "내용 예시");
        tbboard = tbboardRepository.save(tbboard);
        */
        return result_int;
    }

    @GetMapping({"/update"})
    public int updateTbboard(
    ) {
        Map<String, Object> a_map = new HashMap<>();
        a_map.put("id", "a29d2abd-7df2-4e3c-acbd-61c84545c52a");
        a_map.put("title", "updated");
        int result_int = tbboardService.update(a_map);
        return result_int;
    }

//    @GetMapping({"/btest"})
//    public int btest(
//            @RequestBody Map<String, Object> amap
//        ){
//        return 0;
//        }

}
