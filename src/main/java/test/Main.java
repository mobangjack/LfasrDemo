package test;

import com.iflytek.voicecloud.model.Message;

public class Main {
	
	public static void main(String[] args) throws Exception {
		final String propFile = "H:\\bj\\workspace\\prop.txt";
		final Prop prop = new Prop(propFile);
		final String appId = prop.get("appId");
		final String secretKey = prop.get("secretKey");
		final String voiceFile = "C:\\Users\\hcs\\Documents\\录音\\录音.m4a";
		long lastTime = System.currentTimeMillis();
		VoiceRecognizer voiceRecognizer = new VoiceRecognizer(appId, secretKey);
		Message uploadMessage = voiceRecognizer.upload(voiceFile);
		System.out.println("************* uploading **************");
		System.out.println(uploadMessage);
		while (uploadMessage.getOk() != 0) {
			Thread.sleep(2000);
			uploadMessage = voiceRecognizer.upload(voiceFile);
			if (uploadMessage.getOk() != 0) {
				System.out.println("************* uploading **************");
			} else {
				System.out.println("************* uploaded **************");
			}
			System.out.println(uploadMessage);
		}
		System.out.println("*************** time **************");
		System.out.println(System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
		Message resultMessage = voiceRecognizer.result(uploadMessage.getData());
		System.out.println("************* quering **************");
		System.out.println(resultMessage);
		while (resultMessage.getOk() != 0) {
			Thread.sleep(5000);
			resultMessage = voiceRecognizer.result(uploadMessage.getData());
			if (resultMessage.getOk() == 0) {
				System.out.println("************* result **************");
			} else {
				System.out.println("************* quering **************");
			}
			System.out.println(resultMessage);
		}
		System.out.println("*************** time **************");
		System.out.println(System.currentTimeMillis() - lastTime);
	}

}
