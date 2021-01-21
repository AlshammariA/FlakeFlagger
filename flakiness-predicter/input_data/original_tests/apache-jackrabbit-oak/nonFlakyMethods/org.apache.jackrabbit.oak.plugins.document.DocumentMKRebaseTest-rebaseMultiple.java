@Test public void rebaseMultiple(){
  String branch=mk.branch(null);
  branch=mk.commit("/","+\"x\":{}",branch,null);
  String head=mk.commit("/","+\"y\":{}",null,null);
  branch=mk.rebase(branch,head);
  assertEquals("repeated rebase with same head must not create new branch revision",branch,mk.rebase(branch,head));
}
