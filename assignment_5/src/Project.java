import java.util.ArrayList;

public class Project extends Item {
    private ArrayList<Item> items = new ArrayList<>();
    private Project parent;

    public Project(String title) {
        super(title);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void setParent(Project parent) {
        this.parent = parent;
    }

    public Project getParent() {
        return parent;
    }

    public void displayIncompleteItems(int indent) {
        System.out.println(" ".repeat(indent) + "+ Project: " + title);
        for (Item item : items) {
            if (item instanceof Task && !((Task) item).isDeleted()) {
                if (!((Task) item).isComplete()) {
                    item.display(indent + 2);
                }
            } else if (item instanceof Project) {
                ((Project) item).displayIncompleteItems(indent + 2);
            }
        }
    }

    public void displayCompletedItems(int indent) {
        System.out.println(" ".repeat(indent) + "+ Project: " + title);
        for (Item item : items) {
            if (item instanceof Task && !((Task) item).isDeleted()) {
                if (((Task) item).isComplete()) {
                    item.display(indent + 2);
                }
            } else if (item instanceof Project) {
                ((Project) item).displayCompletedItems(indent + 2);
            }
        }
    }

    public Item findItemByTitle(String title) {
        for (Item item : items) {
            if (item.title.equalsIgnoreCase(title)) {
                return item;
            }
            if (item instanceof Project) {
                Item found = ((Project) item).findItemByTitle(title);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    @Override
    public void display(int indent) {
        System.out.println(" ".repeat(indent) + "+ Project: " + title);
        for (Item item : items) {
            item.display(indent + 2);
        }
    }

    @Override
    public void markAsComplete() {
        for (Item item : items) {
            item.markAsComplete();
        }
    }

    @Override
    public void deleteForever() {
        for (Item item : items) {
            item.deleteForever();
        }
    }
}
