package com.fitec.formation.wiki.controller;

import com.fitec.formation.wiki.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api")
public class ArticleController {

    @Autowired
    ArticleService articleService;
}
