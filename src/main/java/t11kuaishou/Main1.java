package t11kuaishou;

import java.util.*;

public class Main1 {

    private static List<Character> two = Arrays.asList(
            'a', 'b', 'c'
    );
    private static List<Character> three = Arrays.asList(
            'd', 'e', 'f'
    );
    private static List<Character> four = Arrays.asList(
            'g', 'h', 'i'
    );
    private static List<Character> five = Arrays.asList(
            'j', 'k', 'l'
    );
    private static List<Character> six = Arrays.asList(
            'm', 'n', 'o'
    );
    private static List<Character> seven = Arrays.asList(
            'p', 'q', 'r', 's'
    );
    private static List<Character> eight = Arrays.asList(
            't', 'u', 'v'
    );
    private static List<Character> nine = Arrays.asList(
            'w', 'x', 'y', 'z'
    );
    private static List<String> list = new ArrayList<>();
    private static HashMap<Character, List<Character>> map = new HashMap<>();


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String replace = s.replaceAll("1", "");
        char[] chars = replace.toCharArray();
        for (char i = '2'; i <= '9'; i++) {
            List<Character> value = new ArrayList<>();
            switch (i) {
                case '2':
                    value = two;
                    break;
                case '3':
                    value = three;
                    break;
                case '4':
                    value = four;
                    break;
                case '5':
                    value = five;
                    break;
                case '6':
                    value = six;
                    break;
                case '7':
                    value = seven;
                    break;
                case '8':
                    value = eight;
                    break;
                case '9':
                    value = nine;
                    break;
                default:
                    break;
            }
            map.put(i, value);
        }

        process(chars, 0, new StringBuilder());
        System.out.println(list);

    }

    static void process(char[] chars, int i, StringBuilder stringBuilder) {

        if (i == chars.length) {
            list.add(stringBuilder.toString());
            return;
        }
        char aChar = chars[i];
        List<Character> characters = map.get(aChar);
        for (int j = 0; j < characters.size(); j++) {
            stringBuilder.append(characters.get(j));
            process(chars, i + 1, stringBuilder);
            stringBuilder.deleteCharAt(i);
        }
    }
}
