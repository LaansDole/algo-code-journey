package main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZigzagTest {
    @Test
    void toZigZag() {
    }

    @Test
    void convert() {
        assertAll(
                () -> assertEquals("PAHNAPLSIIGYIR", Zigzag.convert("PAYPALISHIRING", 3)),
                () -> assertEquals("hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxaml" +
                                "udfykgruowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdhi" +
                                "ixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuftsxdixtig" +
                                "sieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddbuotbbqcwivrfxjujjd" +
                                "dntgeiqvdgaijvwcyaubwewpjvygehljxepbpiwuqzdzubdubzvafspqpqwuzi" +
                                "fwovyddwyvvburczmgyjgfdxvtnunneslsplwuiupfxlzbknhkwppanltcfirj" +
                                "cddsozoyvegurfwcsfmoxeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnun" +
                                "yfdzrhbasjeuygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdir" +
                                "bfcriqifpgynkrxrfe",
                        Zigzag.convert(
                                "hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgr" +
                                        "uowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdh" +
                                        "iixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuf" +
                                        "tsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddb" +
                                        "uotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepb" +
                                        "piwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnu" +
                                        "nneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmo" +
                                        "xeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasje" +
                                        "uygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbf" +
                                        "criqifpgynkrrefx", 503))
        );
    }
}
