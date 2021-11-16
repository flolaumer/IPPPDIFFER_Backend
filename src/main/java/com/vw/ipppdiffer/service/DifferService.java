package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.exception.DifferParseException;
import com.vw.ipppdiffer.model.response.DifferResponse;
import com.vw.ipppdiffer.model.response.Element;
import org.springframework.web.multipart.MultipartFile;

public interface DifferService {
    DifferResponse getDiffer(MultipartFile firstFile, MultipartFile secondFile) throws DifferParseException;

    Element getTreeStructure(MultipartFile file) throws DifferParseException;
}
