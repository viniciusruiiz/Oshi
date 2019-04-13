import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
import oshi.util.FormatUtil;

public class PcInfo {
    private SystemInfo systemInfo;
    private HardwareAbstractionLayer hardware;
    private OperatingSystem operatingSystem;
    
    public PcInfo(){
        systemInfo = new SystemInfo();
        hardware = systemInfo.getHardware();
        operatingSystem = systemInfo.getOperatingSystem();
    }
    
    private String FormatarValor(long value){
        return FormatUtil.formatBytes(value);
    }
    
    private int getNumeroDeDiscos(){
        return hardware.getDiskStores().length;
    }
    
    private HWDiskStore[] getDiscos(){
        return hardware.getDiskStores();
    }
    
    public String getSistemaOperacional(){
        return operatingSystem.toString();
    }
    
    public String getProcessador(){
        return hardware.getProcessor().getName();
    }
    
    public String getRam(){
        return FormatarValor(hardware.getMemory().getTotal());
    }
    
    public String[] getNomeDosDiscos(){
        int numeroDeDiscos = getNumeroDeDiscos();
        String[] discos = new String[numeroDeDiscos];
        for(int i = 0; i < numeroDeDiscos; i++){
            discos[i] = getDiscos()[i].getName();
        }
        return discos;
    }
                
    public String[] getVelocidadeDosDiscos(){
        int numeroDeDiscos = getNumeroDeDiscos();
        String[] discos = new String[numeroDeDiscos];
        for(int i = 0; i < numeroDeDiscos; i++){
            discos[0] = FormatarValor(getDiscos()[i].getTransferTime());
        }
        return discos;
    }
    
    public String[] getTamanhoDosDiscos(){
        int numeroDeDiscos = getNumeroDeDiscos();
        String[] discos = new String[numeroDeDiscos];
        for(int i = 0; i < numeroDeDiscos; i++){
            discos[i] = FormatarValor(getDiscos()[i].getSize());
        }
        return discos;
    }
    
    public String getModeloDoComputador(){
        return systemInfo.getHardware().getComputerSystem().getModel();
    }
    
    public String getNomeDoComputador(){
        return systemInfo.getOperatingSystem().getNetworkParams().getHostName();
    }
    
    public String getEnderecoDeIpv4(){
        return systemInfo.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();
    }
    
    public String getEnderecoDeIpv6(){
        return systemInfo.getOperatingSystem().getNetworkParams().getIpv6DefaultGateway();
    }
}