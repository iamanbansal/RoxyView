package com.aman.roxy;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation is to be used on List item view
 * viewType should be mentioned. It will help to decide which view has be to rendered
 */


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RoxyModelView {
 
  String viewType();

}

