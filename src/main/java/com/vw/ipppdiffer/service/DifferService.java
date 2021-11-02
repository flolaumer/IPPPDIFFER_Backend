package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import org.springframework.web.multipart.MultipartFile;

public interface DifferService {
    DifferResponse getDiffer(MultipartFile firstFile, MultipartFile secondFile);

    Element getTreeStructure(MultipartFile file);
}
