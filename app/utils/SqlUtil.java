package utils;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.SqlRow;


public class SqlUtil {
	
	
//	public void insertNewTask(String newTaskName) {
//		
//		String sql = "insert";
//		
//	}
	
    /*スケジュールのグループIDからエリア、フロアを取得するSQL*/
    public static Long getNewTaskId() {

        String sql = "select MAX(id) id from tasks;";

        SqlRow sqlRow = Ebean.createSqlQuery(sql).findUnique();

        Long newTaskId ;
        newTaskId = (sqlRow.getLong("id"));

        return newTaskId;
    }
	
	
}
