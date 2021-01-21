@Test public void testWriteRestrictions() throws Exception {
  NodeUtil aceNode=new NodeUtil(root.getTree("/")).addChild("test",NT_REP_GRANT_ACE);
  Set<Restriction> restrictions=ImmutableSet.of(provider.createRestriction("/test","boolean",vf.createValue(true)),provider.createRestriction("/test","longs"),provider.createRestriction("/test",REP_GLOB,vf.createValue("*")),provider.createRestriction("/test",REP_NT_NAMES,vf.createValue("nt:base",PropertyType.NAME),vf.createValue("nt:version",PropertyType.NAME)));
  provider.writeRestrictions("/test",aceNode.getTree(),restrictions);
}
