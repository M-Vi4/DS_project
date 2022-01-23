import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KD_Tree kd_tree = new KD_Tree(2);
        String command = scanner.nextLine();
        Neighborhood[] neighborhoods = new Neighborhood[100];
        int nCtr = 0;
        while (!command.equals("end")) {
            // add a neighborhood
            if (command.equals("addN")) {
                System.out.println("enter neighborhood name: ");
                String name = scanner.nextLine();
                System.out.println("enter coordinates of neighbor(first point): ");
                double[] first = new double[2];
                first[0] = scanner.nextDouble();
                first[1] = scanner.nextDouble();
                System.out.println("enter coordinates of neighbor(second point): ");
                double[] second = new double[2];
                second[0] = scanner.nextDouble();
                second[1] = scanner.nextDouble();
                System.out.println("enter coordinates of neighbor(third point): ");
                double[] third = new double[2];
                third[0] = scanner.nextDouble();
                third[1] = scanner.nextDouble();
                System.out.println("enter coordinates of neighbor(fourth point): ");
                double[] fourth = new double[2];
                fourth[0] = scanner.nextDouble();
                fourth[1] = scanner.nextDouble();
                neighborhoods[nCtr] = new Neighborhood(first , second , third , fourth , name);
                System.out.println("neighborhood successfully added!");
            }
            // add a bank
            else if (command.equals("addB")){
                System.out.println("enter bank name: ");
                String name = scanner.nextLine();
                System.out.println("enter coordinates of bank: ");
                double[] coordinates = new double[2];
                coordinates[0] = scanner.nextDouble();
                coordinates[1] = scanner.nextDouble();
                Bank bank = new Bank(coordinates , name);
                Node node = new Node(true);
                node.setBank(bank);
                kd_tree.insert(kd_tree.getRoot() , node , 0);
            }
            // add a bank branch
            else if (command.equals("addBr")) {
                System.out.println("enter bank name: ");
                String bankName = scanner.nextLine();
                System.out.println("enter branch name: ");
                String branchName = scanner.nextLine();
                System.out.println("enter branch coordinates: ");
                double[] coordinates = new double[2];
                coordinates[0] = scanner.nextDouble();
                coordinates[1] = scanner.nextDouble();
                BankBranch bankBranch = new BankBranch(coordinates , branchName , bankName);
                Node node = new Node(false);
                node.setBankBranch(bankBranch);
                kd_tree.insert(kd_tree.getRoot() , node , 0);
            }
            // find banks in a range
            else if (command.equals("availB")){
                System.out.println("enter coordinates: ");
                double[] coordinates = new double[2];
                coordinates[0] = scanner.nextDouble();
                coordinates[1] = scanner.nextDouble();
                System.out.println("enter range: ");
                double r = scanner.nextDouble();
                kd_tree.inRangeBanks(kd_tree.getRoot() , coordinates , r);
            }
        }
    }
}