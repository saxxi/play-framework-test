package models;

import java.util.*;
import play.data.binding.As;

import play.db.jpa.*;
import play.data.validation.*;
import play.templates.*;
import play.mvc.Scope.*;

import javax.persistence.*;

import play.Logger;
import play.templates.JavaExtensions;

@Entity
public class Product extends Model {
    
    public String title;
    public String slug;
    public Integer qty;
    public Date updated;
    
    @As(lang={"*"}, value={"yyyy-MM-dd hh:mm:ss"}) 
    public Date creationDate;
    
    
    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
        slug = JavaExtensions.slugify(title);
    }
    
}

