<%-- 
    Document   : index
    Created on : Sep 14, 2017, 4:12:54 PM
    Author     : vekivulic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calculators</title>
        <link  rel="stylesheet" type="text/css" href="calculatorStyleSheet.css">
    </head>
    <div id="wrapper">
        <body>
            <h1>
                Calculators
            </h1>
            <br>
            <h2>
                Calculator to Calculate the Area of a Rectangle
            </h2>
            <br>
            <img src="http://spiff.rit.edu/classes/phys311/workshops/w1b/rectangle.gif" alt="Rectangle" height="173" width="286">
            <br>
            <br>
            <p>
                Please enter a length and width to calculate area.
            </p>
            <form id="rectangleArea" name="rectangleArea" method="POST" action="calc?calcType=rectArea">
                <label for="length">
                    Length:
                </label>
                <input type="text" id="length" name="length" value="">
                <br>
                <br>
                <label for="width">
                    Width:&nbsp;&nbsp;
                </label>
                <input type="text" id="width" name="width" value="">
                <br>
                <br>
                <input type="submit" name="submit" value="Submit">  
                <br>
                <p>
                    Answer:
                    <br>
                    ${msgAreaRect}
                </p>
            </form>        
        <br>
        <br>
        <br>
            <h2>
              Calculator to Calculate the Area of a Circle
            </h2>
            <br>
            <br>
            <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Circle_Area.svg/220px-Circle_Area.svg.png" alt="Circle" height="220" width="220">
            <br>
            <br>
            <p>
                Please Enter a Radius for a Circle
            </p>
            <form id="circleArea" name="circleArea" method="POST" action="calc?calcType=circleArea">
                <label for="length">
                    Radius:
                </label>
                <input type="text" id="radius" name="radius" value="">
                <br>
                <br>
                <input type="submit" name="submit" value="Submit">   
                <br>
                <p>
                    Answer:
                    <br>
                    ${msgAreaCircle}
                </p>
            </form>    
        <br>
        <br>
        <br>
            <h2>
              Calculator to Calculate the Hypotenuse side of a Right Triangle
            </h2>
            <br>
            <img src="https://mathspace-production-media.mathspace.co/media/upload/images/001_Chapter_Entries/Trigonometry/hypotenuse.gif" alt="RightTriangle" height="173" width="286">
            <br>
            <br>
            <p>
                Please enter the lengths of side a and b
            </p>
            <form id="rightTriangleHypLength" name="rightTriangleHypLength" method="POST" action="calc?calcType=rightTriHypLength">
                <label for="length">
                    Side a:
                </label>
                <input type="text" id="sideA" name="sideA" value="">
                <br>
                <br>
                <label for="width">
                    Side b:
                </label>
                <input type="text" id="sideB" name="sideB" value="">
                <br>
                <br>
                <input type="submit" name="submit" value="Submit">  
                <br>
                <p>
                    Answer:
                    <br>
                    ${msgHypRightTri}
                </p>
            </form>    
        </body>
        <br>
        <br>
    </div>
   
</html>
