package ch12.practice.p08;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WinnerAnnouncer {
    private Scanner sc = new Scanner(System.in);

    // 랜덤 멘트 후보
    private String[] comments = {
            "운명적인 만남! 👑",
            "불꽃 튀는 승부! 🔥",
            "눈부신 이상형입니다! ✨",
            "모두가 인정한 최강 이상형! 🏆",
            "세상에 이런 이상형이?! 🌟",
            "만장일치! 역대급 이상형 탄생! 🎉",
            "찢었다! 레전드 우승자! 💥",
            "마음 속 1픽, 오늘도 나의 선택은 당신! 💖",
            "심사위원장이 소름 돋았다네요… 🥶",
            "우승자의 미모에 심사위원장 쓰러짐 😵",
            "태어날 때부터 월드컵 우승자였던 사람 😎",
            "시작도 전에 결승전 확정된 이상형! 🚀",
            "치명적인 매력… 모두를 홀렸다! 🧲",
            "이건 신이 선택한 이상형입니다… 😇",
            "이상형 월드컵 역사상 최초! 완벽한 우승자! 🏅",
            "심사위원장: '솔직히 이 사람 나도 찍었다' 🫢",
            "상대팀 모두 GG 선언하고 퇴장 😭",
            "오늘부터 내 배경화면 예약 📱",
            "다음 시즌 결승 진출권 자동 확보 🤣",
            "사람인가, 조각인가… 🗿"
    };


    // 우승자 발표 메서드
    public void printWinnerSummary(Celebrity winner) {
        System.out.println("\n🏆최종 우승자: " + winner.getName());

        // 1. 랜덤 멘트 출력
        String comment = getRandomComment();
        System.out.println("\n✨오늘의 멘트: " + comment);

        // 2. 날짜 포맷 선택 -> 출력
        int formatChoice = getDateFormatChoice();
        String formattedDate = formatDate(formatChoice);
        System.out.println("\n📅 발표 날짜");
        System.out.println(formattedDate);

        // 3. 시스템 정보 출력
        printSystemInfo();
    }

    // 시스템 정보 출력 + 오름차순 정렬
    private void printSystemInfo() {
        System.out.println("\n💻 시스템 정보");

        Properties props = System.getProperties();
        List<String> keys = new ArrayList<>();

        // java.로 시작하는 키만 수집
        for (String key : props.stringPropertyNames()) {
            if (key.startsWith("java.")) {
                keys.add(key);
            }
        }

        // 오름차순 정렬
        Collections.sort(keys);

        // 출력
        for (String key : keys) {
            System.out.println(key + " = " + props.getProperty(key));
        }
    }

    // 선택한 포맷으로 날짜 변환
    private String formatDate(int choice) {
        Date now = new Date();
        if (choice == 1) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
            return sdf.format(now);
        } else if (choice == 2) {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
            return ldt.format(formatter);
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            return sdf.format(now);
        }
    }

    // 날짜 포맷 선택 받기
    private int getDateFormatChoice() {
        int choice;
        while (true) {
            System.out.println("날짜 포맷을 선택하세요:");
            System.out.println("1. yyyy년 MM일 dd일 HH시 mm분 ss초");
            System.out.println("2. yyyy-MM-dd'T'HH:mm:ss (ISO 포맷)");
            System.out.println("3. yyyy/MM/dd HH:mm:ss");
            System.out.print("선택: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    System.out.println("1 ~ 3 사이 숫자를 입력하세요!");
                }
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요!");
            }
        }
        return choice;
    }

    private String getRandomComment() {
        int index = (int) (Math.random() * comments.length);
        return comments[index];
    }


}
