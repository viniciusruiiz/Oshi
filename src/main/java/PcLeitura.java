import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class PcLeitura {
    private SystemInfo systemInfo;
    private HardwareAbstractionLayer hardware;
    private OperatingSystem operatingSystem;

    public PcLeitura(){
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
        operatingSystem = systemInfo.getOperatingSystem();
    }

    private String FormatarValor(long value){
        return FormatUtil.formatBytes(value);
    }

    private int getNumeroDeParticoesDeDisco(){
        return operatingSystem.getFileSystem().getFileStores().length;
    }

    public double getProcessamento(){
        return hardware.getProcessor().getSystemCpuLoad(); //não bate exatamente com a do windowns, apesar de parecido
    }

    public long getRamDisponivel(){
        return hardware.getMemory().getAvailable();
    }

    public long getMemoriaDisponível() {
        int numeroDeParticoes = getNumeroDeParticoesDeDisco();
        long memoriaDisponivel = 0;
        for (int i = 0; i < numeroDeParticoes; i++) {
            memoriaDisponivel += operatingSystem.getFileSystem().getFileStores()[i].getUsableSpace();
        }
        return memoriaDisponivel;
    }

    public int getNumeroDeProcessosAtivos(){
        return operatingSystem.getProcessCount();
    }

    public long getUpTime(){
        return hardware.getProcessor().getSystemUptime();
    }

    /*
    //Não esta funcionando (retorna 0)
    public double getTemperaturaDoProcessador(){
        return hardware.getSensors().getCpuTemperature();
    }
    */

    @Override
    public String toString() {
        return "processo: " + (getProcessamento() * 100) +"%\nram: "+ FormatarValor(getRamDisponivel()) +"\narmazenamento: "+ FormatarValor(getMemoriaDisponível()) + "\nnumero de processos ativos: " + (getNumeroDeProcessosAtivos() + "\ntempo que o pc esta ligado: " + getUpTime() + " segundos\n");
    }
}
