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
                case "addN" -> {
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
                    neighborhoods.insertNeighborhood(name, neighborhood);
                    System.out.println("neighborhood successfully added!");
                }
                case "addB" -> {
                    System.out.println("enter bank name: ");
                    String name = scanner.nextLine();
                    System.out.println("enter coordinates of bank: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    Bank bank = new Bank(coordinates, name);
                    Node node = new Node(true);
                    node.setBank(bank);
                    kd_tree.isSame = false;
                    kd_tree.insert(node);
                    if (!kd_tree.isSame)
                        banks.insertBank(name, bank);
                }
                case "addBr" -> {
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
                    Node node = new Node(false);
                    node.setBankBranch(bankBranch);
                    kd_tree.isSame = false;
                    kd_tree.insert(node);
                    if (!kd_tree.isSame)
                        bank.addBranch(bankBranch);

                }
                case "availB" -> {
                    System.out.println("enter coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    System.out.println("enter range: ");
                    double r = scanner.nextDouble();
                    kd_tree.inRangeBanks(kd_tree.getRoot(), coordinates, r);
                }
                case "delBr" -> {
                    System.out.println("enter coordinate: ");
                    double[] coordinate = new double[2];
                    coordinate[0] = scanner.nextDouble();
                    coordinate[1] = scanner.nextDouble();
                    Node node = kd_tree.search(kd_tree.getRoot() , coordinate , 0);
                    if (node == null)
                        System.out.println("There is no bank here!!");
                    else if (node.isBank())
                        System.out.println("Can not delete a main bank!!");

                    else {
                        kd_tree.deleteNode(kd_tree.getRoot(), coordinate , 0);
                        Bank bank = banks.search(node.getBankBranch().getBaName()).getBank();
                        bank.getBranches().deleteNode(bank.getBranches().getRoot() , coordinate , 0);
                        System.out.println("branch deleted successfully!!");
                    }
                }
                case "listB" -> {

                }
                case "listBrs" -> {
                    System.out.println("enter bank name: ");
                    String bankName = scanner.nextLine();
                    Bank bank = banks.search(bankName).getBank();
                    bank.printBranchesInfo(bank.getBranches().getRoot());
                }
                case "nearB" -> {
                    System.out.println("enter coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    Node node = kd_tree.nearestBank(kd_tree.getRoot(), coordinates, 0);
                    if (node.isBank()){
                        System.out.println("nearest bank to your coordinates is '" + node.getBank().getName() +
                                            "' located in X = " + node.getBank().getCoordinates()[0] + "and Y = "
                                            + node.getBank().getCoordinates()[1]);
                    }
                    else if (!node.isBank()){
                        System.out.println("nearest bank to your coordinates is '" + node.getBankBranch().getBrName() +
                                           "' branch of '" + node.getBankBranch().getBaName() + "' bank located in X = " +
                                           node.getBank().getCoordinates()[0] + " and Y = " + node.getBank().getCoordinates()[1]);
                    }
                }
                case "nearBr" -> {
                    System.out.println("enter bank name: ");
                    String bankName = scanner.nextLine();
                    Bank bank = banks.search(bankName).getBank();
                    System.out.println("enter the coordinates: ");
                    double[] coordinates = new double[2];
                    coordinates[0] = scanner.nextDouble();
                    coordinates[1] = scanner.nextDouble();
                    Node node = bank.getBranches().nearestBank(bank.getBranches().getRoot() , coordinates , 0);
                    System.out.println("nearest branch of '" + node.getBankBranch().getBaName() + "' bank to your location is '" +
                                        node.getBankBranch().getBrName() + "' located in X = " + node.getBankBranch().getCoordinates()[0] +
                                        " and Y = " + node.getBankBranch().getCoordinates()[1]);
                }
                default -> System.out.println("wrong command!!Try again.");
            }
            System.out.println("enter command: ");
            command = scanner.nextLine();
            command = scanner.nextLine();
        }
    }
}