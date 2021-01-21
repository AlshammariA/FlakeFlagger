@Test public void testMissingPrivilegeBits(){
  try {
    createPrivilegeTree();
    root.commit();
    fail("Missing privilege bits property must be detected.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isConstraintViolation());
  }
 finally {
    root.refresh();
  }
}
