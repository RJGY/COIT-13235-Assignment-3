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

@FacesConverter(value="carConverter")
public class CarConverter implements Converter {

    @EJB
    private CarEJB carEJB;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        // If null, dont proceed.
        if (value == null || value.isEmpty()) {
            return null;
        }
        // Eg. Start with car.toString() which is Car[ id=1 brand=Honda model=Accord Euro ]
        // Split string into multiple parts of toString. 
        // We are left with id=1
        String regex = value.split(" ")[1];
        
        // Substring to remove "id=" from the string.
        // We are left with 1
        regex = regex.substring(3).trim();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "CarID: " + regex, regex));
        
        try {
            return carEJB.findCarById(Long.parseLong(regex));
        } catch(NullPointerException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Car is null.", e.getMessage()));
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return value.toString();
    }
    
}
