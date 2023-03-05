public enum StudyProfile {

    MEDICINE("Медицина"), PHYSICS ("Физика"), ENGINEER ("Инженер"), DESIGNER ("Конструктор");


    private String profileName;

    StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
