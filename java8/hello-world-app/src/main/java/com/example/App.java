package com.example;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
	// Set the port (default is 4567)
        port(8080);

        // Define a route
        get("/", (req, res) -> "<h2>Hello World!</h2>");        
        
        get("/hello", (req, res) -> "Hello World from Java 8 Web App!");

        System.out.println("Server started at http://localhost:8080/hello");
    }
}
