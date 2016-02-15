package org.toilelibre.libe.prime;

import java.util.Arrays;

import javassist.CtClass;

public class DefaultResponseBuilder {

    public static String getDefaultResponseForType (final CtClass returnType) {
        if (Arrays.asList (CtClass.intType, CtClass.byteType, CtClass.charType, CtClass.doubleType, CtClass.floatType, CtClass.intType, CtClass.longType, CtClass.shortType)
                .contains (returnType)) {
            return "0";
        }
        if (returnType == CtClass.booleanType) {
            return "false";
        }
        if (returnType != CtClass.voidType) {
            return "null";
        }
        return "";
    }

}
