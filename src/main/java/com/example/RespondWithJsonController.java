package com.example;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/json-res")

public class RespondWithJsonController {
    Gem pearl = new Gem("Pearl", "Spear");
    Gem ruby = new Gem("Ruby", "Gauntlet");
    Gem sapphire = new Gem("Sapphire", "none");
    Gem amethyst = new Gem("Amethyst", "whip");

    Gem[] crystalGems = new Gem[] {pearl, ruby, sapphire, amethyst};

    Fusion garnet = new Fusion("Garnet", new Gem[] {ruby, sapphire});
    Fusion sugilite = new Fusion("Sugilite", new Gem[] {ruby, sapphire, amethyst});
    Fusion sardonyx = new Fusion("Sardonyx",new Gem[] {ruby, sapphire, pearl});
    Fusion opal = new Fusion("Opal", new Gem[] {pearl, amethyst});

    Fusion[] fusions = new Fusion[] {garnet, sugilite, sardonyx, opal};


    @GetMapping("/gem/{gem}")
    public Gem getGem(@PathVariable String gem){
        Gem targetGem = new Gem(null, null);

        for (Gem eachGem : crystalGems) {
            if(eachGem.getName().toLowerCase().equals(gem)){
                targetGem = eachGem;
            }
        }
        return targetGem;
    }

    @GetMapping("/fusion/{fusion}")
    public Fusion getFusion(@PathVariable String fusion){
        Fusion targetFusion = new Fusion(null, null);

        for (Fusion eachFusion : fusions) {
            if(eachFusion.getName().toLowerCase().equals(fusion)){
                targetFusion = eachFusion;
            }
        }
        return targetFusion;
    }

}
