package org.designPatterns.Proxy;/*
Problem Statement:
You want to control access to a resource (such as a large image or a database) by using a proxy.
The proxy will handle requests to the real object, and you can implement additional logic,
such as caching or logging, without modifying the real object.

Solution:
We use the Proxy Design Pattern to control access to the `RealImage` object.
- The `Image` interface represents the common interface for all types of image handling.
- The `RealImage` class represents the actual image resource that is being accessed.
- The `ProxyImage` class acts as a proxy to the `RealImage` and controls access to it,
  such as lazy loading and logging.
*/

public class ProxyDesignPattern {

    // Image interface that both RealImage and ProxyImage implement
    public interface Image {
        void display();  // Display the image
    }

    // RealImage: Represents the actual image resource being accessed
    public static class RealImage implements Image {
        private String fileName; // The image file name

        public RealImage(String fileName) {
            this.fileName = fileName;
            loadImageFromDisk(); // Simulate loading the image from disk
        }

        // Simulate loading the image from the disk
        private void loadImageFromDisk() {
            System.out.println("Loading image: " + fileName);
        }

        @Override
        public void display() {
            // Display the image
            System.out.println("Displaying image: " + fileName);
        }
    }

    // ProxyImage: Controls access to the RealImage and adds extra logic
    public static class ProxyImage implements Image {
        private RealImage realImage; // The real image object
        private String fileName; // The image file name

        public ProxyImage(String fileName) {
            this.fileName = fileName; // Initialize with the image file name
        }

        @Override
        public void display() {
            // Check if the real image is already loaded
            if (realImage == null) {
                // If not loaded, create the real image and load it
                realImage = new RealImage(fileName);
            }
            // Log that the image is being displayed through the proxy
            System.out.println("Proxy: Displaying image through proxy.");
            realImage.display(); // Delegate the display operation to the real image
        }
    }

    // Client: Demonstrates how to use the Proxy to interact with images
    public static void main(String[] args) {
        // Create ProxyImage objects instead of directly interacting with RealImage
        Image image1 = new ProxyImage("image1.jpg"); // Proxy is created for image1
        Image image2 = new ProxyImage("image2.jpg");

        // Display the image (this will trigger loading via the proxy if not already loaded)
        image1.display();  // First time it loads the real image
        image1.display();  // Second time it uses the proxy (no need to load again)

        image2.display();  // First time it loads the real image for image2
    }
}
