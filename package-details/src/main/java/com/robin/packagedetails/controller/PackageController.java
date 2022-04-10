package com.robin.packagedetails.controller;

import com.robin.packagedetails.model.Package;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PackageController {

    @GetMapping("/getPackage/{userId}")
    public ResponseEntity<List<Package>> getPackage(@PathVariable("userId") String userId){
        List<Package> packages = new ArrayList<>();
        packages.add(Package.builder().packageId(20).packageName("vlk-krk-ngr").build());
        return ResponseEntity.ok().body(packages);
    }
}
