@Test public void testGetRestrictionPattern() throws Exception {
  NodeUtil aceNode=new NodeUtil(root.getTree("/")).addChild("test",NT_REP_GRANT_ACE);
  NodeUtil rNode=aceNode.addChild(REP_RESTRICTIONS,NT_REP_RESTRICTIONS);
  rNode.setString(REP_GLOB,"*");
  assertFalse(provider.getPattern("/test",aceNode.getTree()) instanceof CompositePattern);
  rNode.setBoolean("boolean",true);
  rNode.setValues("longs",new Value[]{vf.createValue(10),vf.createValue(290)});
  assertTrue(provider.getPattern("/test",rNode.getTree()) instanceof CompositePattern);
}
