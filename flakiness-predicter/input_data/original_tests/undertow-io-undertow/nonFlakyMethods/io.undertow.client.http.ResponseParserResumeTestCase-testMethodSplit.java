@Test public void testMethodSplit(){
  byte[] in=DATA.getBytes();
  for (int i=0; i < in.length - 4; ++i) {
    try {
      testResume(i,in);
    }
 catch (    Throwable e) {
      throw new RuntimeException("Test failed at split " + i,e);
    }
  }
}
