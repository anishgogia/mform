package DAO;


public class OracleDao implements Operations{
    OracleDao()
    {
        System.out.println("Oracle Constructor");
    }
    @Override
    public void create() {
        System.out.println("Create Oracle");
    }

    @Override
    public void delete() {
        System.out.println("Delete Oracle");
    }

    @Override
    public void update() {
        System.out.println("Update Oracle");
    }

    @Override
    public void read() {
        System.out.println("Read Oracle");
    }
}


