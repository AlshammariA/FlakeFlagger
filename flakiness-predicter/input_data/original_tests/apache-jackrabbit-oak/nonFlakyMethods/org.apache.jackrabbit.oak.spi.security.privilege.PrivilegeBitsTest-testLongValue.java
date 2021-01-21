@Test public void testLongValue(){
  assertEquals(NO_PRIVILEGE,getLongValue(PrivilegeBits.EMPTY));
  for (  long l : LONGS) {
    PrivilegeBits bits=PrivilegeBits.getInstance(createPropertyState(l));
    assertEquals(l,getLongValue(bits));
  }
  PrivilegeBits pb=READ_NODES_PRIVILEGE_BITS;
  long l=getLongValue(pb);
  while (l < Long.MAX_VALUE / 2) {
    l=l << 1;
    pb=pb.nextBits();
    assertEquals(l,getLongValue(pb));
  }
  for (int i=0; i < 10; i++) {
    pb=pb.nextBits();
    assertEquals(0,getLongValue(pb));
  }
  pb=READ_NODES_PRIVILEGE_BITS;
  for (int i=0; i < 100; i++) {
    PrivilegeBits modifiable=PrivilegeBits.getInstance(pb);
    assertEquals(getLongValue(pb),getLongValue(modifiable));
    pb=pb.nextBits();
  }
}
