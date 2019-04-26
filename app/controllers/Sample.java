package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class Sample extends Controller {
    public Result sample() {
        return ok(views.html.sample.sample.render("Hello World!!"));
    }
}
