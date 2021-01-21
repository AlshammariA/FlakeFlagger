@Test public void testInvalidRestriction() throws Exception {
  NodeUtil restriction=createAcl().getChild(aceName).getChild(REP_RESTRICTIONS);
  restriction.setString("invalid","value");
  try {
    root.commit();
    fail("Creating an unsupported restriction should fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
