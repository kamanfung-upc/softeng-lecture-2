public class Company {

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

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public int getFreePositions() {
        return workers.length - numberOfWorkers;
    }

    public Worker getWorker(int position) {
        if (position < 0 || position >= numberOfWorkers) {
            System.out.println("There is no worker in position " + position);
            return null;
        }
        return workers[position];
    }

    public double getGlobalTotalSalary() {
        double total = 0;
        for (int i = 0; i < numberOfWorkers; i++) {
            total += workers[i].getTotalSalary();
        }
        return total;
    }

    public void printWorkers() {
        System.out.println("The company has " + numberOfWorkers + " workers and " + getFreePositions() + " free positions");
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-16s %10s %12s %12s%n", "NAME", "SALARY", "COMPLEMENT", "TOTAL");
        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < numberOfWorkers; i++) {
            Worker worker = workers[i];
            System.out.printf("%-16s %10.2f %12.2f %12.2f%n",
                    worker.getName(),
                    worker.getBaseSalary(),
                    worker.getComplement(),
                    worker.getTotalSalary());
        }

        System.out.println("-----------------------------------------------------");
        System.out.printf("%-16s %36.2f%n", "GLOBAL TOTAL", getGlobalTotalSalary());
    }
}
