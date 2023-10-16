package org.example;

public class Main {
    public static void main(String[] args) {
        BuddyInfo buddy = new BuddyInfo("Tom", "613", "Carleton");
        BuddyInfo buddy2 = new BuddyInfo("Jay", "266", "California");
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(buddy);
        addressBook.addBuddy(buddy2);

        for(int i=0; i < addressBook.getBuddyList().size(); i++) {
            System.out.println(addressBook.getBuddyList().get(i).getName());
            System.out.println(addressBook.getBuddyList().get(0).getPhoneNumber());
            System.out.println(addressBook.getBuddyList().get(0).getAddress());
            System.out.println("---------------------------------");
        }

    }
}