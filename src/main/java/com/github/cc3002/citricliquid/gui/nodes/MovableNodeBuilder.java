package com.github.cc3002.citricliquid.gui.nodes;

import javafx.scene.Scene;

import java.io.FileNotFoundException;

/**
 * This class represents an object that can be moved inside the game.
 *
 * @author Ignacio Slater Muñoz
 *
 * This class was replicated from the example from the course domentation.
 */
public class MovableNodeBuilder {
  private final Scene scene;
  private int hPos;
  private int vPos;
  private int height;
  private int width;
  private String imagePath;

  /**
   * Creates a new movable component from an image.
   */
  public MovableNodeBuilder(Scene scene) {
    this.scene = scene;
  }

  /**
   * Changes the positions of the Node.
   */
  public MovableNodeBuilder setPosition(int hPos, int vPos) {
    this.hPos = hPos;
    this.vPos = vPos;
    return this;
  }

  /**
   * Changes the size of the Node.
   */
  public MovableNodeBuilder setSize(int height, int width) {
    this.height = height;
    this.width = width;
    return this;
  }

  /**
   * Sets the image path.
   */
  public MovableNodeBuilder setImagePath(String path) {
    this.imagePath = path;
    return this;
  }

  /**
   * Builds a new Movable Node.
   */
  public MovableNode build() throws FileNotFoundException {
    return new MovableNode(scene, hPos, vPos, height, width, imagePath);
  }
}
