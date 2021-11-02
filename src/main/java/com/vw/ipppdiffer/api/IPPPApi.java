package com.vw.ipppdiffer.api;

import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
public interface IPPPApi {

    @GetMapping("differ")
    String startDiffer2();

    @PostMapping("start-differ")
    DifferResponse startDiffer(@RequestParam("firstFile") MultipartFile firstFile, @RequestParam("secondFile") MultipartFile secondFile);

    @PostMapping("get-tree")
    Element getTree(@RequestParam("file") MultipartFile file);
}
