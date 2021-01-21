@Test public void testGetInstanceFromPropertyState(){
  for (  long l : LONGS) {
    PropertyState property=createPropertyState(l);
    PrivilegeBits pb=PrivilegeBits.getInstance(property);
    assertEquivalent(pb,PrivilegeBits.getInstance(property));
    assertSame(pb,pb.unmodifiable());
    assertEquivalent(pb,PrivilegeBits.getInstance(pb));
    assertEquivalent(PrivilegeBits.getInstance(pb),pb);
    assertNotSame(pb,PrivilegeBits.getInstance(pb));
    try {
      pb.add(READ_NODES_PRIVILEGE_BITS);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    try {
      pb.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
    try {
      pb.diff(READ_NODES_PRIVILEGE_BITS);
      fail("UnsupportedOperation expected");
    }
 catch (    UnsupportedOperationException e) {
    }
  }
}
