package utility;

public interface DBOperation {
	
	// CREATE SQL METHOD
	String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS searchHistory "
            + "(id int(50) NOT NULL AUTO_INCREMENT,"
            + "itemId varchar(100) NOT NULL,"
            + "itemName varchar(100) NOT NULL,"
            + "itemPrice double NOT NULL,"
            + "itemSpecs varchar(100) NOT NULL,"
            + "itemImage varchar(100) NOT NULL, "
            + "megaPixels varchar(100) NOT NULL,"
            + "screenSize varchar(100) NOT NULL,"
            + "PRIMARY KEY (id))";
	
	String CREATE_TABLE_AUTO = "CREATE TABLE IF NOT EXISTS itemDB "
            + "(id int(50) NOT NULL AUTO_INCREMENT,"
            + "itemId varchar(100) NOT NULL,"
            + "itemQuantity int NOT NULL,"
            + "itemName varchar(100) NOT NULL,"
            + "itemPrice double NOT NULL,"
            + "itemSpecs varchar(100) NOT NULL,"
            + "itemImage varchar(100) NOT NULL, "
            + "megaPixels varchar(100) NOT NULL,"
            + "screenSize varchar(100) NOT NULL,"
            + "PRIMARY KEY (id))";
	
	String CREATE_TABLE_PURCHASE_HISTORY = "CREATE TABLE IF NOT EXISTS purchaseHistory "
            + "(orderID int(50) NOT NULL AUTO_INCREMENT,"
            + "customerName varchar(100) NOT NULL,"
            + "itemName varchar(100) NOT NULL,"
            + "itemQuantity varchar(100) NOT NULL,"
            + "itemPrice varchar(100) NOT NULL,"
            + "itemImage varchar(100) NOT NULL, "
            + "PRIMARY KEY (orderID))";
	
	// INSERT SQL METHOD
	String INSERT_RECORD = "insert into searchHistory (itemId, itemName, itemPrice, itemSpecs, "
			+ "itemImage, megaPixels, screenSize) values (?,?,?,?,?,?,?)";
	
	String INSERT_ALL_ITEMS = "insert into itemDB (itemId, itemQuantity, itemName, itemPrice, itemSpecs, " 
			+ "itemImage, megaPixels, screenSize) values (?,?,?,?,?,?,?,?)";
	
	String INSERT_PURCHASE_HISTORY = "insert into purchaseHistory (customerName, itemName, itemQuantity, itemPrice, " 
			+ "itemImage) values (?,?,?,?,?)";
	
	// SELECT SQL METHOD
	String GET_QUANTITY = "select itemQuantity from itemDB where itemName = ?";
	
	String GET_CUSTOMER_ORDER = "select * from purchaseHistory where orderID = ?";
	
	String GET_ORDERID = "select * from purchaseHistory";
	
	String GET_ITEMS = "select * from purchaseHistory where orderID=(select max(orderID) from purchaseHistory)";
	
	String CHECK = "select * from itemDB";
	
	// UPDATE SQL METHOD
	String UPDATE_QUANTITY = "update itemDB set itemQuantity = ? where itemName=?";
	
	
}
