package fr.utbm.dvdstore.corestore.util;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author java
 */
public class Converter {
    /**
     * convert dto to bean or bean to dto
     * the two params must have few properties together
     * @param dest
     * @param src 
     */
    static public void convert(Object dest, Object src){
        
        try {
            BeanUtils.copyProperties(dest, src);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
