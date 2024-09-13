package JavaFx;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class SoundUtil {

    /*
     * private static Clip clip;
     * 
     * public static void playSound(String soundFile) {
     * try {
     * // Cria um objeto File com o caminho absoluto do arquivo de som
     * File soundPath = new File(soundFile);
     * if (soundPath.exists()) {
     * // Obtém um fluxo de áudio do arquivo de som
     * AudioInputStream audioInputStream =
     * AudioSystem.getAudioInputStream(soundPath);
     * // Obtém um clip de áudio
     * clip = AudioSystem.getClip();
     * // Abre o clip com o fluxo de áudio
     * clip.open(audioInputStream);
     * // Reproduz o som
     * clip.start();
     * } else {
     * System.out.println("Can't find file: " + soundFile);
     * }
     * } catch (Exception ex) {
     * ex.printStackTrace();
     * }
     * }
     * 
     * public static void stopSound() {
     * clip.stop();
     * }
     */

    private static Clip clip;

    public static void playSound(String soundFileName) {
        try {
            // Obtém o arquivo de som como recurso a partir do classpath
            // Usa ClassLoader para acessar o arquivo dentro de src/resources
            var resource = SoundUtil.class.getResource("/JavaFx/audio/" + soundFileName);

            if (resource != null) {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(resource);
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
            } else {
                System.out.println("Arquivo de som não encontrado: " + soundFileName);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void stopSound() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

}