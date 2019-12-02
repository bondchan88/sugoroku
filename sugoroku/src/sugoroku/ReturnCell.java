package sugoroku;

public class ReturnCell extends Cell {

	private int amount;

	public ReturnCell() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public ReturnCell( int amount) {
		this.amount = amount;
	}
	@Override
	public Boolean doEvent(Coma coma) {
		System.out.println("-----------戻るも地獄、行くも地獄　ほーっほっほっほっほ没収じゃ--------------");
		coma.proceed(-amount);
		return true;
	}

	@Override
	public String getCaption() {
		return "~　・・・ ~　・・・　~　・・・ ~　三途の川にさしかかった、溺れるか、痛いか、かゆいか　どうしたいよ　おぬし~　・・・ ~　・・・　~　・・・ ~";
	}

}
