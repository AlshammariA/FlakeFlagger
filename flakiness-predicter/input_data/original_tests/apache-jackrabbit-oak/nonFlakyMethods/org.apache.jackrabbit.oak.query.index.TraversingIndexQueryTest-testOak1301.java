@Test public void testOak1301() throws Exception {
  Tree t1=root.getTree("/").addChild("home").addChild("users").addChild("testing").addChild("socialgraph_test_user_4");
  t1.setProperty("jcr:primaryType","rep:User");
  t1.setProperty("rep:authorizableId","socialgraph_test_user_4");
  Tree s=t1.addChild("social");
  s.setProperty("jcr:primaryType","sling:Folder");
  Tree r=s.addChild("relationships");
  r.setProperty("jcr:primaryType","sling:Folder");
  Tree f=r.addChild("friend");
  f.setProperty("jcr:primaryType","sling:Folder");
  Tree sg=f.addChild("socialgraph_test_group");
  sg.setProperty("jcr:primaryType","nt:unstructured");
  sg.setProperty("id","socialgraph_test_group");
  Tree t2=root.getTree("/").addChild("home").addChild("groups").addChild("testing").addChild("socialgraph_test_group");
  root.commit();
  assertQuery("/jcr:root/home//*[@id='socialgraph_test_group']","xpath",ImmutableList.of("/home/users/testing/socialgraph_test_user_4/social/relationships/friend/socialgraph_test_group"));
  assertQuery("/jcr:root/home//social/relationships//*[@id='socialgraph_test_group']","xpath",ImmutableList.of("/home/users/testing/socialgraph_test_user_4/social/relationships/friend/socialgraph_test_group"));
}
