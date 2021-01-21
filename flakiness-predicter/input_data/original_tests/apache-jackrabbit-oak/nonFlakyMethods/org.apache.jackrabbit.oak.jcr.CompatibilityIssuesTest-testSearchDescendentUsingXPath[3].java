@Test public void testSearchDescendentUsingXPath() throws Exception {
  Session adminSession=getAdminSession();
  String testNodePath="/home/users/geometrixx-outdoors/emily.andrews@mailinator.com/social/relationships/following/aaron.mcdonald@mailinator.com";
  Node testNode=JcrUtils.getOrCreateByPath(testNodePath,null,adminSession);
  testNode.setProperty("id","aaron.mcdonald@mailinator.com");
  AccessControlManager acMgr=adminSession.getAccessControlManager();
  JackrabbitAccessControlList tmpl=AccessControlUtils.getAccessControlList(acMgr,"/home/users/geometrixx-outdoors");
  ValueFactory vf=adminSession.getValueFactory();
  Map<String,Value> restrictions=new HashMap<String,Value>();
  restrictions.put("rep:glob",vf.createValue("*/social/relationships/following/*"));
  tmpl.addEntry(EveryonePrincipal.getInstance(),new Privilege[]{acMgr.privilegeFromName(Privilege.JCR_READ)},true,restrictions);
  acMgr.setPolicy(tmpl.getPath(),tmpl);
  adminSession.save();
  Session anonymousSession=getRepository().login(new GuestCredentials());
  QueryManager qm=anonymousSession.getWorkspace().getQueryManager();
  Query q=qm.createQuery("/jcr:root/home//social/relationships/following//*[@id='aaron.mcdonald@mailinator.com']",Query.XPATH);
  QueryResult r=q.execute();
  RowIterator it=r.getRows();
  Assert.assertTrue(it.hasNext());
}
