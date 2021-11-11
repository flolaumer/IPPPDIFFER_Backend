package com.vw.ipppdiffer.service;

import com.vw.ipppdiffer.model.enums.ColourType;
import com.vw.ipppdiffer.model.response.Element;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.HashSet;
import java.util.List;

@Component
public class DifferComponent {

    public void compareTrees(List<Element> firstTree, List<Element> secondTree) {
        if (CollectionUtils.isEmpty(firstTree) && CollectionUtils.isEmpty(secondTree)) {
            return;
        }
        for (Element fElement : firstTree) {
            if (!ColourType.NONE.value.equals(fElement.getColor())) {
                continue;
            }
            int indexOfFirstNode = firstTree.indexOf(fElement);
            visitBasedOnAttributes(secondTree, fElement, indexOfFirstNode);
            visitBasedOnPosition(secondTree, fElement);
        }
        setColorRecursively(secondTree, ColourType.RED);
        setColorRecursively(firstTree, ColourType.GREEN);
    }

    private void visitBasedOnPosition(List<Element> secondTree, Element fElement) {
        for (Element sElement : secondTree) {
            if (!ColourType.NONE.value.equals(sElement.getColor())) {
                continue;
            }
            if (fElement.getName().equals(sElement.getName())) {
                if (haveEqualAttributes(fElement, sElement, true) && haveEqualValue(fElement.getValue(), sElement.getValue())) {
                    fElement.setColor(ColourType.BLACK.value);
                    sElement.setColor(ColourType.BLACK.value);
                } else {
                    fElement.setColor(ColourType.ORANGE.value);
                    sElement.setColor(ColourType.ORANGE.value);
                }
                compareTrees(fElement.getChildren(), sElement.getChildren());
                break;
            }
        }
    }

    private void visitBasedOnAttributes(List<Element> secondTree, Element fElement, int indexOfFirstNode) {
        for (Element sElement : secondTree) {
            if (!ColourType.NONE.value.equals(sElement.getColor())) {
                continue;
            }
            int indexOfSecondNode = secondTree.indexOf(sElement);
            if (fElement.getName().equals(sElement.getName())
                    && haveEqualAttributes(fElement, sElement, false)
                    && haveEqualValue(fElement.getValue(), sElement.getValue())
                    && indexOfFirstNode != indexOfSecondNode) {
                fElement.setColor(ColourType.ORANGE.value);
                sElement.setColor(ColourType.ORANGE.value);
                compareTrees(fElement.getChildren(), sElement.getChildren());
                break;
            }
        }
    }

    private void setColorRecursively(List<Element> tree, ColourType colour) {
        for (Element node : tree) {
            if (ColourType.NONE.value.equals(node.getColor())) {
                node.setColor(colour.value);
            }
            if (!CollectionUtils.isEmpty(node.getChildren())) {
                setColorRecursively(node.getChildren(), colour);
            }
        }
    }

    private boolean haveEqualValue(String firstValue, String secondValue) {
        if (firstValue == null && secondValue == null) {
            return true;
        }
        return firstValue != null && firstValue.equals(secondValue);
    }

    private boolean haveEqualAttributes(Element firstElement, Element secondElement, boolean nullable) {
        if (CollectionUtils.isEmpty(firstElement.getAttributes()) && CollectionUtils.isEmpty(secondElement.getAttributes())) {
            return nullable;
        }
        return new HashSet<>(firstElement.getAttributes()).equals(new HashSet<>(secondElement.getAttributes()));
    }

}
