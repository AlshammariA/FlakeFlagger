@Test public void testValidateGlobRestriction() throws Exception {
  Tree t=new NodeUtil(root.getTree("/")).addChild("testTree","nt:unstructured").getTree();
  String path=t.getPath();
  AccessControlManager acMgr=getAccessControlManager(root);
  List<String> globs=ImmutableList.of("/1*/2*/3*/4*/5*/6*/7*/8*/9*/10*/11*/12*/13*/14*/15*/16*/17*/18*/19*/20*/21*","*********************");
  for (  String glob : globs) {
    JackrabbitAccessControlList acl=AccessControlUtils.getAccessControlList(acMgr,path);
    acl.addEntry(getTestPrincipal(),AccessControlUtils.privilegesFromNames(acMgr,PrivilegeConstants.JCR_READ),true,Collections.singletonMap(REP_GLOB,getValueFactory().createValue(glob)));
    acMgr.setPolicy(path,acl);
    try {
      provider.validateRestrictions(path,t.getChild(REP_POLICY).getChild("allow"));
      fail("AccessControlException expected.");
    }
 catch (    AccessControlException e) {
    }
 finally {
      acMgr.removePolicy(path,acl);
    }
  }
}
