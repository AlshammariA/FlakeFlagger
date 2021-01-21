@Test public void testNextNotUpdated(){
  try {
    Tree privTree=createPrivilegeTree();
    PrivilegeBits.getInstance(privilegesTree).writeTo(privTree);
    root.commit();
    fail("Outdated rep:next property must be detected.");
  }
 catch (  CommitFailedException e) {
    assertEquals("OakConstraint0043: Next bits not updated",e.getMessage());
  }
 finally {
    root.refresh();
  }
}
