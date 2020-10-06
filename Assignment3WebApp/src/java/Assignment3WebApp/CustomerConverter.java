/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Alerz
 */
@FacesConverter(value = "customerConverter")
public class CustomerConverter implements Converter {
    
    @EJB
    private CustomerEJB customerEJB;
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String regex = value.split(" ")[1];
        Pattern pattern = Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(regex);
        if (matcher.find())
        {
            // Matcher.group returning null.
            return customerEJB.findCustomerById(Long.parseLong(matcher.group()));
        }
        
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
