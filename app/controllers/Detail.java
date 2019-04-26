package controllers;

import java.util.List;

import models.entity.Project;
import models.entity.Task;
import models.request.ProjectRequest;
import play.mvc.Controller;
import play.mvc.Result;

public class Detail extends Controller{

	// ID別にプロジェクトの詳細画面を表示
	public Result project(Long id) {
    	//Form<Project> form = new Form(Project.class).bindFromRequest();//送信されたフォームの値をバインド(割当て)したFormインスタンスを返す。
		
		// プロジェクト情報を取得
		Project project = Project.find.byId(id);
		System.out.println("pro_id"+project.getId());
		// プロジェクトIDからタスク情報を取得
		List<Task> taskList = Task.find.where().eq("project_id",project.getId()).findList();
		
		// プロジェクト情報をセット
		ProjectRequest projectRequest = new ProjectRequest();
		projectRequest.setId(project.getId());
		projectRequest.setName(project.getName());
		projectRequest.setExplanation(project.getExplanation());
		
		return ok(views.html.detail.detailProject.render(projectRequest,taskList));
	}
	
}
