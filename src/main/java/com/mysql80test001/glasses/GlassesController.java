package com.mysql80test001.glasses;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/glasses")
public class GlassesController {

    @Autowired
    private GlassesRepository glassesRepository;


@PostMapping(path="/add")
    public @ResponseBody String addNewGlasses (@RequestParam String name) { //responsebody gør at stringen i linje 21 vises, og IKKE referer til en html fil i templates.
    GlassesModel glasses = new GlassesModel();
    glasses.setName(name);
    glassesRepository.save(glasses);
    System.out.println("user sucessfiully saved inside GlassesController."); //remember to remove this comment
    return "New Glasses Saved sucesfully";
}
@GetMapping(path="/all")
    public @ResponseBody Iterable<GlassesModel> getAllGlasses() {
    return glassesRepository.findAll();
}


}
