package steps;

import dto.Case;
import pages.CaseModal;
import pages.ProjectPage;

public class CaseSteps {

    ProjectPage projectPage;
    CaseModal caseModal;

    public CaseSteps() {
        projectPage = new ProjectPage();
        caseModal = new CaseModal();
    }

    public void createCase(Case aCase) {
        projectPage.clickCase()
                .isPageOpened()
                .create(aCase)
                .save()
                .isPageOpened();
    }
}
