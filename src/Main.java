import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        CategoryManager categoryManager = new CategoryManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Quản lý sản phẩm");
            System.out.println("2. Quản lý danh mục");
            System.out.println("3. Thoát");
            System.out.print("Chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                case 1:
                    manageProducts(scanner, productManager);
                    break;
                case 2:
                    manageCategories(scanner, categoryManager);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Quản lý sản phẩm
    private static void manageProducts(Scanner scanner, ProductManager productManager) {
        int productChoice;
        do {
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Xóa sản phẩm");
            System.out.println("3. Hiển thị sản phẩm");
            System.out.println("4. Quay lại");
            System.out.print("Chọn: ");
            productChoice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (productChoice) {
                case 1:
                    addProduct(scanner, productManager);
                    break;
                case 2:
                    removeProduct(scanner, productManager);
                    break;
                case 3:
                    productManager.displayProducts();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (productChoice != 4);
    }

    private static void addProduct(Scanner scanner, ProductManager productManager) {
        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        double price = scanner.nextDouble();
        System.out.print("Nhập số lượng sản phẩm: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Đọc dòng mới
        System.out.print("Nhập tên danh mục sản phẩm: ");
        String categoryName = scanner.nextLine();
        Category category = new Category(categoryName);
    }

    private static void removeProduct(Scanner scanner, ProductManager productManager) {
        System.out.print("Nhập tên sản phẩm để xóa: ");
        String productName = scanner.nextLine();
        productManager.removeProduct(productName);
    }

    // Quản lý danh mục
    private static void manageCategories(Scanner scanner, CategoryManager categoryManager) {
        int categoryChoice;
        do {
            System.out.println("1. Thêm danh mục");
            System.out.println("2. Sửa danh mục");
            System.out.println("3. Xóa danh mục");
            System.out.println("4. Hiển thị danh mục");
            System.out.println("5. Quay lại");
            System.out.print("Chọn: ");
            categoryChoice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (categoryChoice) {
                case 1:
                    addCategory(scanner, categoryManager);
                    break;
                case 2:
                    updateCategory(scanner, categoryManager);
                    break;
                case 3:
                    removeCategory(scanner, categoryManager);
                    break;
                case 4:
                    categoryManager.displayCategories();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (categoryChoice != 5);
    }

    private static void addCategory(Scanner scanner, CategoryManager categoryManager) {
        System.out.print("Nhập tên danh mục: ");
        String categoryName = scanner.nextLine();
        categoryManager.addCategory(new Category(categoryName));
    }

    private static void updateCategory(Scanner scanner, CategoryManager categoryManager) {
        System.out.print("Nhập tên danh mục cũ: ");
        String oldName = scanner.nextLine();
        System.out.print("Nhập tên danh mục mới: ");
        String newName = scanner.nextLine();
        categoryManager.updateCategory(oldName, newName);
    }

    private static void removeCategory(Scanner scanner, CategoryManager categoryManager) {
        System.out.print("Nhập tên danh mục để xóa: ");
        String categoryToRemove = scanner.nextLine();
        categoryManager.removeCategory(categoryToRemove);
    }
}