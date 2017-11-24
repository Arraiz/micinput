package micinput.d.m.micinputtest;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Process;

/**
 * Created by mikeldiez on 24/11/2017.
 */


public class AudioRecordThread implements Runnable {


    /***CONFIGURACION DEL MEDIA RECORDER*/
    /*la API dice
    AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes)
    Class constructor. */

    /*configuracion del hilo de grabacion*/
    public static final int THREAD_PRIORITY_FOR_AUDIO = Process.THREAD_PRIORITY_AUDIO;


    /*Configuracion del MIC*/
    //samling freq
    private static final int sampleRateHz = 44100;
    //mic input
    private static final int source = MediaRecorder.AudioSource.MIC;
    private static final int channelMono = AudioFormat.CHANNEL_IN_MONO;

    //codificacion PCM 16 bits
    private static final int PCM_encoding = AudioFormat.ENCODING_PCM_16BIT;

    //tamaño del buffer optimo para leer/escribir datos
    private static final int bufferSize = AudioRecord.getMinBufferSize(sampleRateHz, channelMono, PCM_encoding);
        /*el buffer size se usa para almacenar datos y luego escupilos y hace que la experiencia se mas
        * fluida
        * EJ: para un buffer de 1000bytes a 2bytes(16bitPCM)por sample tendremos
        * 500bytes de audio en en el buffer algo asi como 20ms*/

    AudioRecord record = new AudioRecord(source, sampleRateHz, channelMono, PCM_encoding, bufferSize);


    /************************************/


    /*HILO DE GRABACION*/
    @Override
    public void run() {
        //configuramos el hilo para que sea un hilo de audio que no es tan agresivo como otros
        android.os.Process.setThreadPriority(THREAD_PRIORITY_FOR_AUDIO);
    }


}
