@Test public void testAppendModeInfo(){
  BitArray bits=new BitArray();
  Encoder.appendModeInfo(Mode.NUMERIC,bits);
  assertEquals(" ...X",bits.toString());
}
