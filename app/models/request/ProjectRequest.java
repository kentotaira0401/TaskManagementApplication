package models.request;

import java.util.Date;

public class ProjectRequest {

	
	/**
	 * プロジェクトID
	 */
	public Long id;
	
	/**
	 * プロジェクト名
	 */
	public String name;
	
	/**
	 * 説明
	 */
	public String explanation;
	
	/**
	 * 期日
	 */
	public String date;
	
	/**
	 * 進捗度
	 */
	public Double progressMeter;
	
	/**
	 * プロジェクト終了フラグ
	 */
	public String finishFlag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Double getProgressMeter() {
		return progressMeter;
	}

	public void setProgressMeter(Double progressMeter) {
		this.progressMeter = progressMeter;
	}

	public String getFinishFlag() {
		return finishFlag;
	}

	public void setFinishFlag(String finishFlag) {
		this.finishFlag = finishFlag;
	}

	@Override
	public String toString() {
		return "ProjectRequest [id=" + id + ", name=" + name + ", explanation=" + explanation + ", date=" + date
				+ ", progressMeter=" + progressMeter + ", finishFlag=" + finishFlag + "]";
	}


	
	
	
	
}
