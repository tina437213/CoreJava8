package edu.dtorres.corejava8.cp2.ex15;

import java.util.ArrayList;
import java.util.UUID;

/**
 * 
 * Fully implement the Invoice class in Section 2.6.1, "Static Nested Classes",
 * on p. 79. Provide a method that prints the invoice and a demo program that
 * constructs and prints a smaple invoice.
 * 
 * @author diego
 *
 */
public class Invoice {

	public static void main(String... args) {
		Invoice invoice = new Invoice(0.16d);
		invoice.add(new Invoice.Item("Product 1", 7, 3.25d));
		invoice.add(new Invoice.Item("Product 2", 2, 4.32d));
		invoice.add(new Invoice.Item("Product 3", 9, 1.12d));
		invoice.add(new Invoice.Item("Product 4", 15, 9.33d));
		invoice.add(new Invoice.Item("Product 5", 10, 15.85d));
		System.out.println(invoice);
	}

	private static class Item {
		private String description;
		private int quantity;
		private double unitPrice;

		public Item(String description, int quantity, double unitPrice) {
			this.description = description;
			this.quantity = quantity;
			this.unitPrice = unitPrice;
		}

		public double price() {
			return quantity * unitPrice;
		}

		@Override
		public String toString() {
			return "Item [description=" + description + ", quantity=" + quantity + ", unitPrice=" + unitPrice
					+ ", price()=" + price() + "]";
		}
	}

	private String folio = UUID.randomUUID().toString();
	private double taxPct = 0.0d;
	private ArrayList<Item> items = new ArrayList<>();

	public Invoice(double taxPct) {
		this.taxPct = taxPct;
	}

	public void add(Item item) {
		items.add(item);
	}

	public int itemCount() {
		return items.size();
	}

	public String getFolio() {
		return folio;
	}

	/**
	 * Calculate using stream p. 265
	 * 
	 * @return
	 */
	public double invoiceTotal() {
		return items.parallelStream().mapToDouble(Item::price).sum();
	}

	public double invoiceTax() {
		return invoiceTotal() * taxPct;
	}

	public double grandTotal() {
		return invoiceTotal() + invoiceTax();
	}

	@Override
	public String toString() {
		return "Invoice [taxPct=" + taxPct + ", items=" + items + ", itemCount()=" + itemCount() + ", getFolio()="
				+ getFolio() + ", invoiceTotal()=" + invoiceTotal() + ", invoiceTax()=" + invoiceTax()
				+ ", grandTotal()=" + grandTotal() + "]";
	}

}
