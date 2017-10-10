package vn.its.controller.app;

import vn.its.service.CategoryService;
import vn.its.service.QuestionService;
import vn.its.service.TagService;
import vn.its.service.UserService;
import vn.its.util.Const;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppHomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private TagService tagService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("topUsers", userService.findTopPoint(5));
        model.addAttribute("tags", tagService.findAllApp());
        model.addAttribute("newQuestions", questionService.findLast(1, Const.QUESTION_PER_PAGE));
        model.addAttribute("topViewsQuestions", questionService.findTopViews(1, Const.QUESTION_PER_PAGE));
        model.addAttribute("noAnswersQuestions", questionService.findNoAnswers(1, Const.QUESTION_PER_PAGE));
        return "home";
    }

    @GetMapping("/loadMoreNew")
    public ModelAndView loadMoreNew(@RequestParam("page") int page, Model model) {
        if (page != 1) {
            page = (page - 1) * Const.QUESTION_PER_PAGE + 1;
        }
        
        model.addAttribute("questions", questionService.findLast(page, Const.QUESTION_PER_PAGE));
        return new ModelAndView("questions_fragment");
    }

    @GetMapping("/loadMoreTopViews")
    public ModelAndView loadMoreTopViews(@RequestParam("page") int page, Model model) {
        if (page != 1) {
            page = (page - 1) * Const.QUESTION_PER_PAGE + 1;
        }
        
        model.addAttribute("questions", questionService.findTopViews(page, Const.QUESTION_PER_PAGE));
        return new ModelAndView("questions_fragment");
    }

    @GetMapping("/loadMoreNoAnswers")
    public ModelAndView loadMoreNoAnswers(@RequestParam("page") int page, Model model) {
        if (page != 1) {
            page = (page - 1) * Const.QUESTION_PER_PAGE + 1;
        }
        
        model.addAttribute("questions", questionService.findNoAnswers(page, Const.QUESTION_PER_PAGE));
        return new ModelAndView("questions_fragment");
    }
    
}