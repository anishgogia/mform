package DAO;

public class PosGresDao implements Operations{
    PosGresDao()
    {
        System.out.println("Pos Gres Constructor");
    }
    @Override
    public void create() {
        System.out.println("Create Pos Gres");
    }

    @Override
    public void delete() {
        System.out.println("Delete Pos Gres");
    }

    @Override
    public void update() {
        System.out.println("Update Pos Gres");
    }

    @Override
    public void read() {
        System.out.println("Read Pos Gres");
    }
}


