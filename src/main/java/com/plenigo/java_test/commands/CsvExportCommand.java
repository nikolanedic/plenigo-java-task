package com.plenigo.java_test.commands;

import com.plenigo.java_test.services.PlenigoSDK.Entities.Customer;
import com.plenigo.java_test.services.PlenigoSDK.Entities.Invoice;
import com.plenigo.java_test.services.PlenigoSDK.Entities.Order;
import com.plenigo.java_test.services.PlenigoSDK.Entities.OrderItem;
import com.plenigo.java_test.services.PlenigoSDK.PlenigoSdk;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@ShellComponent
public class CsvExportCommand {

    private final PlenigoSdk plenigoSdk;

    @ShellMethod(key = "export-orders", value = "Exports offer data to CSV")
    public void generateOrdersCsv() {
        List<Order> orders = this.plenigoSdk.fetchNEntities(Order.class, 300);

        HashMap<String, Customer> customerCache = new HashMap<>();

        List<String[]> data = new ArrayList<>();
        data.add(new String[]{
                "Order ID",
                "Order item position",
                "Title",
                "Price",
                "Tax Rate",
                "Customer ID",
                "Customer email",
                "Customer create date",
                "Invoice ID",
                "Invoice create date"});

        for (Order order : orders) {
            Customer customer;
            List<Invoice> invoices = List.of();

            try {
                invoices = this.plenigoSdk.fetchEntities(Invoice.class, 10, Map.of("orderId", order.getId()), null);
            } catch (Exception e) {
                System.out.println("Failed to fetch invoice for order ID: " + order.getId());
                System.out.println(e.getMessage());
            }

            if (customerCache.containsKey(order.getInvoiceCustomerId())) {
                customer = customerCache.get(order.getInvoiceCustomerId());
            } else {
                try {
                    customer = this.plenigoSdk.fetchEntity(Customer.class, orders.getFirst().getInvoiceCustomerId());
                } catch (Exception e) {
                    System.out.println("Failed to fetch customer for ID: " + order.getInvoiceCustomerId());
                    System.out.println(e.getMessage());
                    continue;
                }

                customerCache.put(order.getInvoiceCustomerId(), customer);
            }

            for (OrderItem item : order.getItems()) {
                String invoiceId = "";
                String invoiceDate = "";

                if (invoices != null && !invoices.isEmpty()) {
                    invoiceId = invoices.getFirst().getId();
                    invoiceDate = String.valueOf(invoices.getFirst().getInvoiceDate());
                }

                data.add(new String[]{
                        order.getId(),
                        String.valueOf(item.getPosition()),
                        item.getTitle(),
                        String.valueOf(item.getPrice()),
                        String.valueOf(item.getTax()),
                        customer.getId(),
                        customer.getEmail(),
                        customer.getCreatedDate().toString(),
                        invoiceId,
                        invoiceDate
                });
            }
        }


         try (FileWriter csvWriter = new FileWriter("output.csv")) {
            csvWriter.append(String.join(",", data.getFirst()));
            csvWriter.append("\n");

            for (int i = 1; i < data.size(); i++) {
                csvWriter.append(String.join(",", data.get(i)));
                csvWriter.append("\n");
            }

            System.out.println("CSV file created successfully!");

        } catch (IOException e) {
            System.err.println("Error writing CSV file: " + e.getMessage());
        }
    }

    public CsvExportCommand(PlenigoSdk plenigoSdk) {
        this.plenigoSdk = plenigoSdk;
    }
}
