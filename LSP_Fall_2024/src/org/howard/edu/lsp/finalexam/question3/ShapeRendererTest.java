package org.howard.edu.lsp.finalexam.question3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ShapeRendererTest {
    private final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    @Test
    void testCircleCreation() {
        Shape circle = shapeFactory.createShape("circle");
        assertNotNull(circle, "Circle should not be null");
        assertTrue(circle instanceof Circle, "Shape should be an instance of Circle");
    }

    @Test
    void testRectangleCreation() {
        Shape rectangle = shapeFactory.createShape("rectangle");
        assertNotNull(rectangle, "Rectangle should not be null");
        assertTrue(rectangle instanceof Rectangle, "Shape should be an instance of Rectangle");
    }

    @Test
    void testTriangleCreation() {
        Shape triangle = shapeFactory.createShape("triangle");
        assertNotNull(triangle, "Triangle should not be null");
        assertTrue(triangle instanceof Triangle, "Shape should be an instance of Triangle");
    }

    @Test
    void testUnknownShapeCreation() {
        Shape unknown = shapeFactory.createShape("hexagon");
        assertNull(unknown, "Unknown shape should return null");
    }

    @Test
    void testSingletonFactoryInstance() {
        ShapeFactory factory1 = ShapeFactory.getInstance();
        ShapeFactory factory2 = ShapeFactory.getInstance();
        assertSame(factory1, factory2, "Both instances should be the same (singleton)");
    }
}
