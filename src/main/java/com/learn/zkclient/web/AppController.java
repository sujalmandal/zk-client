package com.learn.zkclient.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.zkclient.service.ZkService;

@RestController
@RequestMapping(
    "/zkclient"
)
public class AppController {

    @Autowired
    private ZkService zkService;

    @GetMapping(
	"/instances"
    )
    public ResponseEntity<?> getAllInstances() {
	return ResponseEntity.ok(zkService.getRegisteredInstances());
    }
}