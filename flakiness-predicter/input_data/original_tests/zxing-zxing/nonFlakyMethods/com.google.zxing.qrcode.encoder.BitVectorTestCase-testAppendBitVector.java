@Test public void testAppendBitVector(){
  BitArray v1=new BitArray();
  v1.appendBits(0xbe,8);
  BitArray v2=new BitArray();
  v2.appendBits(0xef,8);
  v1.appendBitArray(v2);
  assertEquals(" X.XXXXX. XXX.XXXX",v1.toString());
}
