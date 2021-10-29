package com.vw.ipppdiffer.api;

import com.vw.ipppdiffer.model.xml.IB1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface IPPPApi {

    @GetMapping("differ")
    IB1 getDiffer();
}
