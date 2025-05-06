package week6;

/*모음 사전*/

class numdict {
    public int solution(String word) {
        int answer = 0;
        int[] weights = {781, 156, 31, 6, 1}; // 각 자리수의 가중치
        // 원리 생각하기!!!
        /*1번째 자리: 5⁴ + 5³ + 5² + 5¹ + 5⁰ = 781

        2번째 자리: 5³ + 5² + 5¹ + 5⁰ = 156

        3번째 자리: 5² + 5¹ + 5⁰ = 31

        4번째 자리: 5¹ + 5⁰ = 6

        5번째 자리: 5⁰ = 1*/
        String vowels = "AEIOU";

        for (int i = 0; i < word.length(); i++) {
            int index = vowels.indexOf(word.charAt(i));
            answer += weights[i] * index + 1;
        }

        return answer;
    }
}
