package constants;

public enum RegistrationContent {
    CODE_CONTENT("git config --global user.name  \"New Sheriff in Town\"\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\ngit push origin master --force"),
    FORMAT("Bash"),
    EXPIRATION("10 Minutes"),
    PASTE_NAME("how to gain dominance among developers");

    private String regContent;

    RegistrationContent(String regContent) {
        this.regContent = regContent;
    }

    public String getRegContent() {
        return regContent;
    }
}
