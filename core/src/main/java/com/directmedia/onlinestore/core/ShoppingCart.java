/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.directmedia.onlinestore.core;

import com.directmedia.onlinestore.core.entity.Work;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author damien
 */
public class ShoppingCart {
    
    private Set<Work> items = new HashSet<>();
    
    public ShoppingCart(){
        
    }

    public Set<Work> getItems() {
        return items;
    }

    public void setItems(Set<Work> items) {
        this.items = items;
    }
    
    
}
