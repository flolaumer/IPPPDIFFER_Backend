package com.vw.ipppdiffer.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DifferResponse {
    private Element firstTree;
    private Element secondTree;

}
