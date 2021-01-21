@Test public void testTerminateBits() throws WriterException {
  BitArray v=new BitArray();
  Encoder.terminateBits(0,v);
  assertEquals("",v.toString());
  v=new BitArray();
  Encoder.terminateBits(1,v);
  assertEquals(" ........",v.toString());
  v=new BitArray();
  v.appendBits(0,3);
  Encoder.terminateBits(1,v);
  assertEquals(" ........",v.toString());
  v=new BitArray();
  v.appendBits(0,5);
  Encoder.terminateBits(1,v);
  assertEquals(" ........",v.toString());
  v=new BitArray();
  v.appendBits(0,8);
  Encoder.terminateBits(1,v);
  assertEquals(" ........",v.toString());
  v=new BitArray();
  Encoder.terminateBits(2,v);
  assertEquals(" ........ XXX.XX..",v.toString());
  v=new BitArray();
  v.appendBits(0,1);
  Encoder.terminateBits(3,v);
  assertEquals(" ........ XXX.XX.. ...X...X",v.toString());
}
