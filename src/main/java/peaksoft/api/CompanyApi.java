package peaksoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.model.Company;
import peaksoft.service.CompanyService;

@Controller
@RequestMapping("/companies")
public class CompanyApi {
    private final CompanyService service;
    @Autowired
    public CompanyApi(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("companies",service.getAllCompanies());
        return "mainPage";
    }
    @GetMapping("/new")
    public String createCompany(Model model){
        model.addAttribute("newCompany",new Company());
        return "newCompany";
    }
    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany")Company company){
        service.save(company);
        return "redirect:/companies";
    }
}
