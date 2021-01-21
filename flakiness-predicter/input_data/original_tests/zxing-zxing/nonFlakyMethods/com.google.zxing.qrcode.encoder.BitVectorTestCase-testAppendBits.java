@Test public void testAppendBits(){
  BitArray v=new BitArray();
  v.appendBits(0x1,1);
  assertEquals(1,v.getSize());
  assertEquals(0x80000000L,getUnsignedInt(v,0));
  v=new BitArray();
  v.appendBits(0xff,8);
  assertEquals(8,v.getSize());
  assertEquals(0xff000000L,getUnsignedInt(v,0));
  v=new BitArray();
  v.appendBits(0xff7,12);
  assertEquals(12,v.getSize());
  assertEquals(0xff700000L,getUnsignedInt(v,0));
}
