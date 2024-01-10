import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TSharkDataTest {

    private TSharkData data;

    @Before
    public void setUp(){
    }

    @Test
    public void getFrameNumber() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Frame Number", "8", data.getFrameNumber());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Frame Number - Line 5", "5", data.getFrameNumber());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Frame Number - Line 6", "6", data.getFrameNumber());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Frame Number - Line 9", "9", data.getFrameNumber());
    }

    @Test
    public void getFrameTime() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Frame Time - Line 8", "1.774700000", data.getFrameTime());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Frame Time - Line 5", "1.436394000", data.getFrameTime());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Frame Time - Line 6", "1.536100000", data.getFrameTime());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Frame Time - Line 9", "1.779635000", data.getFrameTime());
    }

    @Test
    public void getProtocol() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Protocol - Line 8", "TCP", data.getProtocol());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Protocol - Line 5", "UDP", data.getProtocol());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Protocol - Line 6", "ARP", data.getProtocol());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Protocol - Line 9", "DNS", data.getProtocol());
    }

    @Test
    public void getProtocolID() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Protocol ID - Line 8", "6", data.getProtocolID());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Protocol ID - Line 5", "17", data.getProtocolID());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Protocol ID - Line 6", "", data.getProtocolID());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Protocol ID - Line 9", "17", data.getProtocolID());
    }

    @Test
    public void getSrcIP() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Source IP - Line 8", "192.168.68.126", data.getSrcIP());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Source IP - Line 5", "192.168.68.105", data.getSrcIP());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Source IP - Line 6", "", data.getSrcIP());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Source IP - Line 9", "192.168.68.126", data.getSrcIP());
    }

    @Test
    public void getSrcPort() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Source Port", "52.114.159.112", data.getSrcPort());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\",,");
        assertEquals("Source Port", "192.168.68.255", data.getSrcPort());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",,,,,,,");
        assertEquals("Source Port", "", data.getSrcPort());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\",,");
        assertEquals("Source Port", "71.10.216.1", data.getSrcPort());
    }

    @Test
    public void getDstIP() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Destination IP - Line 8", "55358", data.getDstIP());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Destination IP - Line 5", "", data.getDstIP());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Destination IP - Line 6", "", data.getDstIP());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Destination IP - Line 9", "", data.getDstIP());
    }

    @Test
    public void getDstPort() {
        data = new TSharkData("\"8\",\"1.774700000\",\"TCP\",\"6\",\"192.168.68.126\",\"52.114.159.112\",\"55358\",\"443\",,");
        assertEquals("Destination Port - Line 8", "443", data.getDstPort());

        data = new TSharkData("\"5\",\"1.436394000\",\"UDP\",\"17\",\"192.168.68.105\",\"192.168.68.255\",,,\"889\",\"889\"");
        assertEquals("Destination Port - Line 5", "", data.getDstPort());

        data = new TSharkData("\"6\",\"1.536100000\",\"ARP\",\",,,,,,\"");
        assertEquals("Destination Port - Line 6", "", data.getDstPort());

        data = new TSharkData("\"9\",\"1.779635000\",\"DNS\",\"17\",\"192.168.68.126\",\"71.10.216.1\",,,\"60389\",\"53\"");
        assertEquals("Destination Port - Line 9", "", data.getDstPort());
    }
}
