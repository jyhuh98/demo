package org.example.sprapi.service;

import org.example.sprapi.domain.Tbboard;
import org.example.sprapi.dto.TbboardDto;
import org.example.sprapi.repository.TbboardRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Supplier;
@Service
public class TbboardService {

    /*
    @Autowired
    TbboardRepository tbboardRepository;
    */
    private final TbboardRepository tbboardRepository;
    public TbboardService(TbboardRepository tbboardRepository) {
        this.tbboardRepository = tbboardRepository;
    }

    public int create(Map<String, Object> param){
        int result_int = 0;
        Tbboard tbboard = Tbboard.of(param.get("title") + "", param.get("content") + "");
        tbboard = tbboardRepository.save(tbboard);

        if((tbboard.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }
    public int create1(TbboardDto.TbboardCreateDto param){
        int result_int = 0;
        Tbboard tbboard = Tbboard.of(param.getTitle(), param.getContent());
        tbboard = tbboardRepository.save(tbboard);

        if((tbboard.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }

    public int update(Map<String, Object> param){
        //c23693ff-ac58-4a31-9f36-a15e6aa1553b
        String id = param.get("id") + "";
        String title = param.get("title") + "";
        Tbboard tbboard1 = tbboardRepository.findById(id).orElseThrow(new Supplier<EntityNotFoundException>() {
            @Override
            public EntityNotFoundException get() {
                return new EntityNotFoundException("id : ");
            }
        });
        System.out.println("1.title : " + tbboard1.getTitle());
        tbboard1.setTitle(title);
        tbboardRepository.save(tbboard1);
        System.out.println("2.title : " + tbboard1.getTitle());

        int result_int = 0;
        if((tbboard1.getId() + "").equals("null")){
        } else {
            result_int = 200;
        }
        return result_int;
    }
}
