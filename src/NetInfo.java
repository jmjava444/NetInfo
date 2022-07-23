import java.net.*;

public class NetInfo
{
    public static void main(String[] args) throws Exception
    {
        // Get IP address
        InetAddress ip;
        ip = InetAddress.getLocalHost();
        System.out.println("IP Address: " + ip.getHostAddress());
        NetworkInterface network = NetworkInterface.getByInetAddress(ip);

        // Get subnet mask
        InetAddress localHost = Inet4Address.getLocalHost();
        NetworkInterface networkInterface = NetworkInterface.getByInetAddress(localHost);
        System.out.println("Subnet Mask: " + networkInterface.getInterfaceAddresses().get(0).getNetworkPrefixLength());

        // Get MAC Address
        byte[] mac = network.getHardwareAddress();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < mac.length; i ++)
        {
            // Note to self! Remember it's like this: if(i < mac.length) do "-", else ""
            sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println("MAC Address: " + sb);
    }
}