package ee.coffee.coffeeshop.controllers;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import java.util.List;

public abstract class AbstractController {
	@Deprecated
	protected String redirect(String list)
	{
		return null;
	}
}
