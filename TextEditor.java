import java.util.Scanner;

class Node {
    char data;
    Node prev;
    Node next;

    Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class TextEditor {
    private Node head;
    private Node tail;

    public TextEditor() {
        head = null;
        tail = null;
    }

    public void append(char c) {
        Node newNode = new Node(c);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insert(int position, char c) {
        if (position < 0) {
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(c);
        if (position == 0) {
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {
            Node current = head;
            int index = 0;
            while (current != null && index < position - 1) {
                current = current.next;
                index++;
            }
            if (current == null) {
                System.out.println("Position out of bounds!");
                return;
            }
            newNode.next = current.next;
            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void delete(int position) {
        if (position < 0 || head == null) {
            System.out.println("Invalid position or empty text!");
            return;
        }

        if (position == 0) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
        } else {
            Node current = head;
            int index = 0;
            while (current != null && index < position) {
                current = current.next;
                index++;
            }

            if (current == null) {
                System.out.println("Position out of bounds!");
                return;
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            current = current.next;
        }
        System.out.println();
    }
}

  class TextEditorApp {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Text Editor (Doubly Linked List-based)");
        boolean running = true;

        while (running) {
            System.out.println("\nOptions:");
            System.out.println("1. Append Text");
            System.out.println("2. Insert Text");
            System.out.println("3. Delete Text");
            System.out.println("4. Display Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text to append: ");
                    String appendText = scanner.nextLine();
                    for (char c : appendText.toCharArray()) {
                        editor.append(c);
                    }
                    break;

                case 2:
                    System.out.print("Enter position to insert: ");
                    int position = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter character to insert: ");
                    char insertChar = scanner.nextLine().charAt(0);
                    editor.insert(position, insertChar);
                    break;

                case 3:
                    System.out.print("Enter position to delete: ");
                    int deletePos = scanner.nextInt();
                    editor.delete(deletePos);
                    break;

                case 4:
                    System.out.print("Current text: ");
                    editor.display();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting the text editor. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }

        scanner.close();
    }
}