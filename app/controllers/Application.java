package controllers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.google.inject.Inject;

import models.SampleForm;
import models.entity.Project;
import models.form.NewProjectForm;
import models.request.ProjectRequest;
import play.data.Form;
import play.i18n.Messages;
import play.mvc.Controller;
import play.mvc.Result;
import utils.CommonUtil;


public class Application extends Controller {

	private Form<SampleForm> form;
	
	//コンストラクタでフォームを生成
    @Inject
    public Application() {
        this.form = Form.form(SampleForm.class);
    }
	
    //ルート(/)にアクセスしたときに呼び出される
    public Result index() {
        // まだ終わってない(finish_flag=0)プロジェクトを取得
        List<ProjectRequest> projectRequestList = getProject();
        
        return ok(views.html.index.render("何か書いて",form,projectRequestList));
        //ここのindexとはindex.scala.html(テンプレート)のオブジェクトのこと。
        //「views」内のテンプレートファイルもScalaを利用したテンプレートエンジンを使って記述されており、
        //ビルド時(activator run時に最新の状態にビルドし直した上で実行される)にコンパイルされ、Javaのクラスとして生成される
        //okメソッドはResultインスタンスを返す。
        //「render」は引数を渡してwebページのテンプレートをレンダリングする。Htmlクラスのインスタンス＝Contentを返り値として取得
    }



    public Result send() {
    	//Form<SampleForm> userForm = formFactory.form(SampleForm.class);
    	Form<SampleForm> f = form.bindFromRequest();//送信されたフォームの値をバインド(割当て)したFormインスタンスを返す。
        // まだ終わってない(finish_flag=0)プロジェクトを取得
        List<ProjectRequest> projectRequestList = getProject();
        if(!f.hasErrors()) {
	    	SampleForm formData = f.get();
	    	String msg = "you typed: " + formData.getMessage();
	    	return ok(views.html.index.render(msg,f,projectRequestList));
	    }else{
	    	return badRequest(views.html.index.render("ERROR", form,projectRequestList));
	    }
    }
    
    public Result createdProject() {
    	String msg ="";
		String finishFlag = "";
    	Form<NewProjectForm> f = Form.form(NewProjectForm.class).bindFromRequest();//送信されたフォームの値をバインド(割当て)したFormインスタンスを返す。
    	if(f.hasErrors()) {
    		System.out.println("11");
	    	return badRequest(views.html.create.newProject.render("ERROR", f));
	    }
    	String name 		 = f.get().getProjectName();
    	String explanation 	 = f.get().getExplanation();
		Date closingDate 	 = f.get().getClosingDate();
		Double progressMeter = f.get().getProgressMeter();


		if(progressMeter!=100.0) {
			finishFlag	= CommonUtil.FINISH_FLAG_YET;
		}else {
			finishFlag = CommonUtil.FINISH_FLAG_AlREADY;
		}
		Project project = new Project();
		project.setName(name);
		project.setExplanation(explanation);
		project.setClosing_date(closingDate);
		project.setProgressMeter(progressMeter);
		project.setFinishFlag(finishFlag);
		
		try {
			project.save();
	    	msg = Messages.get("project.create.succeed");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
	    	msg = Messages.get("project.create.failure");
		}
		
        // まだ終わってない(finish_flag=0)プロジェクトを取得
        List<ProjectRequest> projectRequestList = getProject();
    	return ok(views.html.index.render(msg,form,projectRequestList));

    }
    
	public List<ProjectRequest> getProject() {
		List<Project> projectList = Project.find.where().eq("finish_flag", "0").findList();
        List<ProjectRequest> projectRequestList = new ArrayList<>();
        for(Project project: projectList) {
        	ProjectRequest projectRequest = new ProjectRequest();
        	projectRequest.setId(project.getId());
        	projectRequest.setName(project.getName());
        	Date closingDate = project.getClosing_date();

        	SimpleDateFormat sdf = new SimpleDateFormat(CommonUtil.DATE_PATTERN);
        	String dateStr = "";
        	try {
        		dateStr = sdf.format(closingDate);
        	}catch (Exception e) {
				// TODO: handle exception
			}
        	projectRequest.setDate(dateStr);
        	projectRequest.setProgressMeter(project.getProgressMeter());
        	projectRequestList.add(projectRequest);
        }
		return projectRequestList;
	}
}
