@Test public void testReadRestrictions() throws Exception {
  NodeUtil aceNode=new NodeUtil(root.getTree("/")).addChild("test",NT_REP_GRANT_ACE);
  aceNode.setBoolean("boolean",true);
  aceNode.setValues("longs",new Value[]{vf.createValue(10),vf.createValue(290)});
  aceNode.setString(REP_GLOB,"*");
  aceNode.setNames(REP_NT_NAMES);
  aceNode.setString("invalid","val");
  aceNode.setStrings("invalid2","val1","val2","val3");
  Set<Restriction> restrictions=provider.readRestrictions("/test",aceNode.getTree());
  assertEquals(4,restrictions.size());
  for (  Restriction r : restrictions) {
    String name=r.getDefinition().getName();
    if (!supported.contains(name)) {
      fail("read unsupported restriction");
    }
  }
}
