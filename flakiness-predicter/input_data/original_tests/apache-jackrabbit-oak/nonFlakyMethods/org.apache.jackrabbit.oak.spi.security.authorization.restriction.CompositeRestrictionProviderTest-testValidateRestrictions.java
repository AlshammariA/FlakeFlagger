@Test public void testValidateRestrictions() throws Exception {
  NodeUtil aceNode=new NodeUtil(root.getTree("/")).addChild("test",NT_REP_GRANT_ACE);
  NodeUtil rNode=aceNode.addChild(REP_RESTRICTIONS,NT_REP_RESTRICTIONS);
  rNode.setBoolean("boolean",true);
  rNode.setValues("longs",new Value[]{vf.createValue(10),vf.createValue(290)});
  rNode.setString(REP_GLOB,"*");
  rNode.setNames(REP_NT_NAMES);
  provider.validateRestrictions("/test",aceNode.getTree());
  rNode.removeProperty("boolean");
  try {
    provider.validateRestrictions("/test",aceNode.getTree());
    fail("validation should detect missing mandatory restrictions");
  }
 catch (  AccessControlException e) {
  }
  rNode.setName("boolean","nt:base");
  try {
    provider.validateRestrictions("/test",aceNode.getTree());
    fail("validation should detect wrong restriction type");
  }
 catch (  AccessControlException e) {
  }
 finally {
    rNode.setBoolean("boolean",true);
  }
  rNode.setStrings(REP_GLOB,"*","/jcr:content");
  try {
    provider.validateRestrictions("/test",aceNode.getTree());
    fail("validation should detect wrong restriction type (multi vs single valued)");
  }
 catch (  AccessControlException e) {
  }
}
