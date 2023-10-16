package org.example;
import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    private Integer id;
    private List<BuddyInfo> list;

    public AddressBook(){
        this.list = new ArrayList<>();
    }

    public void addBuddy(BuddyInfo buddy){
        list.add(buddy);
    }

    public void removeBuddy(BuddyInfo buddy){
        list.remove(buddy);
    }

    public void removeBuddyByID(long id) {
        list.removeIf(b -> b.getId() == id);
    }

    @OneToMany(cascade = CascadeType.ALL)
    public List<BuddyInfo> getBuddyList() {
        return list;
    }

    public void setBuddyList(List<BuddyInfo> buddyList) {
        this.list = buddyList;
    }

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}