package pers.junebao.abstract_factory.db;

public class MySQLFactory implements IFactor {
    @Override
    public IDepartDao getDepartDao() {
        return new MySQLDepartDao();
    }

    @Override
    public IUserDao getUserDao() {
        return new MySQLUserDao();
    }
}
