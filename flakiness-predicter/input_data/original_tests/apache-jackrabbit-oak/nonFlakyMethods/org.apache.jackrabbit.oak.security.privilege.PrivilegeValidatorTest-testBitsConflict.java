@Test public void testBitsConflict(){
  try {
    Tree privTree=createPrivilegeTree();
    bitsProvider.getBits(JCR_READ).writeTo(privTree);
    root.commit();
    fail("Conflicting privilege bits property must be detected.");
  }
 catch (  CommitFailedException e) {
    assertEquals("OakConstraint0049: PrivilegeBits already in used.",e.getMessage());
  }
 finally {
    root.refresh();
  }
}
