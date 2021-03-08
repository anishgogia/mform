package DAO;

public class MYSQLDao implements Operations{
    MYSQLDao()
    {
        System.out.println("MySql Constructor");
    }
    @Override
    public void create() {
        System.out.println("Create MySQL");
    }

    @Override
    public void delete() {
        System.out.println("Delete MySQL");
    }

    @Override
    public void update() {
        System.out.println("Update MySQL");
    }

    @Override
    public void read() {
        System.out.println("Read MSQL");
    }
}



