package com.controller;

import com.bean.DosingGuideline;
import com.bean.Drug;
import com.bean.DrugLabel;
import com.bean.Sample;
import com.dao.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {

    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    private DrugDao drugDao = new DrugDao();
    private DrugLabelDao drugLabelDao = new DrugLabelDao();
    private DosingGuidelineDao dosingGuidelineDao = new DosingGuidelineDao();
    private SampleDao sampleDao = new SampleDao();
    private AnnovarDao annovarDao = new AnnovarDao();
    private String name;

    @RequestMapping(value= "/error", method = RequestMethod.GET)
    public String printError(ModelMap model){
        model.remove("message");
        model.addAttribute("message","Incorrect username or password!");
        return "login";
    }
    @RequestMapping(value = "/index")
    public String login (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model){
        name = httpServletRequest.getParameter("name");
        model.remove("message");
        model.addAttribute("message","Welcome to use Precision Medicine Matching System, " + name + "!");
        return "index";
    }
    @RequestMapping(value = "/register")
    public String register (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, ModelMap model){
        name = httpServletRequest.getParameter("name");
        String key = httpServletRequest.getParameter("key");
        model.remove("message");
        model.addAttribute("message","Successfully registered!</br>Welcome to use Precision Medicine Matching System, " + name + "!");
        return"index";
    }
    @RequestMapping(value = "/continue")
    public String Continue(ModelMap model){
        model.remove("message");
        model.addAttribute("message","Welcome to use Precision Medicine Matching System!");
        return"index";
    }
    @RequestMapping(value = "/drug")
    public String drug(HttpServletRequest request){
        List<Drug> drugs = drugDao.findAll();
        request.setAttribute("drugs", drugs);
        return "drug";
    }
    @RequestMapping(value = "/dosage")
    public String dosage(HttpServletRequest request){
        List<DosingGuideline> dosingGuidelines = dosingGuidelineDao.findAll();
        request.setAttribute("dosingGuidelines", dosingGuidelines);
        return "dosage";
    }
    @RequestMapping(value = "/druglabel")
    public String druglabel(HttpServletRequest request){
        List<DrugLabel> drugs = drugLabelDao.findAll();
        request.setAttribute("drugLabels", drugs);
        return "druglabel";
    }
    @RequestMapping(value = "/record")
    public String record(HttpServletRequest request){
        List<Sample> samples = sampleDao.findAll();
        request.setAttribute("samples", samples);
        return "record";
    }
    @RequestMapping(value="/match")
    public String match(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String sampleIdParameter = request.getParameter("sampleId");
        if (sampleIdParameter == null) {
            return "record";
        }
        Integer sampleId = null;
        try {
            sampleId = Integer.valueOf(sampleIdParameter);
        } catch (NumberFormatException e) {
            return "record";
        }
        List<String> refGenes = annovarDao.getRefGenes(sampleId);
        if (refGenes.isEmpty()) {
            return "record";
        }
        List<DrugLabel> drugLabels = drugLabelDao.findAll();
        List<DrugLabel> matched = doMatch(refGenes, drugLabels);
        request.setAttribute("matched", matched);
        request.setAttribute("sample", sampleDao.findById(sampleId));
        return "match_result";
    }

    private List<DrugLabel> doMatch(List<String> refGenes, List<DrugLabel> drugLabels) {
        List<DrugLabel> matchedLabels = new ArrayList<>();
        for (DrugLabel drugLabel : drugLabels) {
            boolean matched = false;
            for (String gene: refGenes) {
                if (drugLabel.getSummaryMarkdown().contains(gene)) {
                    matched = true;
                }
            }
            if (matched) {
                matchedLabels.add(drugLabel);
            }
        }
        return matchedLabels;
    }
    @RequestMapping(value="/upload")
    public String upload(HttpServletRequest request, HttpServletResponse response, ModelMap model) throws IOException, ServletException {
        Part requestPart = request.getPart("annovar");
        if (requestPart == null) {
            model.remove("message");
            model.addAttribute("message","annovar output file can not be blank");
            return "match";
        }
        InputStream inputStream = requestPart.getInputStream();
        byte[] bytes = inputStream.readAllBytes();
        String content = new String(bytes);
        int sampleId = sampleDao.save(name);
        try {
            annovarDao.save(sampleId, content);
        } catch (ArrayIndexOutOfBoundsException e) {
            model.remove("message");
            model.addAttribute("message","annovar output file can not be blank");
            return "match";
        }
        model.remove("message");
        model.addAttribute("message","successfully submit the file");
        return "match";
    }
}
