package com.example.whatdoieat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.whatdoieat.entity.MenuEntity;
import com.example.whatdoieat.entity.OwnIngredientEntity;
import com.example.whatdoieat.entity.OwnIngredientsEntity;
import com.example.whatdoieat.service.MenuService;


@RestController
public class MenuController {
    @Autowired
    MenuService menuService;


    @GetMapping(value="/menu")
    public List<MenuEntity> fetchMenuList(){
        return menuService.fetchMenu();
    }
    
    @CrossOrigin(origins="http://localhost:4200")
    @PostMapping(value = "/canMakeMenu")
    @ResponseBody
    public List<MenuEntity> fetchCanMakeMenus(
        @RequestBody OwnIngredientsEntity ownIngredientsEntity){
        for (OwnIngredientEntity e :ownIngredientsEntity.getOwnIngredients()){
            System.out.println(e.getOwnIngredientName());
        }

        return menuService.fetchCanMakeMenus(ownIngredientsEntity.getOwnIngredients());

    }

    
}