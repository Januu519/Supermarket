package dao.custom.impl;

import dao.SQLUtil;
import dao.custom.QueryDAO;
import entity.CustomEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class QueryDAOImpl implements QueryDAO {
//    @Override
//    public ArrayList<CustomEntity> searchOrderByOrderID(String id) throws SQLException, ClassNotFoundException {
//        ResultSet rst = SQLUtil.executeQuery("select Orders.oid,Orders.date,Orders.customerID,OrderDetails.itemCode,OrderDetails.qty,OrderDetails.unitPrice from Orders inner join OrderDetails on Orders.oid=OrderDetails.oid where Orders.oid=?;", id);
//        ArrayList<CustomEntity> orderRecords = new ArrayList();
//        while (rst.next()) {
//            orderRecords.add(new CustomEntity(rst.getString(1), LocalDate.parse(rst.getString(2)), rst.getString(3), rst.getString(4), rst.getInt(5), rst.getBigDecimal(6)));
//        }
//        return orderRecords;
//    }

    @Override
    public ArrayList<CustomEntity> mostMovableItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT Item.ItemCode,Description,UnitPrice,QtyOnHand,SUM(OrderQTY) from Item inner join OrderDetail on Item.ItemCode = OrderDetail.ItemCode GROUP BY ItemCode ORDER BY SUM(OrderQTY) DESC");
        ArrayList<CustomEntity> mostMovable = new ArrayList();
        while (rst.next()) {
            mostMovable.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4), rst.getInt(5)));
        }
        return mostMovable;
    }

    @Override
    public ArrayList<CustomEntity> leastMovableItem() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.executeQuery("SELECT Item.ItemCode,Description,UnitPrice,QtyOnHand,SUM(OrderQTY) from Item inner join OrderDetail on Item.ItemCode = OrderDetail.ItemCode GROUP BY ItemCode ORDER BY SUM(OrderQTY)");
        ArrayList<CustomEntity> mostMovable = new ArrayList();
        while (rst.next()) {
            mostMovable.add(new CustomEntity(rst.getString(1), rst.getString(2), rst.getBigDecimal(3), rst.getInt(4), rst.getInt(5)));
        }
        return mostMovable;
    }
}
