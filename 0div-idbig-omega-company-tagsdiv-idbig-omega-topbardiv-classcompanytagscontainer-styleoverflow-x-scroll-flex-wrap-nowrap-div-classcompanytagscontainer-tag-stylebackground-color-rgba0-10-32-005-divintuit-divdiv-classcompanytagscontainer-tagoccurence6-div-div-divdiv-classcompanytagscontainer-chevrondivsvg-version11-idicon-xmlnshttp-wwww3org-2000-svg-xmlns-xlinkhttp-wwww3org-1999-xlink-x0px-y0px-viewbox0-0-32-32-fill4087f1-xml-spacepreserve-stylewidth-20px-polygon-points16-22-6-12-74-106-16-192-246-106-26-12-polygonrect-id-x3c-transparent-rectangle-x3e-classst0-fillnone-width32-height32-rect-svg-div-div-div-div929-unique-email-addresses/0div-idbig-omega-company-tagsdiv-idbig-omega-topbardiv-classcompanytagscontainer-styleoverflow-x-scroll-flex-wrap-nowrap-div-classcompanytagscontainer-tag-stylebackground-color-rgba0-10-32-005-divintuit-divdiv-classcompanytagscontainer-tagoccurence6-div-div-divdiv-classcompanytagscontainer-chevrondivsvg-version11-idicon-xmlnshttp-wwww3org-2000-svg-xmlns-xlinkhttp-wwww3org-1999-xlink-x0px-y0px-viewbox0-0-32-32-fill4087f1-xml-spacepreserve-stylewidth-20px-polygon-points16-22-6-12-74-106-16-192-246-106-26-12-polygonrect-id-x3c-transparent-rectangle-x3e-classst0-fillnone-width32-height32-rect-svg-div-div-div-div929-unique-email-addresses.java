class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            int indexOfAt = email.indexOf('@');
            String front = email.substring(0, indexOfAt);
            int index = front.indexOf('+');
            if (index >= 0) {
                front = front.substring(0, index);
            }
            front = front.replaceAll("\\.", "");
            String finalString = front + email.substring(indexOfAt);
            set.add(finalString);
        }
        return set.size();
    }
}