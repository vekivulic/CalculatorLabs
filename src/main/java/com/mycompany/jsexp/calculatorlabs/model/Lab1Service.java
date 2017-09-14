/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.jsexp.calculatorlabs.model;

/**
 *
 * @author vekivulic
 */
public class Lab1Service {
    private static final double MIN_INPUT = 0.0;
    private static final String ERROR_INVALID_INPUT = 
            "Error: A valid input must be provided for length and width. "
            + "Input cannot be less than zero";
    private static final String NUMBER_FORMAT_MESSAGE = 
            "Input(s) given invalid. No negatives, please";
    /**
     * This method gains input stored as a String array, then returns a 
     * calculation, based on the CalculationType specified.
     * @param values values required for calculation
     * @param calcType the calculation type that is to be done. 
     * @return answer for calculation to be done.
     */
    public final String getResultForType(String[] values, CalculationType 
            calcType) throws NumberFormatException,IllegalArgumentException{
        String resultText = "unknown";
        switch(calcType){
            case RECTANGLE_AREA:
                try{
                    resultText =  calculateAreaOfRectangle(values[0],values[1]);
                }catch(Exception e){
                    resultText = NUMBER_FORMAT_MESSAGE;
                }    
                break;
            case CIRCLE_AREA:
                try{
                    resultText = calculateAreaOfCircle(values[0]);
                }catch(Exception e){
                    resultText = NUMBER_FORMAT_MESSAGE;
                }  
                break;
            case RIGHT_TRIANGLE_HYPOTENUSE_LENGTH:
                try{
                    resultText = calculateLengthOfHypotenuseOfRightTriangle(
                            values[0],values[1]);
                }catch(Exception e){
                    resultText = NUMBER_FORMAT_MESSAGE;
                }  
                break;
            default:
                break;
        }
        return resultText;
    }
    /**
     * Input two Strings representing length and width measurements; Returns 
     * calculated area as String.
     * @param length of rectangle
     * @param width of rectangle
     * @return the calculated area
     */
    public final String calculateAreaOfRectangle(String length, String width)
    throws NumberFormatException,IllegalArgumentException{
        if(Double.parseDouble(length) < MIN_INPUT || 
                Double.parseDouble(width) < MIN_INPUT || 
                width.isEmpty() || width == null || length.isEmpty() || 
                length == null){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        return Double.toString(Double.parseDouble(length) *
                Double.parseDouble(width));
    }
    /**
     * Input a String representing a radius for a circle; Returns calculated 
     * area as String
     * @param radius of circle
     * @return the calculated area
     */
    public final String calculateAreaOfCircle(String radius) throws 
            NumberFormatException,IllegalArgumentException{
        if(Double.parseDouble(radius) < MIN_INPUT || radius.isEmpty() || 
                radius == null){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        return Double.toString(Math.PI * (Math.pow(Double.parseDouble(radius), 
                2)));
    }
    /**
     * Input Strings representing the sides of a right triangle, besides the
     * hypotenuse; Returns calculated hypotenuse length as a String.
     * @param sideA side a of right triangle
     * @param sideB side b of right triangle
     * @return the calculated hypotenuse length
     */
    public final String calculateLengthOfHypotenuseOfRightTriangle(String sideA,
            String sideB) throws NumberFormatException,IllegalArgumentException{
         if(Double.parseDouble(sideA) < MIN_INPUT || 
                Double.parseDouble(sideB) < MIN_INPUT || 
                sideA.isEmpty() || sideA == null || sideB.isEmpty() || 
                sideB == null){
            throw new IllegalArgumentException(ERROR_INVALID_INPUT);
        }
        return Double.toString(Math.sqrt(
                Math.pow(Double.parseDouble(sideA), 2) +
                Math.pow(Double.parseDouble(sideB), 2)));
    }
}