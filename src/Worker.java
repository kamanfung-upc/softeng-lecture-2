public class Worker {

    private String name;
    private double baseSalary;
    private double complement;

    public Worker(String name, double baseSalary, double complement) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.complement = complement;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            System.out.println("A base salary cannot be negative");
            return;
        }
        this.baseSalary = baseSalary;
    }

    public double getComplement() {
        return complement;
    }

    public void setComplement(double complement) {
        if (complement < 0) {
            System.out.println("A complement cannot be negative");
            return;
        }
        this.complement = complement;
    }

    public double getTotalSalary() {
        return baseSalary + complement;
    }
}
