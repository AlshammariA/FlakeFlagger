@Test public void deleteDeletedProperty(){
  NodeBuilder headBuilder=base.builder();
  headBuilder.removeProperty("x");
  NodeState head=headBuilder.getNodeState();
  NodeBuilder branchBuilder=base.builder();
  branchBuilder.removeProperty("x");
  NodeState branch=branchBuilder.getNodeState();
  RebaseDiff rebaseDiff=new RebaseDiff(head.builder()){
    @Override protected void deleteDeletedProperty(    NodeBuilder builder,    PropertyState before){
      assertEquals(createProperty("x",1),before);
      resolve();
    }
  }
;
  branch.compareAgainstBaseState(base,rebaseDiff);
  assertTrue(rebaseDiff.isResolved());
}
