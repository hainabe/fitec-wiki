package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.model.MessageModel;
import com.fitec.formation.wiki.util.MessageUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = MessageUtil.CROSS_ORIGIN)
@Controller
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/welcome")
    public ResponseEntity<Object> greet() {
        System.out.println("######################################## Hieeee ~!");
        return new ResponseEntity<>(new MessageModel(MessageUtil.MSG_SUCCESS_LOAD), HttpStatus.FOUND);
    }
}
