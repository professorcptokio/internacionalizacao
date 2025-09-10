package com.example.internacionalizacao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import java.util.Locale;
import org.springframework.context.i18n.LocaleContextHolder;
import com.example.internacionalizacao.util.TextManagement;

@Controller
public class Home {

    @Autowired
    private MessageSource messageSource;
    
    @GetMapping("/")
    public String index(Locale locale, Model model){
        model.addAttribute("mensagem", messageSource.getMessage("mensagem", null, locale));
        return "index";
    }

    @GetMapping("/opcao2")
    public String opcao2(Model model){
        Locale locale = LocaleContextHolder.getLocale();
        model.addAttribute("mensagem", messageSource.getMessage("mensagem", null, locale));
        return "index";
    }

    @Autowired
    private TextManagement textManagement;
    @GetMapping("/opcao3")
    public String opcao3(Model model){
        model.addAttribute("mensagem", textManagement.getMessage("mensagem", null));
        return "index";
    }

    @GetMapping("/com/{userName}")
    public String opcao3(@PathVariable String userName, Model model){
        model.addAttribute("mensagem", 
        textManagement.getMessage("mensagemcomparametro", new Object[]{userName}));
        return "index";
    }
}