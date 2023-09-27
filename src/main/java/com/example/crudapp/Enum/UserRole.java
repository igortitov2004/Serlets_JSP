package com.example.crudapp.Enum;

public enum UserRole {
    ADMIN("Администратор"), MANAGER("Менеджер");
    final String translate;

    public String getTranslate(){
        return this.translate;
    }
    UserRole(String translate){
       this.translate  = translate;
    }
}
