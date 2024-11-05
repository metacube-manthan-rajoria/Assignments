import Employees.Employee;

public class Payroll {
    static private final int[] TAX_SLAB = {
        300000,
        700000,
        1000000,
        1200000,
        1500000,
    };

    private Employee employee;
    private double taxable_income = 0;

    public Payroll(Employee employee){
        this.employee = employee;

        double compensation = this.employee.getCompensation();
        int currentTax = 0;

        if(compensation > TAX_SLAB[0] && compensation <= TAX_SLAB[1]){
            currentTax = 5;
        }else if(compensation > TAX_SLAB[1] && compensation <= TAX_SLAB[2]){
            currentTax = 10;
        }else if(compensation > TAX_SLAB[2] && compensation <= TAX_SLAB[3]){
            currentTax = 15;
        }else if(compensation > TAX_SLAB[3] && compensation <= TAX_SLAB[4]){
            currentTax = 20;
        }else if(compensation > TAX_SLAB[4]){
            currentTax = 30;
        }

        taxable_income = Double.parseDouble(String.format("%.2f", ((compensation * currentTax) / 100)/12));
    }

    public double getTaxableIncome(){
        return taxable_income;
    }

    public double getPayoutPerMonth(){
        double monthlyPayout = (employee.getCompensation()/12) - taxable_income;
        double formattedMonthlyPayout = Double.parseDouble(String.format("%.2f", monthlyPayout));
        return formattedMonthlyPayout;
    }

    @Override
    public String toString() {
        StringBuilder slipString = new StringBuilder();
        slipString.append("Payroll Slip for Employee : " + employee.getName());
        slipString.append(" (" + employee.getId() + ")\n");
        slipString.append("Salary\t: " + employee.getBasicSalary() + "\n");
        slipString.append("Bonus\t: " + employee.getBonus() + "\n");
        slipString.append("Total Compensation\t: " + employee.getCompensation() + "\n");
        slipString.append("Total Taxable Income\t: " + taxable_income + "\n");
        
        slipString.append("Final Monthly Payout\t: " + getPayoutPerMonth() + "\n");
        return slipString.toString();
    }

    public void printSlip(){
        System.out.println(this.toString());
    }
}
