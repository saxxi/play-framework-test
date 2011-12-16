package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Products extends Application {

    public static void index() {
        List prods = Product.findAll();
        
        for (int iprod = 0; iprod < prods.size(); iprod++) {
            // Product x = prods.get(iprod);
            Product x = Product.find("byTitle", "armadio rosso").first();
            // renderText(x.slug);
        }
        
        long total_prods = Product.count();
        
        render(prods, total_prods);
    }
    
    public static void create(Product prod) {
        prod.save();
        renderText("success");
    }
    
    public static void rest_new(Long id) {
        Product prod = new Product();
        render(prod);
    }
    
    public static void edit(String prod_slug) {
        Product prod = Product.find("bySlug", prod_slug).first();
        render(prod);
    }
    
    public static void show(Long id) {
        Product prod = Product.findById(id);
        render();
    }
    
    public static void update(Long id, Product prod) {
        Product dbProd = Product.findById(id);
        // dbProd.update_attributes(prod); //TODO: do a safe merge
        dbProd.save();
        renderText("success");
    }
    
    public static void delete(Long id) {
        Product prod = Product.findById(id);
        //TODO: first check authority
        prod.delete();
        renderText("success");
    }
    
    
    
}