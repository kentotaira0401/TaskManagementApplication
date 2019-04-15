package controllers;

import com.google.inject.Inject;

import models.SampleForm;
import models.form.NewProjectForm;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CreateNew extends Controller{

	   //ルート(/)にアクセスしたときに呼び出される
    public Result createNewProject() {
    	Form<NewProjectForm> form = Form.form(NewProjectForm.class);
        return ok(views.html.create.newProject.render("わはあ",form));

    }
}
