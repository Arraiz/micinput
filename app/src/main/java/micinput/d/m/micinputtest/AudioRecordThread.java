package micinput.d.m.micinputtest;

import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;

/**
 * Created by mikeldiez on 24/11/2017.
 */



public class AudioRecordThread {


    /***CONFIGURACION DEL MEDIA RECORDER*/
    /*la API dice
    AudioRecord(int audioSource, int sampleRateInHz, int channelConfig, int audioFormat, int bufferSizeInBytes)
    Class constructor. */

    /*Configuracion del MIC*/
    //samling freq
    private static final int  sampleRateHz = 44100;
    //mic input
    private static final int  source = MediaRecorder.AudioSource.MIC;
    private static final int  channelMono = AudioFormat.CHANNEL_IN_MONO;

    //codificacion PCM 16 bits
    private static final int  PCM_encoding = AudioFormat.ENCODING_PCM_16BIT;

    //tamaño del buffer optimo para leer/escribir datos
    private static final int  bufferSize = AudioRecord.getMinBufferSize(sampleRateHz, channelMono, PCM_encoding);
        /*el buffer size se usa para almacenar datos y luego escupilos y hace que la experiencia se mas
        * fluida
        * EJ: para un buffer de 1000bytes a 2bytes(16bitPCM)por sample tendremos
        * 500bytes de audio en en el buffer algo asi como 20ms*/

    AudioRecord record = new AudioRecord(source, sampleRateHz, channelMono, PCM_encoding, bufferSize);
    /************************************/

}
