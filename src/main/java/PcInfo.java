
import java.net.InetAddress;
import java.net.UnknownHostException;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.util.FormatUtil;

public class PcInfo {
    private SystemInfo sy;
    
    public PcInfo(){
        sy = new SystemInfo();
    }
    
    private String FormatarValor(long value){
        return FormatUtil.formatBytes(value);
    }
    
    private int getNumeroDeDiscos(){
        return sy.getHardware().getDiskStores().length;
    }
    
    private HWDiskStore[] getDiscos(){
        return sy.getHardware().getDiskStores();
    }
    
    public String getSistemaOperacional(){
        return sy.getOperatingSystem().toString();
    }
    
    public String getProcessador(){
        return sy.getHardware().getProcessor().getName();
    }
    
    public String getRam(){
        return FormatarValor(sy.getHardware().getMemory().getTotal());
    }
    
    public String[] getNomeDosDiscos(){
        String[] discos = new String[getNumeroDeDiscos()];
        for(int i = 0; i < getNumeroDeDiscos(); i++){
            discos[i] = getDiscos()[i].getName();
        }
        return discos;
    }
                
    public String[] getVelocidadeDosDiscos(){
        String[] discos = new String[getNumeroDeDiscos()];
        for(int i = 0; i < getNumeroDeDiscos(); i++){
            discos[0] = FormatarValor(getDiscos()[i].getTransferTime());
        }
        return discos;
    }
    
    public String[] getTamanhoDosDiscos(){
        String[] discos = new String[getNumeroDeDiscos()];
        for(int i = 0; i < getNumeroDeDiscos(); i++){
            discos[i] = FormatarValor(getDiscos()[i].getSize());
        }
        return discos;
    }
    
    public String getModeloDoComputador(){
        return sy.getHardware().getComputerSystem().getModel();
    }
    
    public String getNomeDoComputador(){
        return sy.getOperatingSystem().getNetworkParams().getHostName();
    }
    
    public String getEnderecoDeIpv4(){
        return sy.getOperatingSystem().getNetworkParams().getIpv4DefaultGateway();
    }
    
    public String getEnderecoDeIpv6(){
        return sy.getOperatingSystem().getNetworkParams().getIpv6DefaultGateway();
    }
}