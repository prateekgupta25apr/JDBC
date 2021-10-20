package DAO;

import DTO.MarketDetailsDTO;

public interface MarketDetailsDAO {
    boolean save(MarketDetailsDTO dto);
    void getAll();
    boolean updateNumberOfShops(String name);
    void getByLocation(String location);
    boolean deleteById(int id);
}
