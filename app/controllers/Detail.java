package controllers;

import models.SampleForm;
import models.entity.Project;
import models.request.ProjectRequest;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Detail extends Controller{

	// ID別にプロジェクトの詳細画面を表示
	public Result project(Long id) {
    	//Form<Project> form = new Form(Project.class).bindFromRequest();//送信されたフォームの値をバインド(割当て)したFormインスタンスを返す。
		Project project = Project.find.byId(id);
		//form = new Form<Project>(Project.class).fill(project);
		System.out.println(project);
		ProjectRequest projectRequest = new ProjectRequest();
		projectRequest.setId(project.getId());
		projectRequest.setName(project.getName());
		System.out.println(projectRequest.getId());
		projectRequest.setExplanation(project.getExplanation());
		System.out.println(projectRequest);
		return ok(views.html.detail.detailProject.render(projectRequest));
	}
	
}
