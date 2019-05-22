package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import models.entity.Project;
import models.entity.Task;
import models.request.ProjectRequest;
import models.request.TaskRequest;
import play.data.DynamicForm;
import play.mvc.Controller;
import play.mvc.Result;
import utils.CommonUtil;
import utils.SqlUtil;

public class Detail extends Controller{

	// ID別にプロジェクトの詳細画面を表示
	public Result project(Long id) {
    	//Form<Project> form = new Form(Project.class).bindFromRequest();//送信されたフォームの値をバインド(割当て)したFormインスタンスを返す。
		
		// プロジェクト情報を取得
		Project project = Project.find.byId(id);
		System.out.println("pro_id"+project.getId());
		// プロジェクトIDからタスク情報を取得
		List<Task> taskLists = Task.find.where().eq("project_id",project.getId()).orderBy().desc("display_order").findList();
		List<TaskRequest> taskList = new ArrayList<>();
		for(Task task: taskLists) {
			TaskRequest taskRequest = getTaskRequest(task);
			
			taskList.add(taskRequest);
		}
		// プロジェクト情報をセット
		ProjectRequest projectRequest = new ProjectRequest();
		projectRequest.setId(project.getId());
		projectRequest.setName(project.getName());
		projectRequest.setExplanation(project.getExplanation());
		
		return ok(views.html.detail.detailProject.render(projectRequest,taskList));
	}


	
	public Result sendParam(){
		
		DynamicForm form = DynamicForm.form().bindFromRequest();
		
		Long taskId = CommonUtil.getStr2Long(form.data().get("param1"));
		
		Task taskObj = Task.find.byId(taskId);
		
		ObjectMapper mapper = new ObjectMapper();
	    String json ="";
	    
		try {
			json = mapper.writeValueAsString(taskObj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return ok(json);
	}

	/**
	 * 新タスクをinsert
	 * その後
	 * そのタスク情報を返す
	 * 
	 * @return
	 */
	public Result insertNewTask() {
		
		DynamicForm form = DynamicForm.form().bindFromRequest();
		String newTaskName = form.data().get("taskName");
		Long projectId = CommonUtil.getStr2Long(form.data().get("projectId"));
		Integer finishFlag = CommonUtil.getStr2Int(form.data().get("finishFlag"));
		Task task = new Task();
		task.setName(newTaskName);
		task.setProject_id(projectId);
		task.setFinish_flag(finishFlag);
		try {
			task.save();
		}catch(Exception e) {
			e.printStackTrace();
		}
		task.setId(SqlUtil.getNewTaskId());				// 最新タスクのidを取得
		ObjectMapper mapper = new ObjectMapper();
	    String json ="";
	    
		try {
			json = mapper.writeValueAsString(task);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return ok(json);
	}
	
	private TaskRequest getTaskRequest(Task task) {
		TaskRequest taskRequest = new TaskRequest();
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd");
		taskRequest.setId(task.getId());
		taskRequest.setProject_id(task.getProject_id());
		taskRequest.setName(task.getName());
		taskRequest.setExplanation(task.getExplanation());
		
		try {
			taskRequest.setStart_date((String)fmt.format(task.getStart_date()));		// formatを指定
			taskRequest.setClosing_date((String)fmt.format(task.getClosing_date()));	// formatを指定
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		taskRequest.setStaff_id(task.getStaff_id());
		taskRequest.setCategory_id(task.getCategory_id());
		taskRequest.setFinish_flag(task.getFinish_flag());
		return taskRequest;
	}
	
}
