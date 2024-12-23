package org.howard.edu.lsp.finalexam.question3;

public class ShapeRenderer {
    private final ShapeFactory shapeFactory = ShapeFactory.getInstance();

    public void renderShape(String shapeType) {
        Shape shape = shapeFactory.createShape(shapeType);
        if (shape != null) {
            shape.draw();
        } else {
            System.out.println("Unknown shape type: " + shapeType);
        }
    }

    public static void main(String[] args) {
        ShapeRenderer renderer = new ShapeRenderer();
        renderer.renderShape("circle");
        renderer.renderShape("rectangle");
        renderer.renderShape("triangle");
        renderer.renderShape("hexagon");
    }
}
