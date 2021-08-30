package com.barshop.app.web.util;


public class StringUtils {

    public final static String MSG_INIT = "INIT ";

    public final static String MSG_FINISH = "FINISH ";

    public static final String MSG_METHOD_DURATION = "[%].[%] -> %";

    public static final String NOT_RESULT = "[%].[%] No se encontraron registros";

    public static final String MSG_HIB_ERROR = "[%].[%] Error Hibernate -> %";

    public static final String MSG_ERROR = "[%].[%] Error -> %";

    public static final String MSG_DURATION = "[%].[%] -> %";

    private StringUtils() throws InstantiationException {
        throw new InstantiationException("You can't create new instance of StringUtils.");
    }

    public static String concat( Object... objects ) {
        StringBuilder sb = new StringBuilder();

        for (Object obj : objects) {
            if (obj != null) {
                sb.append(" ").append(obj);
            }
        }
        return sb.toString();
    }
    
    public static String replaceValues( String text, Object... values ) {
        return replaceValues(text, '%', values);
    }       

    public static String replaceValues( String text, char regex, Object... values ) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == regex) {
                if (j < values.length) {
                    sb.append(values[j]);
                } else {
                    sb.append(text.charAt(i));
                }
                j++;
            } else {
                sb.append(text.charAt(i));
            }
        }
        return sb.toString();
    }         
    
}
