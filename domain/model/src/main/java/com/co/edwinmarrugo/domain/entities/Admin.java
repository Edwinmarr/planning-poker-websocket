package com.co.edwinmarrugo.domain.entities;

import com.co.edwinmarrugo.domain.enums.Role;

public class Admin extends User{
    public Admin(String id, String name, Role role) {
        super(id, name, role);
    }
}
