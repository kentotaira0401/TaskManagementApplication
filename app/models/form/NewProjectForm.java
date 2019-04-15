package models.form;

import java.util.Date;

import play.data.validation.Constraints.Max;
import play.data.validation.Constraints.Min;
import play.data.validation.Constraints.Required;

/**
 * 新しいプロジェクトを設定するフォーム
 * 
 * @author kento
 *
 */
public class NewProjectForm {

	/**
	 * プロジェクト名
	 */
	@Required
	private String projectName;
	
	/**
	 * 説明
	 */
	@Required
	private String explanation;
	
	/**
	 * 期日
	 */
	@Required
	private Date date;
	
	/**
	 * 進捗度
	 */
	@Required
	@Max(100)
	@Min(0)
	private Double progressMeter;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getProgressMeter() {
		return progressMeter;
	}

	public void setProgressMeter(Double progressMeter) {
		this.progressMeter = progressMeter;
	}




	
	
	
}
