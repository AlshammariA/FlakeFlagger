@Test public void changeDeletedNode(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.getChildNode("a").remove();
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.getChildNode("a").setChildNode("aa");
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void changeDeletedNode(    NodeBuilder builder,    String name,    NodeState after){
      assertEquals("a",name);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
