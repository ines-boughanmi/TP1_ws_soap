package com.esen.service;

import org.springframework.stereotype.Service;
import com.esen.loaneligibility.xml.Acknowledgement;
import com.esen.loaneligibility.xml.CustomerRequest;
import java.util.List;

@Service
public class LoanEligibilityService {
    
    public Acknowledgement checkLoanEligibility(CustomerRequest request) {
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();
        
        // Vérification de l'âge (entre 30 et 60 ans)
        if (!(request.getAge() > 30 && request.getAge() <= 60)) {
            mismatchCriteriaList.add("L'âge doit être entre 30 et 60 ans");
        }
        
        // Vérification du revenu annuel (> 200000)
        if (!(request.getYearlyIncome() > 200000)) {
            mismatchCriteriaList.add("Le revenu minimum doit être supérieur à 200000");
        }
        
        // Vérification du score CIBIL (> 500)
        if (!(request.getCibilScore() > 500)) {
            mismatchCriteriaList.add("Score CIBIL faible, réessayez dans 6 mois");
        }
        
        // Si des critères ne sont pas satisfaits
        if (mismatchCriteriaList.size() > 0) {
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        } else {
            // Client éligible
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }
        
        return acknowledgement;
    }
}