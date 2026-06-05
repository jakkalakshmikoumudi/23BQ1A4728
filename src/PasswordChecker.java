public class PasswordChecker {

    public static int calculateScore(String password) {

        int score = 0;

        // Length Check
        if(password.length() >= 8) {
            score += 2;
        }

        // Uppercase Check
        if(password.matches(".*[A-Z].*")) {
            score += 2;
        }

        // Lowercase Check
        if(password.matches(".*[a-z].*")) {
            score += 2;
        }

        // Number Check
        if(password.matches(".*[0-9].*")) {
            score += 2;
        }

        // Special Character Check
        if(password.matches(".*[@#$%^&+=!].*")) {
            score += 2;
        }

        return score;
    }

    public static String getStrength(int score) {

        if(score <= 4) {
            return "Weak";
        }
        else if(score <= 7) {
            return "Medium";
        }
        else {
            return "Strong";
        }
    }

    public static String getSuggestions(String password) {

        String suggestions = "";

        if(password.length() < 8) {
            suggestions += "- Increase password length\n";
        }

        if(!password.matches(".*[A-Z].*")) {
            suggestions += "- Add uppercase letters\n";
        }

        if(!password.matches(".*[a-z].*")) {
            suggestions += "- Add lowercase letters\n";
        }

        if(!password.matches(".*[0-9].*")) {
            suggestions += "- Add numbers\n";
        }

        if(!password.matches(".*[@#$%^&+=!].*")) {
            suggestions += "- Add special characters\n";
        }

        if(suggestions.equals("")) {
            suggestions = "Excellent Password!";
        }

        return suggestions;
    }
}
