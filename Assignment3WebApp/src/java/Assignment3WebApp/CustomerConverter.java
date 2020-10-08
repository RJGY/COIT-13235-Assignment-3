/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3WebApp;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

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
        
        // If null, dont proceed.
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Eg. Start with customer.toString() which is Customer[ id=123 firstName=James lastName=Bond ]
        // Split string into multiple parts of toString. 
        // We are left with id=123
        String regex = value.split(" ")[1];
        
        // substring to remove "id=" from the string.
        // We are left with 123
        regex = regex.substring(3).trim();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CustomerID: " + regex, regex));
        try {
            return customerEJB.findCustomerById(Long.parseLong(regex));
        } catch (NullPointerException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Customer is null.", e.getMessage()));
            return null;
        }
        
        
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
