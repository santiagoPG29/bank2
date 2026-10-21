package application.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import application.domain.models.Cart;
import application.domain.models.Delivery;
import application.domain.models.Inventory;
import application.domain.models.Order;
import application.domain.models.Producto;
import application.domain.models.Refund;
import application.domain.models.enums.DeliveryStatus;
import application.domain.models.enums.OrderStatus;

class DomainCommandServicesTest {
    @Test
    void cartProductServiceChangesProductsWithoutOwningCartPersistence() {
        CartService cartService = new CartService();
        CartProductService productService = new CartProductService(cartService);
        Cart cart = cartService.save(new Cart());
        Producto product = new Producto();
        product.setId(10L);

        productService.addProduct(cart.getId(), product);
        assertEquals(1, cart.getProducts().size());

        productService.removeProduct(cart.getId(), product.getId());
        assertTrue(cart.getProducts().isEmpty());
    }

    @Test
    void deliveryConfirmationServiceConfirmsExistingDelivery() {
        DeliveryService deliveryService = new DeliveryService();
        DeliveryConfirmationService confirmationService = new DeliveryConfirmationService(deliveryService);
        Delivery delivery = deliveryService.save(new Delivery());

        confirmationService.confirmDelivery(delivery.getId());

        assertEquals(DeliveryStatus.DELIVERED, delivery.getDeliveryStatus());
    }

    @Test
    void inventoryStockServiceOwnsStockOperations() {
        InventoryService inventoryService = new InventoryService();
        InventoryStockService stockService = new InventoryStockService(inventoryService);
        Inventory inventory = new Inventory();
        inventory.setQuantity(5);
        inventoryService.save(inventory);

        stockService.increaseStock(inventory.getId(), 3);
        assertTrue(stockService.hasStock(inventory.getId(), 8));

        stockService.decreaseStock(inventory.getId(), 2);
        assertEquals(6, inventory.getQuantity());
        assertFalse(stockService.hasStock(inventory.getId(), 7));
    }

    @Test
    void refundDecisionServiceApprovesAndDeclinesRefunds() {
        RefundService refundService = new RefundService();
        RefundDecisionService decisionService = new RefundDecisionService(refundService);
        Order order = new Order();
        Refund approvedRefund = new Refund();
        approvedRefund.setOrder(order);
        refundService.save(approvedRefund);

        decisionService.approve(approvedRefund.getId());

        assertEquals(OrderStatus.CANCELLED, order.getStatus());
        assertEquals("Approved", approvedRefund.getReason());

        Refund declinedRefund = refundService.save(new Refund());
        decisionService.decline(declinedRefund.getId());
        assertEquals("Declined", declinedRefund.getReason());
    }
}