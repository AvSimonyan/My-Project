package com.example.myrealestate.controller;

import com.example.myrealestate.model.CurrentUser;
import com.example.myrealestate.model.Property;
import com.example.myrealestate.model.PropertyFeatures;
import com.example.myrealestate.repository.PropertyFeatureRepository;
import com.example.myrealestate.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class PropertyController {
    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyFeatureRepository propertyFeatureRepository;

    @GetMapping("/property/submit")
    public String submitProperty(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        if (currentUser != null) {
            modelMap.addAttribute("currentUser", currentUser.getUser());
        }
        List<PropertyFeatures> featuresList = propertyFeatureRepository.findAll();
        modelMap.addAttribute("features", featuresList);
        return "submitProperty";
    }

    @PostMapping("/property/submit")
    public String submitPropertyPost(@ModelAttribute Property property,
                                     @RequestParam("img") MultipartFile multipartFile) throws IOException
                                 /*     @RequestParam("features") List<Long> features)*/ {

     /*  List<PropertyFeatures> allById = propertyFeatureRepository.findAllById(features);
        property.setFeatureProperty(allById);*/
        String picName = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
        File file = new File("E:\\upload" + picName);
        multipartFile.transferTo(file);
        property.setPicUrl(picName);
        propertyRepository.save(property);
        return "redirect:/";

    }
}
