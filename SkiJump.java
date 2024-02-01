// Programmers: Amari Piper
// Course: CS 212
// Due Date: 2/1/2024
// Problem Statement: Calculate the distance traveled based on speed and determine how many points they’d receive if they went that distance.
// Data In: Hill type, jumper speed
// Data Out: Distance traveled, points earned
// Credits: N/A

// Import all necessary utilities
import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;
class SkiJump {
    public static void main(String[] args) {

        // Create necessary objects
        Scanner scan = new Scanner(System.in);
        DecimalFormat dist = new DecimalFormat("#.##");

        // Ask for user inputs (Slope type and speed in mph)
        System.out.println("The Ski Jump point calculator! Please enter the hill type you jumped from: ");
        String choice = scan.nextLine();
        while((!choice.equals("Normal")) && (!choice.equals("normal")) && (!choice.equals("Large")) && (!choice.equals("large"))){ // Error check for inputs other that normal or large
            System.out.println("Sorry, that wasn't a valid input. Please enter the hill type you jumped from: ");
            choice = scan.nextLine();
        }
        System.out.println("Now please enter your speed in mph:");
        int speed = scan.nextInt();

        // Initialize necessary variables for calculations
        double height;
        double ppm;
        double par;

        // If... else statement to change the values of variables in different slope types
        if((choice.equals("Normal")) || (choice.equals("normal"))){
            height = 46;
            ppm = 2;
            par = 90;
        }else{
            height = 70;
            ppm = 1.8;
            par = 120;
        }

        // Calculate the time in the air
        double timeInAir = Math.sqrt((2*height)/9.8);

        // Calculate the distance of the jumper
        double distance = speed * timeInAir;

        // Calculate total points earned by jumper
        int points = (int) (60 + (distance - par)*ppm);

        // Output the jumper's distance and points earned
        System.out.println("You went " + dist.format(distance) + " meters and got " + points + " points.");

        // If... else statement for final result of jump (above par, average or below par)
        if (points >= 61){
            System.out.println("Great job doing better than par!");
        } else if (points < 10){
            System.out.println("What happened??");
        } else { // If points are in between 10 and 60
            System.out.println("Sorry you didn’t go very far");
        }
    }
}
