package practice;

public class Member implements BandComponent{
	private String name;
	private String mbti;
	private String position;
	private int energyLevel;

	public Member(String name, String mbti, String position, int energyLevel) {
		this.name = name;
		this.mbti = mbti;
		this.position = position;
		this.energyLevel = energyLevel;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void perform() {
		if (this.energyLevel < 30) {
			System.out.println("😧 [" + this.mbti + "] " + this.name + ": 너무 지쳐서 공연을 못 하겠어요...");
		} else {
			switch (this.mbti) {
				case "ENFP":
					System.out.println("🔥 [ENFP] " + this.name + ": 여러분 안녕!! 불태워볼까요?");
					break;
				case "ISTJ":
					System.out.println("🧊 [ISTJ] " + this.name + ": 공연 시작합니다.");
					break;
				case "ISFP":
					System.out.println("🌙 [ISFP] " + this.name + ": 조용히 시작해볼게요.");
					break;
				case "INTP":
					System.out.println("🧠 [INTP] " + this.name + ": 이 곡은 구조적으로 매우 완벽합니다.");
					break;
				case "ESFJ":
					System.out.println("💕 [ESFJ] " + this.name + ": 다들 잘 지냈죠? 오늘도 힘내요!");
					break;
				default:
					System.out.println("🎶 [기타] " + this.name + ": 준비됐어요!");
			}
		}
	}

	@Override
	public void printStructure(String prefix) {
		System.out.println("|- 🎸 " + this.position  + " - " + this.name + " - (" + this.mbti + ")");
	}
}
