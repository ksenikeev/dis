package ru.itis.dis.arbiter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itis.dis.arbiter.bc.BlockChain;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;

@Controller
public class BlockchainUIController {

    private static Logger log = Logger.getLogger(BlockchainUIController.class.getName());

    @GetMapping(value = "/dis/autors")
    public String chainReult(HttpServletRequest request,
                             @ModelAttribute("model") ModelMap model) {

        model.addAttribute("chain", BlockChain.chain);

        return "neuro_result";
    }

}
