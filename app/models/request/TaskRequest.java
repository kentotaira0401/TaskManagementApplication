package models.request;

import java.util.Calendar;

import javax.persistence.Id;

public class TaskRequest {

	/**
	 * ID
	 */
	@Id
	public Long id;
	
	
	/**
	 * プロジェクトID
	 */
	public Long project_id;
	
	
	/**
	 * タスク名
	 */
	public String name;
	
	/**
	 * 説明
	 */
	public String explanation;
	
	/**
	 * 開始日
	 */
	public String start_date;
	
	/**
	 * 締切日
	 */
	public String closing_date;
	
	/**
	 * スタッフID
	 */
	public Integer staff_id;
	
	/**
	 * カテゴリーID
	 */
	public Integer category_id;
	
	/**
	 * finishフラグ
	 */
	public Integer finish_flag;

	@Override
	public String toString() {
		return "TaskRequest [id=" + id + ", project_id=" + project_id + ", name=" + name + ", explanation="
				+ explanation + ", start_date=" + start_date + ", closing_date=" + closing_date + ", staff_id="
				+ staff_id + ", category_id=" + category_id + ", finish_flag=" + finish_flag + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProject_id() {
		return project_id;
	}

	public void setProject_id(Long project_id) {
		this.project_id = project_id;
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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getClosing_date() {
		return closing_date;
	}

	public void setClosing_date(String closing_date) {
		this.closing_date = closing_date;
	}

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public Integer getFinish_flag() {
		return finish_flag;
	}

	public void setFinish_flag(Integer finish_flag) {
		this.finish_flag = finish_flag;
	}
	
	
	
}
