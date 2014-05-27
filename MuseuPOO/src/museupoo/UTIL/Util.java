/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package museupoo.UTIL;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Victor
 */
public class Util 
{
    
    public static String DateTimeString(Date date)
    {
        return String.format("%02d", date.getDate()) + "/" + String.format("%02d", date.getMonth()+1)+ "/"  + String.format("%04d", date.getYear()+1900)+ "    " + String.format("%02d", date.getHours()) + ":"+String.format("%02d", date.getMinutes()) ; 
    }   
    
    public static String DateTimeString(Calendar date)
    {
        return String.format("%02d", date.get(Calendar.DATE)) + "/" + String.format("%02d", date.get(Calendar.MONTH) + 1)+ "/"  + String.format("%04d",date.get(Calendar.YEAR)); 
    } 

    public static String DateStringSQL(Calendar date) 
    {
       return String.format("%04d",date.get(Calendar.YEAR)) + "-" + String.format("%02d", date.get(Calendar.MONTH))+ "-"  + String.format("%02d", date.get(Calendar.DATE));
    }
}
