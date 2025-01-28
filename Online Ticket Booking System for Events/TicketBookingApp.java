import java.util.*;

// Represents an Event
class Event {
    private int eventId;
    private String eventName;
    private String dateTime;
    private Map<String, Section> sections;

    public Event(int eventId, String eventName, String dateTime) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.dateTime = dateTime;
        this.sections = new HashMap<>();
        initializeSections();
    }

    private void initializeSections() {
        sections.put("Platinum", new Section("Platinum", 800, 250));
        sections.put("Gold", new Section("Gold", 550, 500));
        sections.put("Silver", new Section("Silver", 350, 750));
    }

    public String getEventName() {
        return eventName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Map<String, Section> getSections() {
        return sections;
    }

    public void displayEventDetails() {
        System.out.println("Event ID: " + eventId);
        System.out.println("Event Name: " + eventName);
        System.out.println("Date & Time: " + dateTime);
        System.out.println();
        System.out.println("Available Sections and Prices:");
        for (Section section : sections.values()) {
            System.out.println(section);
        }
    }
}

// Represents a Section (e.g., Platinum, Gold, Silver)
class Section {
    private String sectionName;
    private int availableSeats;
    private double seatPrice;

    public Section(String sectionName, int availableSeats, double seatPrice) {
        this.sectionName = sectionName;
        this.availableSeats = availableSeats;
        this.seatPrice = seatPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public boolean bookSeats(int quantity) {
        if (quantity <= availableSeats) {
            availableSeats -= quantity;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return sectionName + " - Available Seats: " + availableSeats + ", Price: $" + seatPrice;
    }
}

// Represents a Ticket booked by a User
class Ticket {
    private String userName;
    private String eventName;
    private String sectionName;
    private int quantity;
    private double totalPrice;

    public Ticket(String userName, String eventName, String sectionName, int quantity, double totalPrice) {
        this.userName = userName;
        this.eventName = eventName;
        this.sectionName = sectionName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "\nTicket Details:\n" +
                "User: " + userName +
                "\nEvent: " + eventName +
                "\nSection: " + sectionName +
                "\nQuantity: " + quantity +
                "\nTotal Price: $" + totalPrice;
    }
}

// Represents the Booking System
class BookingSystem {
    private List<Event> events;

    public BookingSystem() {
        events = new ArrayList<>();
        initializeEvents();
    }

    private void initializeEvents() {
        String[] eventNames = {"Concert A", "Concert B", "Play C",
                "Festival D", "Musical E"};
        String[] dates = {"2025-02-01 18:00", "2025-02-02 20:00", "2025-02-03 17:00", "2025-02-04 19:00",
                "2025-02-05 18:30", };

        for (int i = 0; i < eventNames.length; i++) {
            events.add(new Event(i + 1, eventNames[i], dates[i]));
        }
    }

    public void displayEvents() {
        for (Event event : events) {
            System.out.println("\nEvent Details:");
            event.displayEventDetails();
        }
    }

    public Event getEventById(int eventId) {
        for (Event event : events) {
            if (eventId == events.indexOf(event) + 1) {
                return event;
            }
        }
        return null;
    }

    public void bookTicket(String userName, int eventId, String sectionName, int quantity) {
        Event event = getEventById(eventId);

        if (event != null) {
            Section section = event.getSections().get(sectionName);
            if (section != null && section.bookSeats(quantity)) {
                double totalPrice = quantity * section.getSeatPrice();
                Ticket ticket = new Ticket(userName, event.getEventName(), sectionName, quantity, totalPrice);
                System.out.println("Booking Successful!");
                System.out.println(ticket);
            } else {
                System.out.println("Sorry, insufficient seats in " + sectionName + " section.");
            }
        } else {
            System.out.println("Invalid Event ID.");
        }
    }
}

// Main Class
public class TicketBookingApp {
    public static void main(String[] args) {
        BookingSystem bookingSystem = new BookingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Online Ticket Booking System!\n");

        while (true) {
            System.out.println("\n1. View Events");
            System.out.println("2. Book Tickets");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookingSystem.displayEvents();
                    break;

                case 2:
                    System.out.print("Enter your name: ");
                    scanner.nextLine(); // Consume newline
                    String userName = scanner.nextLine();

                    System.out.print("Enter Event ID to book tickets: ");
                    int eventId = scanner.nextInt();

                    System.out.print("Enter Section (Platinum/Gold/Silver): ");
                    scanner.nextLine(); // Consume newline
                    String sectionName = scanner.nextLine();

                    System.out.print("Enter the number of tickets to book: ");
                    int quantity = scanner.nextInt();

                    bookingSystem.bookTicket(userName, eventId, sectionName, quantity);
                    break;

                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
