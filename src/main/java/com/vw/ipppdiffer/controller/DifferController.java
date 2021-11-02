package com.vw.ipppdiffer.controller;


import com.vw.ipppdiffer.api.IPPPApi;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import com.vw.ipppdiffer.service.DifferService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DifferController implements IPPPApi {

    private final DifferService service;

    @Override
    public IB1 getDiffer() {
        return service.getDiffer();
    }

    @Override
    public Element getTree(MultipartFile file) {
        return service.getTreeStructure(file);
    }
}
