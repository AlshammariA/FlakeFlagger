@Test public void testXOR(){
  BitArray v1=new BitArray();
  v1.appendBits(0x5555aaaa,32);
  BitArray v2=new BitArray();
  v2.appendBits(0xaaaa5555,32);
  v1.xor(v2);
  assertEquals(0xffffffffL,getUnsignedInt(v1,0));
}
