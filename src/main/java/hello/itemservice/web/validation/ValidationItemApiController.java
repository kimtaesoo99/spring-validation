package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import hello.itemservice.web.validation.form.ItemUpdateForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/validation/api/items")
@Slf4j
public class ValidationItemApiController {

    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult){
        log.info("API 컨트롤러 호출");

        if (bindingResult.hasErrors()){
            log.info("겅증 오류 발생 errors ={}",bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("성공 로직 실행");
        return form;
    }


    @PutMapping("/edit")
    public Object editItem(@RequestBody @Validated ItemUpdateForm form, BindingResult bindingResult){
        log.info("API 컨트롤러 호출");

        if (bindingResult.hasErrors()){
            log.info("겅증 오류 발생 errors ={}",bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("성공 로직 실행");
        return form;
    }


}
