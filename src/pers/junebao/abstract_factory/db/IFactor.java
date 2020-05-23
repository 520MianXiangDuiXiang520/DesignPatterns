package pers.junebao.abstract_factory.db;

public interface IFactor {
    IUserDao getUserDao();
    IDepartDao getDepartDao();
}
