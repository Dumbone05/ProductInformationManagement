import java.util.ArrayList;

public class CategoryManager {
    private ArrayList<Category> categories;

    public CategoryManager() {
        categories = new ArrayList<>();
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategory(String categoryName) {
        categories.removeIf(category -> category.getName().equals(categoryName));
    }

    public void updateCategory(String oldName, String newName) {
        for (Category category : categories) {
            if (category.getName().equals(oldName)) {
                categories.remove(category);
                categories.add(new Category(newName));
                break;
            }
        }
    }

    public void displayCategories() {
        for (Category category : categories) {
            System.out.println(category);
        }
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
}