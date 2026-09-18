# Lecture 2 - Short Exercise: Salaries of a company

A Java program that stores the workers of a company (name, base salary and
complement), prints them and calculates the global total salary.

## Additional questions

### Is the design ready to easily accept changes in how to calculate the total salary?

Yes, because the calculation is encapsulated. It is written once, inside
`Worker`. Nobody else adds the two numbers: `Company` and `Main` only call
this method. So to take taxes into account we change this one method and
the whole program follows:

```java
public double getTotalSalary() {
    return (baseSalary + complement) * (1 - TAX_RATE);
}
```

### How to implement the case where I don't use all of the 100 "spaces"?

`Company` keeps the array of 100 positions and a counter with the number of
positions that are really used:

```java
private Worker[] workers = new Worker[100];
private int numberOfWorkers = 0;

public void addWorker(Worker worker) {
    if (numberOfWorkers == workers.length) {
        System.out.println("The company is full, cannot hire " + worker.getName());
        return;
    }
    workers[numberOfWorkers] = worker;
    numberOfWorkers++;
}
```

Every loop stops at `numberOfWorkers`, not at `workers.length`.
So a company with 20 workers prints 20 lines and adds 20 salaries, and the 80
empty positions are never used. If the loop went to `workers.length` it would
find `null` in position 21 and the program would crash with a
`NullPointerException`.

The counter is also private: only `addWorker()` can change it, so it can never
disagree with the content of the array.
