@Test public void testGetInstance(){
  PrivilegeBits pb=PrivilegeBits.getInstance();
  assertEquivalent(PrivilegeBits.EMPTY,pb);
  assertNotSame(PrivilegeBits.EMPTY,pb);
  assertNotSame(pb,pb.unmodifiable());
  pb.add(READ_NODES_PRIVILEGE_BITS);
  pb.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
  pb.diff(READ_NODES_PRIVILEGE_BITS);
  pb=PrivilegeBits.getInstance(PrivilegeBits.EMPTY);
  assertEquivalent(PrivilegeBits.EMPTY,pb);
  assertNotSame(PrivilegeBits.EMPTY,pb);
  assertNotSame(pb,pb.unmodifiable());
  pb.add(READ_NODES_PRIVILEGE_BITS);
  pb.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
  pb.diff(READ_NODES_PRIVILEGE_BITS);
  pb=PrivilegeBits.getInstance(READ_NODES_PRIVILEGE_BITS);
  assertEquivalent(READ_NODES_PRIVILEGE_BITS,pb);
  assertNotSame(READ_NODES_PRIVILEGE_BITS,pb);
  assertNotSame(pb,pb.unmodifiable());
  pb.add(READ_NODES_PRIVILEGE_BITS);
  pb.addDifference(READ_NODES_PRIVILEGE_BITS,PrivilegeBits.EMPTY);
  pb.diff(READ_NODES_PRIVILEGE_BITS);
  pb=PrivilegeBits.EMPTY;
  assertEquivalent(pb,PrivilegeBits.EMPTY);
  assertSame(pb,PrivilegeBits.EMPTY);
  assertSame(pb,pb.unmodifiable());
  try {
    pb.add(READ_NODES_PRIVILEGE_BITS);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    pb.addDifference(READ_NODES_PRIVILEGE_BITS,READ_NODES_PRIVILEGE_BITS);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
  try {
    pb.diff(READ_NODES_PRIVILEGE_BITS);
    fail("UnsupportedOperation expected");
  }
 catch (  UnsupportedOperationException e) {
  }
}
