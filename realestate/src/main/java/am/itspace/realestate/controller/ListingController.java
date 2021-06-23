package am.itspace.realestate.controller;

import am.itspace.realestate.model.CurrentUser;
import am.itspace.realestate.model.Listing;

import am.itspace.realestate.repository.ListingFeatureRepository;
import am.itspace.realestate.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class ListingController {
    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private ListingFeatureRepository listingFeatureRepository;

    @GetMapping("/listing/add")
    public  String addListing(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser){
        if (currentUser !=null) {
            modelMap.addAttribute("currentUser", currentUser.getUser());
        }
        List<Listing> featureList = listingFeatureRepository.findAll();
        modelMap.addAttribute("feature",featureList);

        return "addListing";

    }
    @PostMapping("listing/add")
    public String addListingPost(@ModelAttribute Listing listing, @RequestParam ("img")MultipartFile multipartFile,@RequestParam("features") List<Integer> features){


        System.out.println(listing);
        return "redirect:/listing/add";

    }
}
