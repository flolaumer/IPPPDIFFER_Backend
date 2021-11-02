package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import com.vw.ipppdiffer.model.xml.IB1;
import org.springframework.web.multipart.MultipartFile;

public interface DifferService {
    DifferResponse getDiffer();

    Element getTreeStructure(MultipartFile file);


}
