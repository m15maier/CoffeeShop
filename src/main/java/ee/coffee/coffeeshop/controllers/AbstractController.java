package ee.coffee.coffeeshop.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

public abstract class AbstractController {

    static final Long NEW_ENTITY_ID = 0L;
    static final String ATTR_ERROR_MESSAGE = "errorMessage";
    
    /**
     * attribute for binding errors (List<ObjectError>)
     */
    static final String ATTR_ERRORS = "errors";
    
    static final String ATTR_INFO_MESSAGE = "infoMessage";
    
    static final String ATTR_LIST = "list";

    protected void setErrorMessage(Model model, Exception ex) {
        model.addAttribute(ATTR_ERROR_MESSAGE, ex.getMessage());
    }
    
    protected void setInfoMessage(Model model, Exception ex) {
        model.addAttribute(ATTR_INFO_MESSAGE, ex.getMessage());
    }
    
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
}
