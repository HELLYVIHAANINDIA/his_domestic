package com.hisd.common.services;

import java.io.Serializable;

/**
 * Class that will provide (label,value) pair to render in the drop down lists.
 */
public class SelectItem implements Serializable{

    private Object label;
    private Object value;
    private Object selectedVal;

    public SelectItem() {
    }

    public SelectItem(Object label, Object value) {
        this.label = label;
        this.value = value;
    }

    public SelectItem(Object label, Object value, Object selectedVal) {
        this.label = label;
        this.value = value;
        this.selectedVal = selectedVal;
    }
        
    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getSelectedVal() {
        return selectedVal;
    }

    public void setSelectedVal(Object selectedVal) {
        this.selectedVal = selectedVal;
    }    
}
