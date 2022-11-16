package com.jdreyes.proyecto.web;

import com.jdreyes.proyecto.conf.DbConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${app.version}")
    private String appVersion;

    @GetMapping("/version")
    public ResponseEntity<String> apiVersion() {
        return ResponseEntity.ok(String.format("<h1 style:\"color=green;\">%s</h1>", appVersion));
    }

}
