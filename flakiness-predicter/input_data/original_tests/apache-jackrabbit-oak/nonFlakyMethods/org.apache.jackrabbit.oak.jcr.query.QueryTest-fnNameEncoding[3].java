@SuppressWarnings("deprecation") @Test public void fnNameEncoding() throws Exception {
  Session session=getAdminSession();
  session.getRootNode().addNode("123456_test_name");
  session.save();
  QueryManager qm=session.getWorkspace().getQueryManager();
  Query q;
  q=qm.createQuery("//*[jcr:like(fn:name(), '%123456%')]",Query.XPATH);
  assertEquals("/123456_test_name",getPaths(q));
  q=qm.createQuery("//*[fn:name() = '123456_test_name']",Query.XPATH);
  assertEquals("",getPaths(q));
}
