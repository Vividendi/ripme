package com.rarchives.ripme.tst.ripper.rippers;

import java.io.IOException;
import java.net.URL;

import com.rarchives.ripme.ripper.rippers.EightxxxRipper;

public class EightxxxRipperTest extends RippersTest {
    public void testEightxxxRip() throws IOException {
        EightxxxRipper ripper = new EightxxxRipper(new URL("https://8xxx.net/category/hentiny"));
        testRipper(ripper);
    }
}