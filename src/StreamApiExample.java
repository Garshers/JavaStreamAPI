import java.util.*;
import java.util.stream.*;

// https://justjoin.it/blog/zastosowanie-stream-api-z-java-8-przyklady

public class StreamApiExample {
    public static void main(String[] args) {
        
        System.out.println("\n---------------------------- Example 1 ----------------------------");
        // Create a list of integers
        List<Integer> numbers = Arrays.asList(6, 7, 1, 2, 3, 3, 3, 8, 9, 1, 4, 5,  10, 10);

        // Filtering and mapping using Stream API
        // Filter the distinct, even numbers. Sort and then multiply them by 2
        List<Integer> modifiedNumbers = numbers.stream()           // Create a stream from the list
                .filter(e -> e % 2 == 0)                           // Filter even numbers
                .distinct()                                        // Remove duplicates
                .sorted()                                          // Sort given list
                .map(e -> e * 2)                                   // Multiply each even number by 2
                .collect(Collectors.toList());                     // Collect the result back into a list
        
      
        // Filtering and mapping using for loop, and set/list methods/properties
        List<Integer> modifiedNumbersLoop = new ArrayList<>();      // Create a list to store the final results
        Set<Integer> uniqueNumbers = new HashSet<>();               // Use a HashSet to automatically remove duplicates
        for (Integer i : numbers) {                                 // Iterate over each number
            if (i % 2 == 0) {                                       // Filter even numbers
                uniqueNumbers.add(i * 2);                           // Multiply the even number by 2 and add it to the HashSet (duplicates will be ignored)
            }
        }
        modifiedNumbersLoop.addAll(uniqueNumbers);                  // Add all unique numbers from the HashSet to the ArrayList
        Collections.sort(modifiedNumbersLoop);                      // Sort the list in ascending order

        // Printing the unoptimized list
        System.out.println("unoptimized list: " + numbers);           
        // Printing the modified lists
        System.out.println("Modified list(Stream): " + modifiedNumbers);
        System.out.println("Modified list(Loop): " + modifiedNumbersLoop);
        


        System.out.println("\n---------------------------- Example 2 ----------------------------");
        // Using reduce() for aggregation (Sum of modified numbers)
        int sum = modifiedNumbers.stream()                        // Create a stream from the modified list
                .reduce(0, (a, b) -> a + b);             // Perform a reduction to calculate the sum
        

        // Using for loop for aggregation
        int sumLoop = 0;
        for (Integer i : modifiedNumbersLoop) {                   // Iterate over each number in the list
            sumLoop += i;                                         // Add this number to the list
        }

        // Print the sum of the numbers
        System.out.println("Sum of modified numbers(Stream): " + sum);
        System.out.println("Sum of modified numbers(Loop): " + sumLoop);
        

        System.out.println("\n---------------------------- Example 3 ----------------------------");
        // Using map() with a custom object - Creating a list of Person objects
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        
        // Using map() to extract the names of people into a list of strings
        List<String> names = people.stream()                      // Create a stream from the list of people
                .map(Person::getName)                             // Extract the name from each Person object
                .collect(Collectors.toList());                    // Collect the names into a list
        
        // Print the names
        System.out.println("List of Names: " + names);


        System.out.println("\n---------------------------- Example 4 ----------------------------");
        List<List<Integer>> gredeList = Arrays.asList(
        Arrays.asList(3, 2, 3),
        Arrays.asList(4, 5),
        Arrays.asList(1, 1, 4)
        );

        // Using flatMap() to flatten the stream of lists into a single stream
        List<Integer> flattenedGradeList = gredeList.stream()
                .flatMap(Collection::stream)                      // Flatten the stream of lists
                .sorted()                                         // Sort given flattened list
                .collect(Collectors.toList());                    // Collect the names into a list

        System.out.println("Flattened List: " + flattenedGradeList);


        System.out.println("\n---------------------------- Example 5 ----------------------------");
        List<String> names2 = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // Using forEach() to print each name in the list
        names2.stream()  
                .forEach(name2 -> System.out.println("Hello, " + name2 + "!"));


        System.out.println("\n---------------------------- Example 6 ----------------------------");
        List<Integer> numbersForMatching = Arrays.asList(1, 2, 3, 4, 5);

        // Using anyMatch() to check if any number is greater than 4
        boolean anyMatch = numbersForMatching.stream()
                .anyMatch(n -> n > 4);
        
        // Using allMatch() to check if all numbers are even
        boolean allEven = numbersForMatching.stream()
                .allMatch(n -> n % 2 == 0);
        
        // Using noneMatch() to check if no number is negative
        boolean Negative = numbersForMatching.stream()
                .noneMatch(n -> n >= 0);
        
        System.out.println("Any number greater than 4? " + anyMatch);
        System.out.println("Are all numbers even? " + allEven);
        System.out.println("Are all numbers negative? " + Negative);

        System.out.println("\n---------------------------- Example 7 ----------------------------");

        comparisonFunc();
    }

    // A simple Person class to demonstrate mapping with Stream API
    static private class Person {
        String name;
        int age;

