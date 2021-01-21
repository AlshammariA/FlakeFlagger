@Test public void testRestrictionWithInvalidType() throws Exception {
  NodeUtil restriction=createAcl().getChild(aceName).getChild(REP_RESTRICTIONS);
  restriction.setName(REP_GLOB,"rep:glob");
  try {
    root.commit();
    fail("Creating restriction with invalid type should fail.");
  }
 catch (  CommitFailedException e) {
    assertTrue(e.isAccessControlViolation());
  }
}
