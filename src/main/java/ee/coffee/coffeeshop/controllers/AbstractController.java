package ee.coffee.coffeeshop.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Slf4j
public abstract class AbstractController {
    static final String ATTR_ERROR_MESSAGE = "errorMessage";
    
//
//    attribute for binding errors (List<ObjectError>)
//
    static final String ATTR_ERRORS = "errors";
    
    static final String ATTR_INFO_MESSAGE = "infoMessage";
    
    static final String ATTR_LIST = "list";

    protected void setErrorMessage(Model model, Exception ex) {
        model.addAttribute(ATTR_ERROR_MESSAGE, ex.getMessage());
    }
    
//    protected void setInfoMessage(Model model, Exception ex) {
//        model.addAttribute(ATTR_INFO_MESSAGE, ex.getMessage());
//    }
//
    protected void setList(Model model, List<?> list) {
        model.addAttribute(ATTR_LIST, list);
    }
    
    protected String redirect(String uri) {
        return "redirect:" + uri;
    }
    
    protected boolean checkErrors(Model model, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            model.addAttribute(ATTR_ERRORS, bindingResult.getAllErrors());
            return true;
        }
        return false;
    }
    
    protected String encode(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }
    
    // запускаем операцию runnable, обрабатывая ошибки с последующим редиректом
    protected String doWithRedirect(String uri, Runnable runnable) {
        String error = null;
        try {
            runnable.run();
        } catch(DataIntegrityViolationException ex) {
            error = "Can't delete because referencing record(s) exist";
        } catch(Exception ex) {
            log.error("Unexpected error in " + this.getClass().getName(), ex);
            error = "Unexpected error";
        }
        return redirect(uri + "?" + (error == null ? "" : "error=" + encode(error)));
    }
}