        // Constructor
        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter for name - ENCAPSULATION
        public String getName() {
            return name;
        }

        // Getter for age - ENCAPSULATION
        public int getAge() {
            return age;
        }
    }
 
    // Comparison function that runs multiple iterations and calculates average time
    public static void comparisonFunc() {
        // Number of random numbers to generate
        int numOfRandomNumbers = 10000;
        
        // Number of iterations to run the comparison
        int iterations = 100;

        // Variables to accumulate total times
        long totalUnoptimizedTime = 0;
        long totalOptimizedTime = 0;
        long totalForLoopTime = 0;

        // Run the comparison multiple times and accumulate total times
        for (int i = 0; i < iterations; i++) {
            List<Integer> randomNumbers = generateRandomNumbers(numOfRandomNumbers);

            // Measure time for the unoptimized pipeline
            long startTimeUnoptimized = System.nanoTime();
            List<Integer> unoptimizedResult = unoptimizedPipeline(randomNumbers);
            long endTimeUnoptimized = System.nanoTime();
            long timeUnoptimized = endTimeUnoptimized - startTimeUnoptimized;
            totalUnoptimizedTime += timeUnoptimized;

            // Measure time for the optimized pipeline
            long startTimeOptimized = System.nanoTime();
            List<Integer> optimizedResult = optimizedPipeline(randomNumbers);
            long endTimeOptimized = System.nanoTime();
            long timeOptimized = endTimeOptimized - startTimeOptimized;
            totalOptimizedTime += timeOptimized;

            // Measure time for the for-loop method
            long startTimeForLoop = System.nanoTime();
            List<Integer> forLoopResult = forLoopList(randomNumbers);
            long endTimeForLoop = System.nanoTime();
            long timeForLoop = endTimeForLoop - startTimeForLoop;
            totalForLoopTime += timeForLoop;
        }

        // Calculate average time for both pipelines
        long avgUnoptimizedTime = totalUnoptimizedTime / iterations;
        long avgOptimizedTime = totalOptimizedTime / iterations;
        long avgForLoopTime = totalForLoopTime / iterations; // Fix: Corrected the average calculation for the for loop

        // Print out the average times
        System.out.println("Average time taken for unoptimized pipeline: " + avgUnoptimizedTime + " nanoseconds");
        System.out.println("Average time taken for optimized pipeline: " + avgOptimizedTime + " nanoseconds");
        System.out.println("Average time taken for for loop operations: " + avgForLoopTime + " nanoseconds");

        // Calculate the time difference between unoptimized and optimized
        long timeDifferenceUnoptOpt = avgUnoptimizedTime - avgOptimizedTime;
        long timeDifferenceForloopOpt = avgForLoopTime - avgOptimizedTime;
        System.out.println("Average time difference (unoptimized - optimized): " + timeDifferenceUnoptOpt + " nanoseconds - " + (timeDifferenceUnoptOpt*100/avgOptimizedTime) + "%");
        System.out.println("Average time difference (for loop - optimized): " + timeDifferenceForloopOpt + " nanoseconds - " + (timeDifferenceForloopOpt*100/avgOptimizedTime) + "%");
    }

    // Function to generate a list of random numbers
    public static List<Integer> generateRandomNumbers(int count) {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(1000)); // Random number between 0 and 999
        }
        return numbers;
    }
    
    // Unoptimized pipeline (with operations in the unoptimized order)
    public static List<Integer> unoptimizedPipeline(List<Integer> numbers) {
        return numbers.stream()
                .map(e -> e * 2)                                   // Multiply each even number by 2
                .sorted()                                          // Sort the numbers
                .distinct()                                        // Remove duplicates
                .filter(e -> e % 2 == 0)                           // Filter even numbers
                .collect(Collectors.toList());
    }
    
    // Optimized pipeline (with operations reordered for better performance)
    public static List<Integer> optimizedPipeline(List<Integer> numbers) {
        return numbers.stream()
                .filter(e -> e % 2 == 0)                           // Filter even numbers first
                .distinct()                                        // Remove duplicates after filtering
                .map(e -> e * 2)                                   // Multiply each even number by 2
                .sorted()                                          // Sort the modified numbers
                .collect(Collectors.toList());
    }

    public static List<Integer> forLoopList(List<Integer> numbers) {
        List<Integer> finalNumbers = new ArrayList<>();                  // Create a list to store the final results
        Set<Integer> uniqueNumbers = new HashSet<>();               // Use a HashSet to automatically remove duplicates

        for (Integer i : numbers) {                            // Iterate over each number from the input list
            if (i % 2 == 0) {                                       // Filter even numbers
                uniqueNumbers.add(i * 2);                           // Multiply the even number by 2 and add it to the HashSet (duplicates will be ignored)
            }
        }

        finalNumbers.addAll(uniqueNumbers);                              // Add all unique numbers from the HashSet to the ArrayList
        Collections.sort(finalNumbers);                                  // Sort the list in ascending order
        return finalNumbers;                                             // Return the sorted list
    }
}