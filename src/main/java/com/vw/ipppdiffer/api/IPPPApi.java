package com.vw.ipppdiffer.api;

import com.vw.ipppdiffer.exception.DifferParseException;
import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api")
public interface IPPPApi {

    @PostMapping("differ")
    DifferResponse startDiffer(@RequestParam("firstFile") MultipartFile firstFile, @RequestParam("secondFile") MultipartFile secondFile) throws DifferParseException;

    @PostMapping("get-tree")
    Element getTree(@RequestParam("file") MultipartFile file) throws DifferParseException;
}
