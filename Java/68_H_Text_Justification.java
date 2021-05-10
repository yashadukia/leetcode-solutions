class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        int i = 0;
        
        List<String> res = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        int space_count = 0;
        int line_len = 0;
        List<String> temp = new ArrayList<>();
        
        while (i < words.length)
        {
            int word_space = line_len + space_count;
            // We already have "word_space". need "word_space + new word" < maxWidth to continue
            if (word_space < maxWidth && word_space + words[i].length() <= maxWidth)
            {
                // Store the line_len without spaces
                line_len += words[i].length();
                // Store words in temp array
                temp.add(words[i]);
                
                // For space - keep a count of spaces
                if (word_space < maxWidth)
                    space_count++;
                
                // Last Line
                if (i == words.length - 1)
                {
                    for (String part: temp)
                    {
                        sb.append(part);
                        
                        if (sb.length() < maxWidth)
                            sb.append(" ");
                    }
                    int spaces_balance = maxWidth - sb.length();
                    for (int space = 0; space < spaces_balance; space++)
                        sb.append(" ");
                    res.add(sb.toString());
                }
            }
            else
            {
                // How many spaces are needed
                int space_padding_needed = maxWidth - line_len;
                
                // Think ["What","must","be","acknowledgment","shall","be"]
                // "acknowledgment" is one word in the whole line. so temp.size() - 1 will be 0
                // giving divide by 0 error. So need to do this separately
                if (temp.size() == 1)
                {
                    sb.append(temp.get(0));
                    for (int space = 0; space < space_padding_needed; space++)
                        sb.append(" ");
                }
                else
                {
                    // How many min spaces between each word
                    int equal_for_all = space_padding_needed / (temp.size() - 1);
                    // Distribute extra spaces from the beginning of line
                    int remaining_spaces = space_padding_needed % (temp.size() - 1);
                    // Store the distributed spaces in an array
                    int[] spaces = new int[temp.size() - 1];
                    // Fill it with min spaces between words
                    Arrays.fill(spaces, equal_for_all);

                    // Fill the array with distributed spaces
                    int j = 0;
                    while (remaining_spaces > 0)
                    {
                        spaces[j++] += 1;
                        remaining_spaces--;
                    }

                    // Finally add the words to "sb" and add spaces according to array above
                    for (int k = 0; k < temp.size(); k++)
                    {
                        sb.append(temp.get(k));

                        if (k < temp.size() - 1)
                            for (int space = 0; space < spaces[k]; space++)
                                sb.append(" ");
                    }
                }
                // Add the "sb" to res
                res.add(sb.toString());
                
                // Reset all values
                sb = new StringBuilder();
                space_count = 0;
                line_len = 0;
                temp = new ArrayList<>();
                
                // Need this as we're already on the next word. Need to go one back so the current word if picked up next iteration.
                // Think ["This", "is", "an", "example", "of", "text", "justification."]
                // <This  is  an> makes a line but we get to "else" when i is at "example" so we gotta go back
                i--;
            }
            i++;
        }
        return res;
    }
}