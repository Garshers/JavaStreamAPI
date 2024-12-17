# Stream API Example in Java

This project demonstrates various examples of using Java's Stream API to perform operations on collections such as filtering, mapping, sorting, and aggregating data. Additionally, it compares the performance of stream-based solutions with traditional loop-based solutions. The goal is to show how Java's Stream API can be used effectively to manipulate collections and also compare its performance with other methods.

## Project Overview

The project contains several examples of how to use Java Stream API for common data manipulation tasks, as well as a performance comparison between stream-based approaches and traditional `for-loop` approaches. Each example demonstrates a specific use case or feature of the Stream API, such as:

1. **Filtering, Sorting, and Mapping**: The first example demonstrates how to use Stream API methods to filter even numbers from a list, remove duplicates, sort the numbers, and then perform a transformation (multiplying the values by 2). The same operations are also performed using a traditional for-loop, allowing for a side-by-side comparison of both methods.

2. **Aggregation**: The second example compares how to aggregate data using the `reduce()` method in the Stream API versus using a traditional for-loop to sum the values in a list of numbers.

3. **Mapping Custom Objects**: The third example demonstrates how to use the `map()` method with a custom object (`Person`) to transform data from one format (object fields) to another (a list of strings).

4. **Flattening a List of Lists**: The fourth example shows how to flatten a list of lists into a single list using the `flatMap()` method. This is often useful when working with nested collections.

5. **Iterating with `forEach()`**: The fifth example demonstrates the `forEach()` method for iterating over elements of a list and performing an action on each element.

6. **Matching Operations**: The sixth example uses the `anyMatch()`, `allMatch()`, and `noneMatch()` methods to check conditions on elements in a stream, such as checking if any number is greater than 4, if all numbers are even, or if no number is negative.

7. **Performance Comparison**: The final example compares the performance of three different methods to process a list of numbers:
   - **Stream API (Optimized)**: The optimized pipeline that filters, transforms, and sorts the data using Stream API.
   - **Stream API (Unoptimized)**: An unoptimized pipeline that applies operations in a less efficient order.
   - **For-loop**: A traditional for-loop approach that performs the same operations.

The program measures and compares the execution times of each approach over multiple iterations, providing a performance comparison to help you understand the trade-offs between the methods.

## Key Concepts

- **Stream API**: Introduced in Java 8, the Stream API allows you to process collections in a functional programming style. It supports operations such as filtering, mapping, sorting, and reducing data in a declarative and fluent manner.
  
- **Performance Considerations**: The project emphasizes how different ways of chaining operations can affect performance. For example, sorting and filtering operations in a stream can be reordered to improve efficiency.

- **Custom Object Mapping**: The project also demonstrates how to use `map()` to transform a stream of custom objects into a stream of specific data (e.g., extracting names from a list of `Person` objects).

- **Aggregation with `reduce()`**: The `reduce()` method is used to aggregate a stream of values (e.g., summing numbers). This is compared with a traditional for-loop approach to show the differences in style and performance.

- **Flat Mapping**: The `flatMap()` method is useful for handling collections of collections, allowing you to flatten nested data structures into a single stream of values.

- **Matching Operations**: The `anyMatch()`, `allMatch()`, and `noneMatch()` methods allow you to check if any, all, or none of the elements in a stream meet a specific condition. These methods provide a concise and functional way to perform such checks.

## Performance Comparison

The performance comparison is conducted by measuring the execution time of three different approaches:
1. **Stream API (Optimized)**: Filters even numbers first, removes duplicates, then multiplies the numbers by 2, and finally sorts them.
2. **Stream API (Unoptimized)**: The same operations are applied, but in a less optimal order.
3. **For-loop**: A traditional for-loop implementation that uses a `HashSet` to remove duplicates, then multiplies the numbers by 2, and finally sorts the list.

The program runs multiple iterations and calculates the average execution time for each method, providing insights into the performance characteristics of each approach. The results are displayed in nanoseconds, with the time differences shown in both absolute and percentage terms.

## Running the Code

1. Clone the repository or copy the `StreamApiExample` class into your local Java project.
2. Ensure you have Java 8 or above installed.
3. Run the `StreamApiExample.main()` method to see the examples in action.
4. The program will output the results of each example, including the performance comparison.

## Conclusion

This project demonstrates the power and flexibility of Java's Stream API for performing complex data manipulation tasks in a declarative and efficient manner. The performance comparison provides valuable insights into how different approaches can impact execution time, helping you make informed decisions about which method to use in various scenarios.
"# JavaStreamAPI" 
