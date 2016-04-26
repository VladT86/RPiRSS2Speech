public class tts {

	public tts(String text){
		try {
			Process p = new ProcessBuilder("./fspeak", text).start();
			p.waitFor();
		} catch (Exception e){
			System.out.println(e);
		}
	}
	
}
