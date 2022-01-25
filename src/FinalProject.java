import java.util.Scanner;

public class FinalProject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        KD_Tree kd_tree = new KD_Tree(2);
        System.out.println("enter command: ");
        String command = scanner.nextLine();
        Trie banks = new Trie();
        Trie neighborhoods = new Trie();
        while (!command.equals("end")) {
            switch (command) {
                case "addN" : {
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
                    Neighborhood neighborhood = new Neighborhood(first, second, third, fourth, name);
                    neighborhoods.insertNeighborhood(name , neighborhood);
                    System.out.println("neighborhood successfully added!");
                }
                break;

                case "addB" : {
                    System.out.println("enter bank name: ");
                    String name = scanner.nextLine();
                    System.out.println("enter coordinates of bank: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    Bank bank = new Bank(coordinates, name);
                    banks.insertBank(name , bank);
                    Node node = new Node(true);
                    node.setBank(bank);
                    kd_tree.insert(kd_tree.getRoot(), node, 0);
                }
                break;
                case "addBr" : {
                    System.out.println("enter bank name: ");
                    String bankName = scanner.nextLine();
                    Bank bank = banks.search(bankName).getBank();
                    System.out.println("enter branch name: ");
                    String branchName = scanner.nextLine();
                    System.out.println("enter branch coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    BankBranch bankBranch = new BankBranch(coordinates, branchName, bankName);
                    bank.addBranch(bankBranch);
                    Node node = new Node(false);
                    node.setBankBranch(bankBranch);
                    kd_tree.insert(kd_tree.getRoot(), node, 0);
                }
                break;

                case "availB" : {
                    System.out.println("enter coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    System.out.println("enter range: ");
                    double r = scanner.nextDouble();
                    kd_tree.inRangeBanks(kd_tree.getRoot(), coordinates, r);
                }
                break;

                case "delBr" : {

                }
                break;

                case "listB" : {

                }
                break;

                case "listBrs" : {
                    System.out.println("enter bank name: ");
                    String bankName = scanner.nextLine();
                    Bank bank = banks.search(bankName).getBank();
                    for (int i = 0; i < bank.getBranchCtr(); i++) {
                        bank.getBranches()[i].printInfo();
                    }
                }
                break;

                case "nearB" : {
                    System.out.println("enter coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    kd_tree.nearestP(kd_tree.getRoot() , coordinates , 0);
                }
                break;

                case "nearBr" : {
                }
                break;

                default:{
                    System.out.println("wrong command!!Try again.");
                }
            }
            System.out.println("enter command: ");
            command = scanner.nextLine();
            command = scanner.nextLine();
        }
    }
}