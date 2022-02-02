package db.a03;

public class AolUser {
	final static String TBL_AolUser = "AolUser";
	final static String COL_User_ID = "User_ID";
	
	final static String SELECT_STAR_FROM_AOLUSER = "select * from " + TBL_AolUser;
	final static String INSERT_INTO_AOLUSER = "insert into " +  TBL_AolUser + "(" + COL_User_ID + 
			") select distinct ANONID from aoldata.querydata where query like '%terrorism%'";
}
