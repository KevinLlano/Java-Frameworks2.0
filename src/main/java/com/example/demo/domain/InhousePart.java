package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part{
    private int partId;

    public InhousePart() {
        // ensures part class is initialized correctly
        super();
        // default values or min and max inventory
        this.setMinInventory(1);
        this.setMaxInventory(10);
    }
    // constructor for InhousePart
    public InhousePart(String name, double price, int inv, int minInventory, int maxInventory) {
        super(name, price, inv);
        this.setMinInventory(minInventory);
        this.setMaxInventory(maxInventory);
        this.partId = partId;
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }

    public int getMaxInventory() {
        return maxInventory;
    }

    public void setMaxInventory(int maxInventory) {
        this.maxInventory = maxInventory;
    }
}

