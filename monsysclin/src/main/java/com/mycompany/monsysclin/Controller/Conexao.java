package com.mycompany.monsysclin.Controller;

import org.apache.commons.dbcp2.BasicDataSource;

public class Conexao {
    
     private BasicDataSource datasource;
     private String stringUrl = "jdbc:sqlserver:"
                + "//monsysclin.database.windows.net:1433;"
                + "database=Monsysclin;"
                + "user=administrador@monsysclin;"
                + "password={#Gfgrupo6};"
                + "encrypt=true;"
                + "trustServerCertificate=false;"
                + "hostNameInCertificate=*.database.windows.net;"
                + "loginTimeout=30;";
     
     
    public Conexao() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.datasource.setUrl(stringUrl);
        this.datasource.setUsername("administrador");
        this.datasource.setPassword("#Gfgrupo6");
    }

    // Getter

    public BasicDataSource getDatasource() {
        return datasource;
    }

    public String getStringUrl() {
        return stringUrl;
    }
    
}
