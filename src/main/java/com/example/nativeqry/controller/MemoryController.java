package com.example.nativeqry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MemoryController {

    @GetMapping("/memory")
    public Map<String,String> getMemoryUsage(){
        Map<String,String> map = new HashMap<>();
        map.put("Used Memory",(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) + " bytes");
        map.put("Free Memory",Runtime.getRuntime().freeMemory() + " bytes");
        map.put("Total Memory",Runtime.getRuntime().totalMemory() + " bytes");
        map.put("Max Memory",Runtime.getRuntime().maxMemory() + " bytes");
        return map;
    }

}
