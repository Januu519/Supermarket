package bo;

import bo.custom.impl.*;
//import bo.custom.impl.MostMovableItemBOImpl;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public enum BOTypes {
        CUSTOMER, ITEM, PURCHASE_ORDER, MOSTMOVABLEITEM, LEASTMOVABLEITEM
    }

    public SuperBO getBO(BOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerBOImpl(); // SuperBO bo =new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl(); // SuperBO bo = new ItemBOImpl();
            case PURCHASE_ORDER:
                return new PurchaseOrderBOImpl(); //SuperBO bo = new PurchaseOrderBOImpl();
            case MOSTMOVABLEITEM:
                return new MostMovableBOImpl();
            case LEASTMOVABLEITEM:
                return new LeastMovableBOImpl();
            default:
                return null;
        }
    }
}
