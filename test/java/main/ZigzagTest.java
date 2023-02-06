package main;

import org.junit.jupiter.api.Test;

class ZigzagTest {
    @Test
    void toZigZag() {
    }

    @Test
    void convert() {
        Zigzag zigzag = new Zigzag();
        System.out.println(zigzag.convert("PAYPALISHIRING",3));
    }
    @Test
    void convert1() {
        Zigzag zigzag = new Zigzag();
        System.out.println(zigzag.convert(
                "hjouvsuyoypayulyeimuotehzriicfskpggkbbipzzrzucxamludfykgr" +
                        "uowzgiooobppleqlwphapjnadqhdcnvwdtxjbmyppphauxnspusgdh" +
                        "iixqmbfjxjcvudjsuyibyebmwsiqyoygyxymzevypzvjegebeocfuf" +
                        "tsxdixtigsieehkchzdflilrjqfnxztqrsvbspkyhsenbppkqtpddb" +
                        "uotbbqcwivrfxjujjddntgeiqvdgaijvwcyaubwewpjvygehljxepb" +
                        "piwuqzdzubdubzvafspqpqwuzifwovyddwyvvburczmgyjgfdxvtnu" +
                        "nneslsplwuiupfxlzbknhkwppanltcfirjcddsozoyvegurfwcsfmo" +
                        "xeqmrjowrghwlkobmeahkgccnaehhsveymqpxhlrnunyfdzrhbasje" +
                        "uygafoubutpnimuwfjqsjxvkqdorxxvrwctdsneogvbpkxlpgdirbf" +
                        "criqifpgynkrrefx",503));
    }
    @Test
    void convert2() {
        Zigzag zigzag = new Zigzag();
        System.out.println(zigzag.convert(
                "txkrsdyronxiisbacxkdczwdlevfughpftgxzhpnuoxegagixsnbujffpcmkivbpoimnrddnrcuzdakatxcnjjsangmxbomryahpekexmyzrzjsuiwjrfduujgrkuddsfkjjwqjjoiaptulbquvxxprgvksqnwktiwefmpqczsusnfufarfxgygbjatywgthcamqpcsrumjjufpuwwteubifcbeajzhnzvdrxyismtdgbscxqyclzksdnwgzypmxlsqisaceuglvapurnyepkwuavaztqnsbhjlzjoefurcwgznwxtliqfklileyywbihmhtanywebvnakjzewjudthlenlflontbumdimcopxbrhmrlkahqwqdafphrfumgrakzmmpclttshmgsnpilgllncteipqqgschfoxjbqcuzrcrerbrzpcnrxtbpmsveudjlcsmuxitoknueonfdpsxpmaeyubepgociiqehbyxlltrbgxfypepdevdzwiqdyungksqlqnzdjqepnlpfrekwzoxwynbwjqetiuhakidtykkoxavpefngvketzfpivudgqkgasmvtygjxiemmjzuhlyakfsudoyjekrhffcydkjbsnphyrdfcciphajkojvsunbzsezyqiblvquvjxbobjdjjovzyrruettyzswraxexqyszyvnzgsirjeqjxkdbfwzeqyxqxcpnchpafcclxkdgqtpndsqkqsqgqoynsnduwsxbwznvlsbensttmkdceukuiijaxowugtxfukageeksydllpontiansizuinrcwmbdhofnslzkkcvvsmknukdpvcjdrchppiuyyalrlmbxqzsilfyhpbwmdgrwiaozjixhikawwctndoxotvvkwsxbaoyipmiaufjfqmdooybtmzhfwestwpuwfuhwi",
                926));
    }
}