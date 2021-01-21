@Test public void testWriteUnsupportedRestrictions() throws Exception {
  NodeUtil aceNode=new NodeUtil(root.getTree("/")).addChild("test",NT_REP_GRANT_ACE);
  Restriction invalid=new RestrictionImpl(PropertyStates.createProperty("invalid",vf.createValue(true)),false);
  try {
    provider.writeRestrictions("/test",aceNode.getTree(),ImmutableSet.<Restriction>of(invalid));
    fail("AccessControlException expected");
  }
 catch (  AccessControlException e) {
  }
}
