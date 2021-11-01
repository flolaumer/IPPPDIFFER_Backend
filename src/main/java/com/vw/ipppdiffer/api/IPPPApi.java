package com.vw.ipppdiffer.api;

import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
public interface IPPPApi {

    @GetMapping("differ")
    IB1 getDiffer();

    @PostMapping("get-tree")
    Element getTree(@RequestParam("file") MultipartFile file);
}
