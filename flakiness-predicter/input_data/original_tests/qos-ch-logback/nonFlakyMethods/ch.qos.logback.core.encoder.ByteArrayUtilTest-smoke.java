@Test public void smoke(){
  verifyLoop(byteArray,0,0);
  verifyLoop(byteArray,0,10);
  verifyLoop(byteArray,0,Integer.MAX_VALUE);
  verifyLoop(byteArray,0,Integer.MIN_VALUE);
}
