package utility;

import java.sql.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.*;
import model.camera.*;

public class SingletonDB implements DBOperation{

	//DEFAULTED TO NULL
	private static Connection connection; 
	
	//FOR DATABASE SETTING
	//private static String jdbcUrl;
	//private static String jdbcDriver;
	//private static String dbUserName;
	//private static String dbPassword;
	
	private SingletonDB() {
	}
	
	// CONNECTION METHOD
	private static Connection getDBConnection() {
		Connection connection = null;
		
		//Context initContext;
		try {
		
			connection = ((DataSource)InitialContext.doLookup("java:/comp/env/jdbc/SEG31_DS")).getConnection();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return connection;
	}
	
	//now this is the global method that can be accessed statically by
	//other classes when creating a Connection object
	public static Connection getConnection() { 
	  return (( connection !=null ) ?
	  connection : getDBConnection());
	}
	
	// CREATE TABLE METHOD
	public static void createTable() throws SQLException {
		connection = getDBConnection();
		if(connection != null) {
			PreparedStatement pstmntCreate = connection.prepareStatement(CREATE_TABLE);
			pstmntCreate.executeUpdate();
			pstmntCreate.close();
			
			PreparedStatement pstmntCreateAuto = connection.prepareStatement(CREATE_TABLE_AUTO);
			pstmntCreateAuto.executeUpdate();
			pstmntCreateAuto.close();
			
			PreparedStatement pstmntCreatePurchaseHistory = connection.prepareStatement(CREATE_TABLE_PURCHASE_HISTORY);
			pstmntCreatePurchaseHistory.executeUpdate();
			pstmntCreatePurchaseHistory.close();
		}
	}
	
	// INSERT ALL ITEMS TO ITEMDB
	public static void insertPhone(String itemId, int itemQuantity, String itemName, double itemPrice, String itemSpecs, String itemImage, String megaPixels, String screenSize) throws SQLException {
		connection = getDBConnection();
		
		if(connection != null) {
			PreparedStatement pstmnt = connection.prepareStatement(INSERT_ALL_ITEMS);
			
			pstmnt.setString(1, itemId);
			pstmnt.setInt(2, itemQuantity);
			pstmnt.setString(3, itemName);
			pstmnt.setDouble(4, itemPrice);
			pstmnt.setString(5, itemSpecs);
			pstmnt.setString(6, itemImage);
			pstmnt.setString(7, megaPixels);
			pstmnt.setString(8, screenSize);
			
			pstmnt.executeUpdate();
			pstmnt.close();
		}
	}
	
	// SET ALL ITEMS TO BE INSERTED TO ITEMDB
	public static void insertItems() throws SQLException {
		
		try {
			connection = getDBConnection();
			Statement statement = connection.createStatement();
			String sql = CHECK;
			
			ResultSet rs = statement.executeQuery(sql);
			
			if(rs.next()) {
				/* System.out.println("item already in database"); */
			}else {
				GooglePixel4A googlepixel = new GooglePixel4A();
				googlepixel.setItemId();
				googlepixel.setItemQuantity();
				googlepixel.setItemName();
				googlepixel.setItemPrice();
				googlepixel.setItemSpecs();
				googlepixel.setItemImage();
				
				GooglePixel4ACamera googlepixel4acamera = new GooglePixel4ACamera();
				googlepixel4acamera.setMegapixels();
				googlepixel4acamera.setScreenSize();
				insertPhone(googlepixel.getItemId(), googlepixel.getItemQuantity(), googlepixel.getItemName(), googlepixel.getItemPrice(), googlepixel.getItemSpecs(), googlepixel.getItemImage(), googlepixel4acamera.getMegapixels(), googlepixel4acamera.getScreenSize());
				
				Iphone12ProMax iphone12 = new Iphone12ProMax();
				iphone12.setItemId();
				iphone12.setItemQuantity();
				iphone12.setItemName();
				iphone12.setItemPrice();
				iphone12.setItemSpecs();
				iphone12.setItemImage();
				
				Iphone12ProMaxCamera iphone12promaxcamera = new Iphone12ProMaxCamera();
				iphone12promaxcamera.setMegapixels();
				iphone12promaxcamera.setScreenSize();
				insertPhone(iphone12.getItemId(), iphone12.getItemQuantity(), iphone12.getItemName(), iphone12.getItemPrice(), iphone12.getItemSpecs(), iphone12.getItemImage(), iphone12promaxcamera.getMegapixels(), iphone12promaxcamera.getScreenSize());
				
				SamsungZFlip samsungz = new SamsungZFlip();
				samsungz.setItemId();
				samsungz.setItemQuantity();
				samsungz.setItemName();
				samsungz.setItemPrice();
				samsungz.setItemSpecs();
				samsungz.setItemImage();
				
				SamsungZFlipCamera samsungzflipcamera = new SamsungZFlipCamera();
				samsungzflipcamera.setMegapixels();
				samsungzflipcamera.setScreenSize();
				insertPhone(samsungz.getItemId(), samsungz.getItemQuantity(), samsungz.getItemName(), samsungz.getItemPrice(), samsungz.getItemSpecs(), samsungz.getItemImage(), samsungzflipcamera.getMegapixels(), samsungzflipcamera.getScreenSize());
				
				XiaomiM3 xiaomim3 = new XiaomiM3();
				xiaomim3.setItemId();
				xiaomim3.setItemQuantity();
				xiaomim3.setItemName();
				xiaomim3.setItemPrice();
				xiaomim3.setItemSpecs();
				xiaomim3.setItemImage();
				
				XiaomiM3Camera xiaomim3camera = new XiaomiM3Camera();
				xiaomim3camera.setMegapixels();
				xiaomim3camera.setScreenSize();
				insertPhone(xiaomim3.getItemId(), xiaomim3.getItemQuantity(), xiaomim3.getItemName(), xiaomim3.getItemPrice(), xiaomim3.getItemSpecs(), xiaomim3.getItemImage(), xiaomim3camera.getMegapixels(), xiaomim3camera.getScreenSize());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// INSERT TO SEARCH HISTORY
	public static boolean insertRecord(Phone phone, Camera camera, 
		String driver, String url, String userName, String password) {
		
		boolean isSuccessful = false;
		Connection connection = getDBConnection();
		
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				PreparedStatement pstmnt = connection.prepareStatement(INSERT_RECORD);
				
				pstmnt.setString(1, phone.getItemId());
				pstmnt.setString(2, phone.getItemName());
				pstmnt.setDouble(3, phone.getItemPrice());
				pstmnt.setString(4, phone.getItemSpecs());
				pstmnt.setString(5, phone.getItemImage());
				pstmnt.setString(6, phone.getCamera().getMegapixels());
				pstmnt.setString(7, phone.getCamera().getScreenSize());
				
				pstmnt.executeUpdate();
				
				connection.commit();
				isSuccessful = true;
			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		} 
		return isSuccessful;
	}
	
	// INSERT TO PURCHASE HISTORY
	public static boolean insertPurchase(String data_owner, String data_itemName, String data_itemCount, String data_itemPrice, String data_itemImage) {
		boolean isSuccessful = false;
		Connection connection = getDBConnection();
		
		if (connection != null) {
			try {
				connection.setAutoCommit(false);
				PreparedStatement pstmnt = connection.prepareStatement(INSERT_PURCHASE_HISTORY);
				
				pstmnt.setString(1, data_owner);
				pstmnt.setString(2, data_itemName);
				pstmnt.setString(3, data_itemCount);
				pstmnt.setString(4, data_itemPrice);
				pstmnt.setString(5, data_itemImage);

				pstmnt.executeUpdate();
				
				connection.commit();
				isSuccessful = true;
			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		} 
		return isSuccessful;
		
	}
	
	// GET ITEMQUANTITY IN ITEMDB
	public static int getItemQuantity(String itemName) {
		Connection connection = getDBConnection();
		
		if (connection != null) {
			try {
				
				PreparedStatement pstmnt = connection.prepareStatement(GET_QUANTITY);
				pstmnt.setString(1, itemName);
				ResultSet rs = pstmnt.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1);
					
				}else {
					return 0;
				}

			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		}
		return 0; 
	}
	
	// DEDUCT ITEMQUANTITY IN ITEMDB
	public static void updateQuantity(int itemQuantity, int count, String itemName) {
		Connection connection = getDBConnection();
		
		if (connection != null) {
			try {

				PreparedStatement pstmnt = connection.prepareStatement(UPDATE_QUANTITY);
				pstmnt.setInt(1, itemQuantity - count);
				pstmnt.setString(2, itemName);
				
				int rs = pstmnt.executeUpdate();
				
				if(rs > 0) {
					System.out.println("Deduction Success!");
				}
					
			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		}
	}
	
	// GET ORDERID FOR BUILDER PATTERN
	public static int getItems() {
		Connection connection = getDBConnection();
		int row = 0;
		if (connection != null) {
			
			try {
				
				PreparedStatement pstmnt = connection.prepareStatement(GET_ITEMS);
				ResultSet rs = pstmnt.executeQuery();
				while(rs.next()) {
					row = rs.getInt("orderID");
				}
				
				rs.close();
				pstmnt.close();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return row;
	}
	
	// GET ORDERID FOR ITERATOR PATTERN
	public static String getPhoneName(int orderID) {
		String itemName = "";
		Connection connection = getDBConnection();
		try {
			PreparedStatement pstmnt = connection.prepareStatement(GET_CUSTOMER_ORDERID);
			pstmnt.setInt(1, orderID);
			ResultSet rs = pstmnt.executeQuery();
			
			while(rs.next()) {
				itemName = rs.getString("itemName");
			}
			
			rs.close();
			pstmnt.close();
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return itemName;
	}
	
	public static PurchaseItems getPhoneItems(int orderID) {
		
		Connection connection = getDBConnection();
		PurchaseItems purchaseItems = new PurchaseItems();
		if (connection != null) {
			try {
				
				PreparedStatement pstmnt = connection.prepareStatement(GET_CUSTOMER_ORDER);
				pstmnt.setInt(1, orderID);
				ResultSet rs = pstmnt.executeQuery();
				
				while(rs.next()) {
					purchaseItems.setOrderID(rs.getInt("orderID"));
					purchaseItems.setCustomerName(rs.getString("customerName"));
					purchaseItems.setItemName(rs.getString("itemName"));
					purchaseItems.setItemQuantity(rs.getInt("itemQuantity"));
					purchaseItems.setItemPrice(rs.getDouble("itemPrice"));
				}
				rs.close();
				pstmnt.close();
				if(purchaseItems.getOrderID() == 0) {
					return null;
				}
			} catch (SQLException sqle) {
				try {
					connection.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				sqle.printStackTrace();
			}
		}
		return purchaseItems;
	}
	
	// LUHN TEST VALIDATION METHOD
	//VALIDATION OF NUMBER LENGTH
	public static boolean Validate(String ccn){
		
		int count = ccn.length();
		boolean isValid = false;
		
		if (count != 16) {
			
		}else {
			if(luhnTest(ccn)){
				
			}else{
				
			}
			isValid = true;
		}
		return isValid;
	}
	//VALIDATION OF LUHN ALGORITHM
	public static boolean luhnTest(String luhn) {
		
		boolean test = false;
		int s1 = 0;
		int s2 = 0;
		
		String reverse = new StringBuffer().reverse().toString();
		
		for(int i = 0 ;i < reverse.length();i++){
	           int digit = Character.digit(reverse.charAt(i), 10);
	           if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
	               s1 += digit;
	           }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
	               s2 += 2 * digit;
	               if(digit >= 5){
	                   s2 -= 9;
	               }
	           }
	       }if (s1 + s2 % 10 == 0) {
	       	test = true;
	       }else {
	       	test = false;
	       }
		return test;
	}

}
