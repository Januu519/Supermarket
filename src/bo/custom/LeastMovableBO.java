package bo.custom;

import bo.SuperBO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LeastMovableBO extends SuperBO {
    ArrayList<CustomDTO> getAllLeastMovableItem() throws SQLException, ClassNotFoundException;

}
