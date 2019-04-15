package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.avaje.ebean.Model;


//JPAでは、dbに保管されるデータは「エンティティ(Entity)」で扱われる
//このクラスがエンティティであることを示すのが@Entity。Modelクラスでは必ずこのアノテーションをつける
@Entity
public class Message extends Model{

	@Id//←を記述したフィールドがプライマリーキーの項目として扱われる
	public Long id;
	
	public String name;
	
	public String mail;
	
	public String message;
	
	public Date postdate;
}
