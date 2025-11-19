package com.solid_principle;


//Main class to demonstrate
public class SolidPrinciples {
	
	public static void main(String[] args) {
        // SRP
        Book book = new Book("Clean Code");
        BookPrinter printer = new BookPrinter();
        printer.printBookTitle(book);

        // OCP
        Discount discount = new SeasonalDiscount();
        System.out.println("Discounted price: " + discount.applyDiscount(1000));

        // LSP
        Animal animal = new Dog();
        animal.sound();

        // ISP
        Reader reader = new BookReader();
        Writer writer = new BookWriter();
        reader.read();
        writer.write();

        // DIP
        Notification notification = new EmailNotification();
        NotificationService service = new NotificationService(notification);
        service.sendNotification();
    }

}

//1. Single Responsibility Principle (SRP)
//एक class का केवल एक ही responsibility होना चाहिए
class Book {
	private String title;

	public Book(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}

class BookPrinter {
	public void printBookTitle(Book book) {
		System.out.println("Book title: " + book.getTitle());
	}
}

//2. Open/Closed Principle (OCP)
//Class open हो एक्सटेंशन के लिए, लेकिन modification के लिए बंद हो
abstract class Discount {
	public abstract double applyDiscount(double price);
}

class NoDiscount extends Discount {
	public double applyDiscount(double price) {
		return price;
	}
}

class SeasonalDiscount extends Discount {
	public double applyDiscount(double price) {
		return price * 0.8;
	}
}

//3. Liskov Substitution Principle (LSP)
//Subclass को superclass की जगह उपयोग किया जा सके बिना गलती के
class Animal {
	public void sound() {
		System.out.println("Animal sound");
	}
}

class Dog extends Animal {
	public void sound() {
		System.out.println("Bark");
	}
}

//4. Interface Segregation Principle (ISP)
//Interface छोटे और specific होने चाहिए
interface Reader {
	void read();
}

interface Writer {
	void write();
}

class BookReader implements Reader {
	public void read() {
		System.out.println("Reading book");
	}
}

class BookWriter implements Writer {
	public void write() {
		System.out.println("Writing book");
	}
}

//5. Dependency Inversion Principle (DIP)
//High-level modules low-level modules पर निर्भर न करें, बल्कि abstractions पर depend करें
interface Notification {
	void notifyUser();
}

class EmailNotification implements Notification {
	public void notifyUser() {
		System.out.println("Email sent");
	}
}

class NotificationService {
	private Notification notification;

	public NotificationService(Notification notification) {
		this.notification = notification;
	}

	public void sendNotification() {
		notification.notifyUser();
	}
}