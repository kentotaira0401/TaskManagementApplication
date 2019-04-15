package models;

import play.data.validation.Constraints.Required;

/**
 * input type="text"タグの値を保管するためのクラス
 * 
 * @author kento
 *
 */
public class SampleForm {

	@Required
	public String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
