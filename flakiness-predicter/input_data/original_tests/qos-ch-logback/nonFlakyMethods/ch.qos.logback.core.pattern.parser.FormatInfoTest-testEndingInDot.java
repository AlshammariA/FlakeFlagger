@Test public void testEndingInDot(){
  try {
    FormatInfo.valueOf("45.");
    fail("45. is not a valid format info string");
  }
 catch (  IllegalArgumentException iae) {
  }
}
