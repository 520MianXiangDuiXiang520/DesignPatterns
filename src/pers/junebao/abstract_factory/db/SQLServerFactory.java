package pers.junebao.abstract_factory.db;

public class SQLServerFactory implements IFactor {
    @Override
    public IDepartDao getDepartDao() {
        return new SQLServerDepartDao();
    }

    @Override
    public IUserDao getUserDao() {
        return new SQLServerUserDao();
    }
}
