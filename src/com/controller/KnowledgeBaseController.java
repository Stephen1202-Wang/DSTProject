package com.controller;

import com.bean.DosingGuideline;
import com.bean.Drug;
import com.bean.DrugLabel;
import com.dao.DosingGuidelineDao;
import com.dao.DrugDao;
import com.dao.DrugLabelDao;
import com.servlet.DispatchServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class KnowledgeBaseController {

    private static final Logger log = LoggerFactory.getLogger(KnowledgeBaseController.class);

    private DrugDao drugDao = new DrugDao();
    private DrugLabelDao drugLabelDao = new DrugLabelDao();
    private DosingGuidelineDao dosingGuidelineDao = new DosingGuidelineDao();

    public void register(DispatchServlet.Dispatcher dispatcher) {
        dispatcher.registerGetMapping("/drugs", this::drugs);
        dispatcher.registerGetMapping("/drugLabels", this::drugLabels);
        dispatcher.registerGetMapping("/dosingGuideline", this::dosingGuideline);
    }

    public void drugs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Drug> drugs = drugDao.findAll();
        request.setAttribute("drugs", drugs);
        request.getRequestDispatcher("/views/drugs.jsp").forward(request, response);
    }

    public void drugLabels(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DrugLabel> drugs = drugLabelDao.findAll();
        request.setAttribute("drugLabels", drugs);
        request.getRequestDispatcher("/views/drug_labels.jsp").forward(request, response);
    }

    public void dosingGuideline(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<DosingGuideline> dosingGuidelines = dosingGuidelineDao.findAll();
        request.setAttribute("dosingGuidelines", dosingGuidelines);
        request.getRequestDispatcher("/views/dosing_guideline.jsp").forward(request, response);
    }
}
