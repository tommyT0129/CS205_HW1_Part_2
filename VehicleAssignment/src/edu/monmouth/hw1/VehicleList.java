package edu.monmouth.hw1;

import edu.monmouth.vehicle.Vehicle;

public class VehicleList {
    private VehicleNode head;

    public VehicleList() {
        head = null;
    }

    public VehicleNode insert(Vehicle vehicle) {
        VehicleNode node = new VehicleNode(vehicle);
        node.setNext(head);
        head = node;
        return node;
    }

    public VehicleNode insertEnd(Vehicle vehicle) {
        VehicleNode node = new VehicleNode(vehicle);
        if (head == null) {
            head = node;
        } else {
            last().setNext(node);
        }
        return node;
    }

    public VehicleNode first() {
        return head;
    }

    public VehicleNode last() {
        VehicleNode current = head;
        if (current == null) {
            return null;
        }
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current;
    }

    public VehicleNode removeFirst() {
        VehicleNode removed = head;
        if (head != null) {
            head = head.getNext();
            removed.setNext(null);
        }
        return removed;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        int count = 0;
        for (VehicleNode i = head; i != null; i = i.getNext()) {
            count++;
        }
        
        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "VehicleList is empty";
        }
        StringBuilder result = new StringBuilder("VehicleList (" + size() + " vehicles):\n");
        int i = 1;
        for (VehicleNode n = head; n != null; n = n.getNext()) {
            result.append("  ").append(i++).append(". ").append(n).append('\n');
        }
        
        return result.toString();
    }
}
