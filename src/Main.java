public class Main {

    private static final int WORKERS_TO_HIRE = 20;

    public static void main(String[] args) {
        Company company = new Company();

        for (int i = 1; i <= WORKERS_TO_HIRE; i++) {
            company.addWorker(new Worker("John " + i, 1500 + i * 100, i * 25));
        }

        company.printWorkers();

        Worker worker = company.getWorker(0);
        worker.setBaseSalary(worker.getBaseSalary() + 200);
        System.out.println();
        System.out.println("Raise of 200 for " + worker.getName() + ", global total salary is " + company.getGlobalTotalSalary());

        worker.setBaseSalary(-1);
        System.out.println("The salary of " + worker.getName() + " is " + worker.getBaseSalary());
    }
}
