@Test public void deleteChangedNode(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.getChildNode("a").setChildNode("aa");
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.getChildNode("a").remove();
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void deleteChangedNode(    NodeBuilder builder,    String name,    NodeState before){
      assertEquals("a",name);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
