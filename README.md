# Image Processing System in Java

## Overview
This project implements a modular image-processing system in Java, supporting RGB and grayscale formats and applying a variety of pixel-level operations. It includes functionality for smoothing, cropping, mirroring, pixel-wise addition between images, and additional transformations. The project also provides an I/O utility for reading and writing image files and a comprehensive JUnit test suite validating algorithm correctness and expected output. The architecture separates data structures, processing logic, and file handling, demonstrating advanced matrix manipulation and object-oriented design.

## Project Structure
- `RGBImage.java`  
  Representation of an RGB image using a three-dimensional array (`int[][][]`) and implementation of pixel-level operations such as `smooth`, `mirror`, `crop`, and `addFrom`.

- `GrayImage.java`  
  Grayscale image representation and conversions between RGB and gray.

- `MyImageIO.java`  
  Handles file input/output, enabling reading images from disk and writing processed images back to `.jpg` files.

- `ContainerFunctions.java` / `functions.java`  
  Utility functions for data manipulation and supporting operations across different image containers.

- `Frame.java`, `FrameContainer.java`  
  Image frame wrapper and container management for organizing and combining image elements.

- `RGBImageTest.java`, `FrameContainerTest.java`  
  A complete JUnit test suite verifying correctness of processing methods and functional reliability.

- Example image files (`0.jpg` – `7.jpg`)  
  Used for visual comparison and automated testing of processing output.

## Key Capabilities
- Pixel-level manipulation using multidimensional arrays
- Efficient matrix-based image transformations
- Conversion between color spaces (RGB ↔ Gray)
- File-system integration using custom I/O handlers
- Full test coverage using JUnit

## Compilation & Execution
To compile and run the project from the terminal:

```bash
javac *.java
java Main
